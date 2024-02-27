package br.com.jaa.api.features.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {

    @NotBlank(message = "user-email-is-required")
    @Email(message = "user-email-is-invalid")
    private String email;
    @NotBlank(message = "user-password-is-required")
    private String password;
}
