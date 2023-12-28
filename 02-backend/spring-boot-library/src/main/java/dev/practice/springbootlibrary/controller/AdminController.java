package dev.practice.springbootlibrary.controller;

import dev.practice.springbootlibrary.requestModels.AddBookRequest;
import dev.practice.springbootlibrary.service.AdminService;
import dev.practice.springbootlibrary.utils.ExtractJWT;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("hhtp://localhost:3000")
@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/secure/add/book")
    public void postBook(@RequestHeader(value = "Authorization") String token,
                         @RequestBody AddBookRequest addBookRequest) throws Exception {
        String admin = ExtractJWT.payloadJWTExtraction(token, "userType");
        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administration page only");
        }
        adminService.postBook(addBookRequest);
    }


}
