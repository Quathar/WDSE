package com.quathar.wdse.form.model.validation.document;

import com.quathar.wdse.form.model.Params;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;

/**
 * <h1>Document Type Validator</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
public class DocumentTypeValidator implements ConstraintValidator<DocumentType, List<MultipartFile>> {

    // <<-CONSTANTS->>
    private static final long FILE_SIZE = 10485760; // 10MB
    private static final long REQUEST_SIZE = 31457280; // 30MB

    // <<-FIELD->>
    String _regex;
    long _counter;

    // <<-METHODS->>
    @Override
    public void initialize(DocumentType constraintAnnotation) {
        _regex = constraintAnnotation.regex();
    }

    @Override
    public boolean isValid(List<MultipartFile> value, ConstraintValidatorContext context) {
        if (value == null || value.get(0).isEmpty()) return true;

        // Deleting the existing resources in the documents directory
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(Params.DIRECTORY)) {
            for (Path file : ds)
                Files.delete(file);
        } catch (IOException e) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{form.error.document.delete}")
                    .addConstraintViolation();
            return false;
        }

        // Checking the files types and size, also the request size
        _counter = 0;
        for (MultipartFile file : value) {
            if (!file.getOriginalFilename().matches(_regex))
                return false;
            if (file.getSize() > FILE_SIZE) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("{form.error.document.size}")
                        .addConstraintViolation();
                return false;
            }
            _counter += file.getSize();
            if (_counter > REQUEST_SIZE) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("{form.error.document.size}")
                        .addConstraintViolation();
                return false;
            }
        }

        for (MultipartFile file : value)
            try (
                    BufferedOutputStream bos = new BufferedOutputStream(
                            new FileOutputStream(
                                    new File(
                                            Params.DIRECTORY.toString(),
                                            file.getOriginalFilename())
                            )
                    )
            ) {
                bos.write(file.getBytes());
                bos.flush();
            } catch (IOException e) {
                return false;
            }
        return true;
    }

}
