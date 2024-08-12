package com.example.Client.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;


@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@Data
public class UserDTO{
    private Long userId;

    private String uuid;

    @NotEmpty(message = "Miss!!!")
    private String firstName;

    @NotEmpty(message = "Miss!!!")
    private String lastName;

    @NotEmpty(message = "Miss!!!")
    @Email(message = "Please!!!Try again")
    private String email;

    private Long phoneNumber;

    @NotEmpty(message = "Miss!!!")
    private String address;

    private Boolean gender;

    private String imagePath;

    private String password;

    private Set<String> roles;

    private String accessToken;
}
