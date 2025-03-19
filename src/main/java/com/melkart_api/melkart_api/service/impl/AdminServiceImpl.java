package com.melkart_api.melkart_api.service.impl;
import com.melkart_api.melkart_api.controller.dto.request.AdminRequestDTO;
import com.melkart_api.melkart_api.model.Admin;
import com.melkart_api.melkart_api.repository.AdminRepository;
import com.melkart_api.melkart_api.service.AdminService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
    private final AdminRepository adminRepository;

    @Override
    public Admin createAdmin(AdminRequestDTO adminRequestDTO) {
//        validateAdminRequest(adminRequestDTO); //ask chathuranga aiya whether we should use this

        try {
            Admin admin = new Admin();
            admin.setName(adminRequestDTO.getName());
            admin.setEmail(adminRequestDTO.getEmail());
            admin.setPassword(adminRequestDTO.getPassword());
            return adminRepository.save(admin);
        } catch (DataAccessException e) {
            logger.error("Failed to create admin due to database error: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to create admin due to database error", e);
        } catch (Exception e) {
            logger.error("Unexpected error occurred while creating admin: {}", e.getMessage(), e);
            throw new RuntimeException("Unexpected error occurred while creating admin", e);
        }
    }

    @Override
    public List<Admin> getAllAdmins() {
        try {
            return adminRepository.findAll();
        } catch (DataAccessException e) {
            logger.error("Failed to retrieve admins due to database error: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to retrieve admins due to database error", e);
        } catch (Exception e) {
            logger.error("Unexpected error occurred while retrieving admins: {}", e.getMessage(), e);
            throw new RuntimeException("Unexpected error occurred while retrieving admins", e);
        }
    }

//    private void validateAdminRequest(AdminRequestDTO adminRequestDTO) {
//        if (adminRequestDTO == null) {
//            throw new IllegalArgumentException("Admin request data cannot be null");
//        }
//        if (!StringUtils.hasText(adminRequestDTO.getName())) {
//            throw new IllegalArgumentException("Admin name cannot be empty or null");
//        }
//        if (!StringUtils.hasText(adminRequestDTO.getEmail())) {
//            throw new IllegalArgumentException("Admin email cannot be empty or null");
//        }
//        if (!StringUtils.hasText(adminRequestDTO.getPassword())) {
//            throw new IllegalArgumentException("Admin password cannot be empty or null");
//        }
//    }
}