package com.example.Client.controller;
import com.example.Client.consts.ApiPath;
import com.example.Client.consts.UrlPath;
import com.example.Client.dto.CustomerDTO;
import com.example.Client.dto.DepartureDateDTO;
import com.example.Client.response.DepartureDateResponDTO;
import com.example.Client.response.TourResponseDTO;
import com.example.Client.utils.RestTemplateUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@Controller
public class TourController {
    @Autowired
    RestTemplateUtils restTemplateUtils;
    @Autowired
    RestTemplate restTemplate;
    @GetMapping(UrlPath.TOUR_PAGE)
    public String showTourlist(Model model, HttpServletRequest request){
        DepartureDateResponDTO response = restTemplateUtils.getData(ApiPath.DEPARTURE_DATE_GET_ALL_LIST,request, DepartureDateResponDTO.class);
        List<DepartureDateDTO> departureDateDTOList = response.getList();
        model.addAttribute("departureDate", departureDateDTOList);
        return "tour";
    }
    // show Home Tour
    @GetMapping(UrlPath.HOME_TOUR)
    public String showHomeTour(Model model, HttpServletRequest request) {
        DepartureDateResponDTO response = restTemplateUtils.getData(ApiPath.DEPARTURE_DATE_GET_ALL_LIST,request,DepartureDateResponDTO.class);
        model.addAttribute("departureDate", response.getList());
        return "home";
    }

    @GetMapping(UrlPath.TOUR_DETAIL + "/{idDepartureDate}")
    public String showTourDetail(@PathVariable("idDepartureDate") int id, Model model, HttpServletRequest request) {
        DepartureDateResponDTO response = restTemplateUtils.getData(ApiPath.DEPARTURE_DATE_GET_BY_ID + "/" +id, request, DepartureDateResponDTO.class);

        model.addAttribute("departure", response.getData());
        return "tourDetail";
    }
    @RequestMapping("/about")
    public String about(){
        return "about";
    }
    @RequestMapping("/order")
    public String order(){
        return "order";
    }
    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }
    @RequestMapping("/accList")
    public String accList(){
        return "accList";
    }

    // Aphu
    @GetMapping(UrlPath.HOME_PAGE)
    public String showHomePage(){

        return "homePage";
    }
//    @GetMapping(UrlPath.HOME_TOUR)
//    public String home(HttpSession session, Model model) {
//        CustomerDTO loggedInUser = (CustomerDTO) session.getAttribute("loggedInUser");
//        System.out.println(loggedInUser);
//        String customerJson = null;
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            customerJson = objectMapper.writeValueAsString(loggedInUser);
//
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        model.addAttribute("customerJson",customerJson);
//
//        return "home";

    public static byte[] convertFileToByteArray(String filePath) {
        try {
            File file = new File(filePath);
            return Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            throw new RuntimeException("Error converting file to byte array", e);
        }
    }

//    }

}
