package com.example.Client.dto;

import com.example.Client.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@Data
@ToString
public class DepartureDateDTO extends BaseEntity {
    int id;
    String tourCode;
    String departureDate;
     String tourName;
     String description;
     Integer maximumSize;
     String tourImg1;
     String tourImg2;
     BigDecimal adult;
     BigDecimal children;
     String base641;
     String base642;

}
