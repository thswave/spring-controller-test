package com.springapp.mvc;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public boolean hello(String name) {
        return "thswave".equals(name);
    }
}
