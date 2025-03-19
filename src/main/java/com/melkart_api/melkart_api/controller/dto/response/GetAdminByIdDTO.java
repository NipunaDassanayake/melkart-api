package com.melkart_api.melkart_api.controller.dto.response;

import lombok.Data;

@Data
public class GetAdminByIdDTO {
    private Long id;
    private String name;
    private String email;

}
