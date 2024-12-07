package com.example.practice_api.domain.user;

import lombok.Data;

@Data
public class UserDTO {
    private String accountId;
    private int profileIconId;
    private long revisionDate;
    private String name;
    private String id;
    private String puuid;
    private long summonerLevel;
}
