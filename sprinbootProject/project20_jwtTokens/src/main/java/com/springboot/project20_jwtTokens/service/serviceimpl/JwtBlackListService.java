package com.springboot.project20_jwtTokens.service.serviceimpl;


import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtBlackListService {
    private Set<String> blacklist = new HashSet<>();

    public void blacklistToken(String token) {
        blacklist.add(token);
        System.out.println(blacklist);
    }

    public boolean isTokenBlacklisted(String token) {
        return blacklist.contains(token);
    }
}
