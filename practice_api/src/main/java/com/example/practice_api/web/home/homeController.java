package com.example.practice_api.web.home;

import com.example.practice_api.domain.user.userDTO;
import com.example.practice_api.domain.user.userService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class homeController {

    @GetMapping("")
    public String home(){
        return "html/home/home";
    }

    @PostMapping(value = "/summonerByName")
    @ResponseBody
    public userDTO callSummonerByName(String summonerName){

        summonerName = summonerName.replaceAll(" ","%20");

        userDTO apiResult = userService.callRiotAPISummonerByName(summonerName);

        return apiResult;
    }
}
