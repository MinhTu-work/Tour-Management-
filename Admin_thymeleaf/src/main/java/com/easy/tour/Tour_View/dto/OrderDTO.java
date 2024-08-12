package com.easy.tour.Tour_View.dto;

import com.easy.tour.Tour_View.Enum.ApprovalStatus;
import com.easy.tour.Tour_View.Enum.Gender;
import com.easy.tour.Tour_View.utils.LocalDateAdapter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.JsonAdapter;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@Data
public class OrderDTO extends BaseObject{
    private Integer orderId;

    private ApprovalStatus approvalStatus;

    @NotEmpty(message = "This field cannot be empty")
    private String firstName;

    @NotEmpty(message = "This field cannot be empty")
    private String lastName;

//    @NotEmpty(message = "This field cannot be empty")
    private Gender gender;

    @NotNull(message = "This field cannot be empty")
    private Long phoneNumber;

    @NotEmpty(message = "This field cannot be empty")
    private String email;

    @NotEmpty(message = "This field cannot be empty")
    private String address;

    @Min(value = 0, message = "The value must be >= 0.")
    private int adult;

    @Min(value = 0, message = "The value must be >= 0.")
    private int children;

    @Min(value = 0, message = "The value must be >= 0.")
    private int pet;

    @NotEmpty(message = "This field cannot be empty")
    private String tourCode;

//    @NotEmpty(message = "This field cannot be empty")
    @JsonAdapter(LocalDateAdapter.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate bookingDate;

//    @Min(value = 0, message = "The value must be >= 0.")
//    @NotEmpty(message = "This field cannot be empty")
    private Long totalFee;

//    @NotEmpty(message = "This field cannot be empty")
    private String paymentMethod;
}
