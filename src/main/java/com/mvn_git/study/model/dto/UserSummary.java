package com.mvn_git.study.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSummary {
    private final String username;
    private final String email;

    public UserSummary(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // getters
}

