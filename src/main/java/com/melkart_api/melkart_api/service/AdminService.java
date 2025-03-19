package com.melkart_api.melkart_api.service;

import com.melkart_api.melkart_api.controller.dto.request.AdminRequestDTO;
import com.melkart_api.melkart_api.model.Admin;

import java.util.List;

public interface AdminService {
    Admin createAdmin(AdminRequestDTO adminRequestDTO);
    List<Admin> getAllAdmins();
}

