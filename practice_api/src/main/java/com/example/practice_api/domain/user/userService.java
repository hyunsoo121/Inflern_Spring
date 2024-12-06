package com.example.practice_api.domain.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class userService {
        private static final ObjectMapper objectMapper = new ObjectMapper();

        private static String mykey = "riot api key";

        public static userDTO callRiotAPISummonerByName(String summonerName) {
            String serverUrl = "https://kr.api.riotgames.com";
            userDTO result = null;

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(serverUrl + "/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key=" + mykey))
                        .GET()
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == 200) {
                    result = objectMapper.readValue(response.body(), userDTO.class);
                }

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

            return result;
        }
    }
