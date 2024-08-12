package com.example.Client.dto.Cart;
import com.example.Client.dto.TourDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {
    private Long id;

    private int quantity;

    private double unitPrice;

    @JsonIgnore
    private ShoppingCartDTO cart;

    private TourDTO tour;

    private String departureDay;

    private Double price;

}
