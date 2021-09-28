package com.conurets.EmployeeInformationSystem.service;

import io.ebean.config.CurrentUserProvider;
import org.springframework.stereotype.Component;

@Component
public class CurrentUser implements CurrentUserProvider {

    public CurrentUser(){}

    @Override
    public Object currentUser() {
        return "NewUser";
    }
}
