package com.easy.tour.Tour_View.controller;

import com.easy.tour.Tour_View.consts.ApiPath;
import com.easy.tour.Tour_View.consts.UrlPath;
import com.easy.tour.Tour_View.dto.OrderDTO;
import com.easy.tour.Tour_View.dto.TourDTO;
import com.easy.tour.Tour_View.response.OrderResponseDTO;
import com.easy.tour.Tour_View.response.TourResponseDTO;
import com.easy.tour.Tour_View.utils.RestTemplateUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class OrderController {
    @Autowired
    RestTemplateUtils restTemplateUtils;

    @GetMapping(value= UrlPath.ORDER_NAV_PAGE)
    public String orderNav(Model model) {
        model.addAttribute("activeNav", "order");
        return "order/orderNav";
    }

    @GetMapping(value = UrlPath.ORDER_VIEW_ALL_PAGE)
    public String orderViewAllPage(
            Model model,
            HttpServletRequest request
    ) {
        OrderResponseDTO response = restTemplateUtils.getData(
                ApiPath.ORDER_GET_All,
                request,
                OrderResponseDTO.class);
        model.addAttribute("activeNav", "order");
        model.addAttribute("activeTab", "orderView");
        model.addAttribute("orderList", response.getList());
        return "order/orderViewAll";
    }

    @GetMapping(value = UrlPath.ORDER_CREATE_PAGE)
    public String showOrderCreatePage(Model model, HttpServletRequest request) throws JsonProcessingException {
        OrderDTO orderDto = new OrderDTO();
        TourResponseDTO tourResponseDTO = restTemplateUtils.getData(ApiPath.TOUR_GET_All_FOR_BOOKING, request ,TourResponseDTO.class);
        List<TourDTO> tourDTOList = tourResponseDTO.getList();

        ObjectMapper objectMapper = new ObjectMapper();
        String tourListJson = objectMapper.writeValueAsString(tourDTOList);

        model.addAttribute("activeNav", "order");
        model.addAttribute("activeTab", "orderCreate");
        model.addAttribute("normalTourList", tourDTOList);
        model.addAttribute("tourListJson", tourListJson);
        model.addAttribute("orderDto", orderDto);
        return "order/orderCreate";
    }

    @PostMapping(value = UrlPath.ORDER_CREATE_PAGE, params = "action" )
    public String orderCreateSubmit(
            HttpServletRequest request,
            Model model,
            @RequestParam(value="action", required = true) String action,
            @Valid @ModelAttribute("orderDto") OrderDTO orderDto,
            BindingResult result
    ) throws JsonProcessingException {

        if (result.hasErrors()) {
            // Populate the model with the same attributes as in GET method
            TourResponseDTO tourResponseDTO = restTemplateUtils.getData(ApiPath.TOUR_GET_All_FOR_BOOKING, request, TourResponseDTO.class);
            List<TourDTO> tourDTOList = tourResponseDTO.getList();

            ObjectMapper objectMapper = new ObjectMapper();
            String tourListJson = objectMapper.writeValueAsString(tourDTOList);

            model.addAttribute("activeNav", "order");
            model.addAttribute("activeTab", "orderCreate");
            model.addAttribute("normalTourList", tourDTOList);
            model.addAttribute("tourListJson", tourListJson);
            return "order/orderCreate";
        }

        if ("create".equals(action)) {
            OrderResponseDTO responseDto = restTemplateUtils.postData(
                    orderDto,
                    ApiPath.ORDER_CREATE,
                    request,
                    OrderResponseDTO.class
            );
        }
        return "redirect:" + UrlPath.ORDER_VIEW_ALL_PAGE;
    }

    @GetMapping(value = UrlPath.ORDER_EDIT_PAGE)
    public String orderEditPage(
            @RequestParam("id") String orderId,
            Model model,
            HttpServletRequest request
    ) throws JsonProcessingException {
        OrderResponseDTO orderResponseDTO = restTemplateUtils.getData(ApiPath.ORDER_GET_BY_ID + orderId, request,
                OrderResponseDTO.class);
        TourResponseDTO tourResponseDTO =  restTemplateUtils.getData(ApiPath.TOUR_GET_BY_TOUR_CODE + orderResponseDTO.getData().getTourCode(), request,
                TourResponseDTO.class);

        TourDTO tourDto = tourResponseDTO.getData();
        List<String> departureDateList = tourDto.getLocalDateList();

        ObjectMapper objectMapper = new ObjectMapper();
        String dateListJson = objectMapper.writeValueAsString(departureDateList);

        model.addAttribute("orderDto", orderResponseDTO.getData());
        model.addAttribute("tourName", tourDto.getTourName());
        model.addAttribute("dateListJson", dateListJson);
        return "order/orderEdit";
    }

//    @PostMapping(value = UrlPath.ORDER_EDIT_PAGE, params = "action" )
//    public String orderUpdateSubmit(
//            @RequestParam("id") String orderId,
//            @RequestParam(value="action", required = true) String action,
//            HttpServletRequest request,
//            @Valid @ModelAttribute("orderDto") OrderDTO orderDto,
//            BindingResult result,
//            Model model
//    ) {
//        if("update".equals(action)) {
//            OrderResponseDTO responseDto = restTemplateUtils.putData(
//                    orderDto,ApiPath.ORDER_UPDATE + orderId, request, OrderResponseDTO.class
//            );
//        }
//        return "redirect:" + UrlPath.ORDER_VIEW_ALL_PAGE;
//    }

    @PostMapping(value = UrlPath.ORDER_EDIT_PAGE, params = "action" )
    public String orderUpdateSubmit(
            @RequestParam("id") String orderId,
            @RequestParam(value="action", required = true) String action,
            HttpServletRequest request,
            @Valid @ModelAttribute("orderDto") OrderDTO orderDto,
            BindingResult result,
            Model model
    ) throws JsonProcessingException {
        if("update".equals(action)) {
            if (result.hasErrors()) {
                // Retrieve tour information again if there are validation errors
                OrderResponseDTO orderResponseDTO = restTemplateUtils.getData(
                        ApiPath.ORDER_GET_BY_ID + orderId,
                        request,
                        OrderResponseDTO.class);
                TourResponseDTO tourResponseDTO =  restTemplateUtils.getData(
                        ApiPath.TOUR_GET_BY_TOUR_CODE + orderResponseDTO.getData().getTourCode(),
                        request,
                        TourResponseDTO.class);

                TourDTO tourDto = tourResponseDTO.getData();
                List<String> departureDateList = tourDto.getLocalDateList();

                ObjectMapper objectMapper = new ObjectMapper();
                String dateListJson = objectMapper.writeValueAsString(departureDateList);

                model.addAttribute("tourName", tourDto.getTourName());
                model.addAttribute("dateListJson", dateListJson);
                return "order/orderEdit";
            }

            OrderResponseDTO responseDto = restTemplateUtils.putData(
                    orderDto, ApiPath.ORDER_UPDATE + orderId, request, OrderResponseDTO.class
            );
        }
        return "redirect:" + UrlPath.ORDER_VIEW_ALL_PAGE;
    }

    @GetMapping(value = UrlPath.ORDER_DELETE)
    public String orderDeleteTrigger(
            @RequestParam("id") String orderId,
            HttpServletRequest request
    ) {
        restTemplateUtils.deleteData(orderId, ApiPath.ORDER_DELETE + orderId, request, OrderResponseDTO.class);
        return "redirect:" + UrlPath.ORDER_VIEW_ALL_PAGE;
    }

}
