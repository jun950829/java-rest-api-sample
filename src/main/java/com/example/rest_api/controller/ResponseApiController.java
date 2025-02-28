package com.example.rest_api.controller;

import com.example.rest_api.controller.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
//@RestController
@Controller
@RequestMapping("/api/v1")
public class ResponseApiController {

    @GetMapping("")
//    @RequestMapping(path = "", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity user() {
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(18);
        user.setEmail("hong@gmail.com");

        log.info("user: {}", user);

        var response = ResponseEntity
                .status(HttpStatus.OK)
                .header("x-custom", "hi")
                .body(user);

        return response;
    }


}
