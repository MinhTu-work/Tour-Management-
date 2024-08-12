package com.easy.tour.Tour_View.controller;

import com.easy.tour.Tour_View.consts.ApiPath;
import com.easy.tour.Tour_View.consts.UrlPath;
import com.easy.tour.Tour_View.dto.ReportDTO;
import com.easy.tour.Tour_View.response.ReportResponseDTO;
import com.easy.tour.Tour_View.utils.ParserDateTimeUtils;
import com.easy.tour.Tour_View.utils.ReportUtil;
import com.easy.tour.Tour_View.utils.RestTemplateUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@Controller
@Slf4j
public class ManagementController {
    @Autowired
    ParserDateTimeUtils parserDateTime;
    @Autowired
    RestTemplateUtils restTemplateUtils;

    @Autowired
    ReportUtil reportUtil;

    @GetMapping(UrlPath.MANAGEMENT_NAV_PAGE)
    public String showManagementNav(Model model){
        model.addAttribute("activeNav", "management");
        return "management/managementNav";
    }

    @GetMapping(UrlPath.MANAGEMENT_REPORT_PAGE)
    public String barChart(Model model, HttpServletRequest request){
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        ReportResponseDTO response = restTemplateUtils.getData(ApiPath.REPORT_GET_ALL,request ,ReportResponseDTO.class);
        Map<String, Long> surveyMap = new LinkedHashMap<>();
        Long totalTourist = 0L;
        BigDecimal totalMoney = BigDecimal.ZERO;
        surveyMap = reportUtil.getTouristMap(response.getList());
        System.out.println(surveyMap);
        for (ReportDTO reportDTO: response.getList()) {
            totalTourist+= reportDTO.getAmountTourist();
            totalMoney = totalMoney.add(reportDTO.getTotalPrice());
        }

        model.addAttribute("activeNav", "management");
        model.addAttribute("activeTab", "barChart");
        model.addAttribute("totalTourist", totalTourist);
        model.addAttribute("totalMoney", currencyFormat.format(totalMoney));
        model.addAttribute("surveyMap", surveyMap);
        return "management/barChart";
    }

    @GetMapping(UrlPath.REPORT_BY_MONTH)
    public ResponseEntity<Map<String, Object>> barChartByMonth(Integer id, Model model, HttpServletRequest request){
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        ReportResponseDTO response =  new ReportResponseDTO();
        if (id == null){
            response = restTemplateUtils.getData(ApiPath.REPORT_GET_ALL,request ,ReportResponseDTO.class);
        }
        else {
            response = restTemplateUtils.getData(ApiPath.REPORT_GET_BY_MONTH + "/" + id, request
                    ,ReportResponseDTO.class);
        }
        Long totalTourist = 0L;
        BigDecimal totalMoney = BigDecimal.ZERO;
        Map<String, Long> surveyMap = new LinkedHashMap<>();
        surveyMap = reportUtil.getTouristMap(response.getList());
        for (ReportDTO reportDTO: response.getList()) {
            totalTourist+= reportDTO.getAmountTourist();
            totalMoney = totalMoney.add(reportDTO.getTotalPrice());
        }
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("surveyMap", surveyMap);
        result.put("totalTourist", totalTourist);
        result.put("totalMoney", currencyFormat.format(totalMoney));
        return ResponseEntity.ok(result);
    }
}
