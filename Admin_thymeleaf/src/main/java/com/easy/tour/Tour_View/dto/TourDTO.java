package com.easy.tour.Tour_View.dto;

import com.easy.tour.Tour_View.Enum.ApprovalStatus;
import com.easy.tour.Tour_View.Enum.PriceStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class TourDTO {
    String tourCode;

    @NotEmpty(message = "tourName must not be empty")
    String tourName;

    String description;

    Integer maximumSize;

    ApprovalStatus approvalStatus;

    PriceStatus priceStatus;

    String tourRequestCode;

    String tourImg1;

    String tourImg2;

    List<String> localDateList;
}
