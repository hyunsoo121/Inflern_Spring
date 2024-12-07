package com.example.practice_api.web.home;

import com.example.practice_api.domain.user.UserDTO;
import com.example.practice_api.domain.user.UserService;
import com.example.practice_api.domain.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class homeController {

    private final UserService userService = new UserServiceImpl();

    @GetMapping("")
    public String home(){
        return "html/home/home";
    }

    @PostMapping(value = "/summonerByName")
    @ResponseBody
    public UserDTO callSummonerByName(String summonerName){

        summonerName = summonerName.replaceAll(" ","%20");

        UserDTO apiResult = userService.callRiotAPISummonerByName(summonerName);

        return apiResult;
    }
}
