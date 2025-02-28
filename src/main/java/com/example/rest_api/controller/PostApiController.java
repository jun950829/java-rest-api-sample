package com.example.rest_api.controller;

import com.example.rest_api.controller.model.BookRequest;
import com.example.rest_api.controller.model.UserRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public BookRequest post(
        @RequestBody BookRequest req
    ) {
        System.out.println(req);

        return req;
    }

    @PostMapping("/user")
    public void User(
        @RequestBody UserRequest req
    ) {
        System.out.println(req);
    }
}
