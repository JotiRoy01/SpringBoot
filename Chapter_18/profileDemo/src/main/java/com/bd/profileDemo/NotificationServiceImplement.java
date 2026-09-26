package com.bd.profileDemo;

import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImplement implements NotificationService{

    @Override
    public String send(){
        return "here is a notification";
    }
}
