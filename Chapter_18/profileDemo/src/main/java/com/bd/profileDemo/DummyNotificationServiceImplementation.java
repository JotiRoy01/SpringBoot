package com.bd.profileDemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DummyNotificationServiceImplementation implements NotificationService{

    @Override
    public String send() {

        return "Here is a dummy notification";
    }
}
