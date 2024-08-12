package com.easy.tour.Tour_View.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileInfo {
    private String name;
    private String url;
    public FileInfo(String name, String url) {
        this.name = name;
        this.url = url;
    }

}
