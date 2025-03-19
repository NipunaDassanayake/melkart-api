package com.melkart_api.melkart_api.controller.dto.request;

import lombok.Data;

@Data
public class AdminUpdateRequestDTO {
    private String name;
    private String email;
    private String password;
}
