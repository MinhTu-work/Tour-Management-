package com.easy.tour.Tour_View.dto;

import com.easy.tour.Tour_View.validator.DigitsOnly;
import com.easy.tour.Tour_View.validator.NotWhiteSpace;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@Data
public class UserDTO extends BaseObject {

    private String uuid;

    @Length(max = 10, message = "First Name must not exceed 10 characters.")
    @NotWhiteSpace
    @NotEmpty(message = "You must enter Last Name field.")
    private String lastName;

    @Length(max = 10, message = "Last Name must not exceed 10 characters.")
    @NotWhiteSpace
    @NotEmpty(message = "You must enter First Name field.")
    private String firstName;

    @NotWhiteSpace
    @NotEmpty(message = "You must enter Email field.")
    @Email(message = "You must enter a valid email address.")
    private String email;

    private String password;

    private Boolean gender;

    @Length(max = 10, message = "Phone Number must not exceed 10 digits.")
    @DigitsOnly
    @NotEmpty(message = "You must enter Phone Number field.")
    private String phoneNumber;

    private String avatarImg;

    @NotEmpty(message = "You must choose a role.")
    private String role;

    private Set<String> roles = new HashSet<>();

    private Date createdDate;

    private Date modifiedDate;

    private String createdBy;

    private String modifiedBy;
}
