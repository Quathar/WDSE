package com.quathar.form.model.validation;

import com.quathar.form.model.Params;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DocumentTypeValidator implements ConstraintValidator<DocumentType, List<MultipartFile>> {

    // <<-CONSTANTS->>
    private static long fileSize = 10485760; // 10MB
    private static long requestSize = 31457280; // 30MB

    // <<-FIELD->>
    String _regex;
    long _counter;

    // <<-OVERRIDE->>
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
            if (file.getSize() > fileSize) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("{form.error.document.size}")
                        .addConstraintViolation();
                return false;
            }
            _counter += file.getSize();
            if (_counter > requestSize) {
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
