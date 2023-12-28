package com.quathar.wdse.form.model;

import com.quathar.wdse.form.model.validation.ageMatch.AgeMatch;
import com.quathar.wdse.form.model.validation.applicationError.ApplicationError;
import com.quathar.wdse.form.model.validation.autoincrement.Autoincrement;
import com.quathar.wdse.form.model.validation.checkdata.CheckDataVoid;
import com.quathar.wdse.form.model.validation.document.DocumentType;
import com.quathar.wdse.form.model.validation.minAge.MinAge;
import com.quathar.wdse.form.model.validation.passwdMatch.PasswdMatch;
import com.quathar.wdse.form.model.validation.valueExists.ValueExists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

/**
 * <h1>Parameters Model</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApplicationError
@Autoincrement
@PasswdMatch
@AgeMatch
@CheckDataVoid
public class Params {

    // <<-CONSTANTS->>
    public static final String GENDERS   = "GENDERS";
    public static final String COUNTRIES = "COUNTRIES";
    public static final String MUSIC     = "MUSIC";
    public static final String HOBBIES   = "HOBBIES";
    public static final Path   DIRECTORY = Path.of(
            System.getProperty("user.dir"),
            "src", "main", "resources", "documents"
    );

    // <<-FIELD->>
    private String language;
    private String color;
    // <<=FIELDS=>>
    @NotNull(message = "{form.error.iterations.notNull}")
    private String iterations;

    // <<-USER DATA FIELDS->>
    @NotNull(message = "{form.error.name.notNull}")
    @NotBlank(message = "{form.error.name.notBlank}")
    private String name;
    @NotNull(message = "{form.error.passwd.notNull}")
    @NotBlank(message = "{form.error.passwd.notBlank}")
    @Size(min = 6, max = 12, message = "{form.error.passwd.size}")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zñ])(?=.*[A-ZÑ])(?=.*[!#$%&]).*", message = "{form.error.passwd.pattern}")
    private String passwd;
    @NotNull(message = "{form.error.confirmPasswd.notNull}")
    @NotBlank(message = "{form.error.confirmPasswd.notBlank}")
    // @PasswdMatch
    private String confirmPasswd;

    // <<-PERSONAL DATA FIELDS->>
    @NotNull(message = "{form.error.selectedGender.notNull}")
    @ValueExists(list = GENDERS, message = "{form.error.selectedGender.valueNotExists}")
    private String selectedGender;
    @NotNull(message = "{form.error.birthdate.notNull}")
//    @NotBlank(message="{form.error.birthdate.notBlank}")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @MinAge
    private LocalDate birthdate;
    @NotNull(message = "{form.error.age.notNull}")
    private String age;
    @NotNull(message = "{form.error.selectedCountry.notNull}")
    @ValueExists(list = COUNTRIES, message = "{form.error.selectedCountry.valueNotExists}")
    // FALTA : Revisar por q NotBlank VER ENUNCIADO
    private String selectedCountry;

    // <<-CONTACT DATA FIELDS->>
    // Flag Test, Campo para un input del teléfono con banderas, descartado
//    private String phone;
    @NotNull(message = "{form.error.prefix.notNull}")
    @ValueExists(list = Params.COUNTRIES, message = "{form.error.selectedCountry.valueNotExists}")
    private String prefix;
    @NotNull(message = "{form.error.mobilePhone.notNull}")
    @Size(max = 9, message = "{form.error.mobilePhone.size}")
    private String mobilePhone;
    @NotNull(message = "{form.error.email.notNull}")
    @Pattern(regexp = "([a-z0-9!#$%&'*+\\/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+\\/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?)?",
            message = "{form.error.email.pattern}")
    private String email;
    @NotNull(message = "{form.error.url.notNull}")
    private String url;

    // <<-OTHER INFO FIELDS->>
    @NotNull(message = "{form.error.document.notNull}")
    @DocumentType(regex = "([^\\s]+(\\.(?i)(pdf|jpg|jpeg|gif))$)")
    private List<MultipartFile> document;
    private List<String> selectedMusic;
    private List<String> selectedHobbies;
    @NotNull(message = "{form.error.comments.notNull}")
    private String comments;

    // <<-FORM OPERATIONS FIELDS->>
    @NotNull(message = "{form.error.license.notNull}")
    private Boolean license;
    private Icon icon;
    private Integer counter = 0;

}
