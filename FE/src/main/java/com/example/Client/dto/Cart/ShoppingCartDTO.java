package com.example.Client.dto.Cart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDTO {
    private Long id;

    private double totalPrice;

    private int totalItems;
    @JsonIgnore
    private Set<CartItemDTO> cartItems;

}
