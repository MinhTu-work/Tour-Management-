package com.example.Client.controller;

import com.example.Client.dto.UserDTO;
import com.example.Client.response.UserResponseDTO;
import com.example.Client.utils.RestTemplateUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import static com.example.Client.consts.ApiPath.*;
import static com.example.Client.consts.UrlPath.*;


@Controller
public class AccCusController {
    @Autowired
    RestTemplateUtils restTemplateUtils;
    //
    @GetMapping(ACCOUNT_INFO + "/{userId}")
    public String findById(@PathVariable(value = "userId") Integer userId , Model model, HttpServletRequest request) {

       UserResponseDTO response = restTemplateUtils.getData( ACCOUNT_DETAIL_FIND_BY_ID + "/" + userId, request, UserResponseDTO.class);
       model.addAttribute("account",response.getData());
        return "acc-list";
    }

    //
    @GetMapping(UPDATE_FORM + "/{userId}")
    public String updateById(@PathVariable(value = "userId") Integer userId ,Model model, HttpServletRequest request) {
        UserResponseDTO response = restTemplateUtils.getData( FIND_BY_ID_UPDATE + "/" + userId, request,UserResponseDTO.class);
        model.addAttribute("account",response.getData());
        return "update-acc";
    }

    //
    @PostMapping(ACCOUNT_UPDATE + "/{userId}")
    public String update(@PathVariable(value = "userId") Long userId,
                         @Valid @ModelAttribute(value = "account") UserDTO userDTO,
                         Model model,
                         @RequestParam("image") MultipartFile file,
                         HttpServletRequest request) throws IOException {
        // Lưu tệp tin được upload lên
        String fileName = UUID.randomUUID().toString() + "." + StringUtils.getFilenameExtension(file.getOriginalFilename()) ;
        Path path = Paths.get(UPLOAD_DIRECTORY, fileName);
        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());
        userDTO.setImagePath(UPLOAD_DIRECTORY + fileName);
        // Lấy về thông tin người dùng từ server
        UserResponseDTO response = restTemplateUtils.putData(userDTO, ACCOUNT_DETAIL_UPDATE + "/" + userId, request, UserResponseDTO.class);
        model.addAttribute("account", response.getData());
        return "acc-list";
    }
}

