package com.example.Client.response;

import com.example.Client.dto.UserDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserResponseDTO extends ResponseDTO<UserDTO> {
    private String accessToken;
    private String tokenType;
}
