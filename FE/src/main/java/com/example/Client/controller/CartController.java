package com.example.Client.controller;

import com.example.Client.consts.ApiPath;
import com.example.Client.consts.UrlPath;
import com.example.Client.dto.TourDTO;
import com.example.Client.response.Cart.CartResponseDTO;
import com.example.Client.utils.RestTemplateUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@Controller
public class CartController {
    @Autowired
    RestTemplateUtils restTemplateUtils;

    @GetMapping(UrlPath.CART_INSERT_CART_ITEM + "/{tourCode}" + "/{departureDate}" + "/{price}")
    public String insertItemCart(@PathVariable("tourCode") String tourCode,
                                 @PathVariable("departureDate") String departureDate,
                                 @PathVariable("price") BigDecimal price,
                                 Model model, HttpServletRequest request) {
        TourDTO tourDTO = new TourDTO();
        tourDTO.setTourCode(tourCode);
        tourDTO.setDepartureDate(departureDate);
        tourDTO.setAdult(price);
        CartResponseDTO cartResponseDTO = restTemplateUtils.postData(tourDTO, ApiPath.ADD_CART_ITEM_INTO_CART, request, CartResponseDTO.class);
        return "redirect:" + UrlPath.CART_ITEM_FIND_ALL;
    }
    @GetMapping(UrlPath.CART_ITEM_FIND_ALL)
    public String cartFindById(Model model, HttpServletRequest request){
        CartResponseDTO cartResponseDTO = restTemplateUtils.getData(ApiPath.CART_FIND_BY_ID + "/" + 1, request, CartResponseDTO.class);

        model.addAttribute("cartItems", cartResponseDTO.getData().getCartItems());
        return "cart";
    }
}
