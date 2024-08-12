package com.easy.tour.Tour_View.utils;

import com.easy.tour.Tour_View.dto.ReportDTO;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportUtil<T> {
    private static final Map<String, String> SITES_MAP = Collections.unmodifiableMap(new HashMap<String, String>() {{
        put("NT", "Nha Trang");
        put("VT", "Vung Tau");
        put("HC", "Ho Chi Minh");
        put("TH", "Thanh Hoa");
    }});


    public Map<String, Long> getTouristMap(List<ReportDTO> list){
        Map<String, Long> touristMap = new HashMap<>();
        for (ReportDTO report : list) {
            String locationKey = report.getTourCode().substring(0, 2);
            String location = SITES_MAP.get(locationKey);
            Long amountTourist = report.getAmountTourist();
            touristMap.merge(location, amountTourist, Long::sum);
        }
        return touristMap;
    }
}
