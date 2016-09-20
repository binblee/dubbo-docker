package com.example.service.producer;

import com.example.service.Greetings;

/**
 * Created by libin on 9/19/16.
 */
public class GreetingsImpl implements Greetings {
    public String say(String name) {
        return "Greetings from " + name;
    }
}
