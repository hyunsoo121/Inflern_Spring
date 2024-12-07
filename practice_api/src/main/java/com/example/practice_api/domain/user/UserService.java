package com.example.practice_api.domain.user;

import org.springframework.stereotype.Service;

public interface UserService {
    UserDTO callRiotAPISummonerByName(String summonerName);
}
