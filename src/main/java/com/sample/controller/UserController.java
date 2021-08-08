package com.sample.controller;

import com.sample.entity.User;
import com.sample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    public ResponseEntity<List<User>> listUsers(@RequestParam("tableSeq") Integer tableSeq) {
        List<User> users = userService.listUsers(tableSeq);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
