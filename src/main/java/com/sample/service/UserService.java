package com.sample.service;

import com.sample.entity.User;

import java.util.List;

public interface UserService {

    List<User> listUsers(Integer tableSeq);

}
