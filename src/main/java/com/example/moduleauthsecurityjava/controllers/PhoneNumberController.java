package com.example.moduleauthsecurityjava.controllers;

import com.example.moduleauthsecurityjava.models.PhoneNumberRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneNumberController {

    @PostMapping("/phone-number")
    public ResponseEntity<String> phoneNumberSubmit(@ModelAttribute PhoneNumberRequest request) {
        if (request.getPhone().matches("^(\\+44|0)\\d{10}$")) {
            System.out.println("\033[96mThe user submitted the phone number: " + request.getPhone() + "\033[0m");
            return ResponseEntity.ok("Successful!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Phone Number Invalid. Please enter a valid phone number (e.g., 07123456789).");
        }
    }
}
