package com.example.rest_api.controller;

import com.example.rest_api.controller.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping(path = "/hello")
    public String hello() {

        var html = "<html><body><h1>asdkjflskdjflsjflkjdjfklj</h1></body></html>";
        return html;
    }

    @GetMapping(path = "/echo/{message}")
    public String echo(@PathVariable(name = "message") String msg) {
        System.out.println("eche message: " + msg);
        var result = msg.toUpperCase();
        return result;
    }

    @GetMapping(path= "/query/{message}/age/{age}/is-man/{isMan}")
    public String query(
            @PathVariable(name = "message") String msg,
            @PathVariable(name = "age") Integer age,
            @PathVariable(name = "isMan") Boolean isMan
    ) {
        System.out.println("query content: " + msg + age + isMan);
        return msg + age + isMan;
    }

    @GetMapping(path = "/book")
    public String queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam(name = "issued_day") String issuedDay
    ) {

        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
        return category + issuedYear + issuedMonth + issuedDay;
    }

    @GetMapping(path = "/book2")
    public String queryParamDto(
            BookQueryParam bookQueryParam
    ) {

        System.out.println(bookQueryParam);
        return null;
    }

    @DeleteMapping(path = { "/user/{userName}/delete", "/user/{userName}/del" })
    public void delete(
            @PathVariable String userName
    ) {
        log.info("user-name : {}", userName);
    }
}
