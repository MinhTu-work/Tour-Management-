package com.easy.tour.Tour_View.dto;

import com.easy.tour.Tour_View.validator.NotWhiteSpace;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@Data
public class AuthenticationDTO extends BaseObject {

    @NotWhiteSpace
    @NotEmpty(message = "You must enter Email field.")
    @Email(message = "You must enter a valid email address.")
    private String email;

    @NotWhiteSpace
    @NotEmpty(message = "You must enter password field.")
    private String password;
}
