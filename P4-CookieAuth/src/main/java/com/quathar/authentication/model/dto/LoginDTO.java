package com.quathar.authentication.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * <h1>Log in DTO (Data Transfer Object)</h1>
 *
 * @since 2023-06-26
 * @version 1.0
 * @author Q
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDTO {

    // <<-FIELDS->>
    @NotNull
    @NotBlank
    private String user;
    @NotNull
    @NotBlank
    private String password;

}