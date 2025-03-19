package com.melkart_api.melkart_api.controller;

import com.melkart_api.melkart_api.controller.dto.request.AdminRequestDTO;
import com.melkart_api.melkart_api.controller.dto.request.AdminUpdateRequestDTO;
import com.melkart_api.melkart_api.controller.dto.response.GetAllAdminsDTO;
import com.melkart_api.melkart_api.model.Admin;
import com.melkart_api.melkart_api.service.AdminService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/admins")
@Validated
public class AdminController {
    private final AdminService adminService;

    @PostMapping
    public ResponseEntity<Admin> createAdmin(@Valid @RequestBody AdminRequestDTO adminRequestDTO) {
        Admin createdAdmin = adminService.createAdmin(adminRequestDTO);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GetAllAdminsDTO>> getAllAdmins() {
        List<GetAllAdminsDTO> admins = adminService.getAllAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public void deleteAdmin(@PathVariable Long id){
        adminService.deleteAdmin(id);
    }

    @PutMapping("/id")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody AdminUpdateRequestDTO adminUpdateRequestDTO) {
         Admin admin1 = adminService.updateAdmin(id, adminUpdateRequestDTO);
        return ResponseEntity.ok(admin1);
    }
}




