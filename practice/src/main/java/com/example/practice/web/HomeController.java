package com.example.practice.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public String home(){
        return "html/home/home";
    }

    @PostMapping("")
    public ResponseEntity<Map<String, Object>> handlePost(@RequestBody Map<String, Object> requestData) {

        System.out.println("Received Data: " + requestData);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("received", requestData);

        return ResponseEntity.ok(response);
    }


}
