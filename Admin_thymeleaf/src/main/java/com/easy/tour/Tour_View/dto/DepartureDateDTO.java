package com.easy.tour.Tour_View.dto;

import com.easy.tour.Tour_View.utils.LocalDateAdapter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.JsonAdapter;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class DepartureDateDTO extends BaseObject{
    @NotEmpty(message = "You must enter tourCode.")
    String tourCode;

    @NotNull(message = "You must enter the departureDate.")
    @JsonAdapter(LocalDateAdapter.class)
    LocalDate departureDate;
}
