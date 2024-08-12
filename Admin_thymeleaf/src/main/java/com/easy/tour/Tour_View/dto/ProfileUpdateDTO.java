package com.easy.tour.Tour_View.dto;

import com.easy.tour.Tour_View.validator.DigitsOnly;
import com.easy.tour.Tour_View.validator.NotWhiteSpace;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@Data
public class ProfileUpdateDTO extends BaseObject {

    @NotWhiteSpace
    @NotEmpty(message = "You must enter Last Name field.")
    private String lastName;

    @NotWhiteSpace
    @NotEmpty(message = "You must enter First Name field.")
    private String firstName;

    private Boolean gender;

    @Length(max = 10, message = "Phone Number must not exceed 10 digits.")
    @DigitsOnly
    @NotEmpty(message = "You must enter Phone Number field.")
    private String phoneNumber;

    private String uuid;

    private String avatarImg;
}
