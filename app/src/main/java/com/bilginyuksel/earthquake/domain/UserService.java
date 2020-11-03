package com.bilginyuksel.earthquake.domain;

import com.bilginyuksel.earthquake.domain.model.User;

public interface UserService {

    void register(User user);
    void login();
    void logout();
}
