package com.example.practice_api.domain.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Value("${spring.riot.key}")
        private String mykey;


        @Override
        public UserDTO callRiotAPISummonerByName(String summonerName) {
            String serverUrl = "https://kr.api.riotgames.com";
            UserDTO result = null;

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(serverUrl + "/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key=" + mykey))
                        .GET()
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.statusCode());
                if (response.statusCode() == 200) {
                    result = objectMapper.readValue(response.body(), UserDTO.class);

                }

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

            return result;
        }
    }
