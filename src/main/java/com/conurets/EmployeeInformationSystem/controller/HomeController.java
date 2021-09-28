package com.conurets.EmployeeInformationSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Home")
public class HomeController {

    @RequestMapping("/Index")
    public String Index() {
        return "Index";
    }

    @RequestMapping("/Save")
    public String Save() {
       return "Save";
    }

    @RequestMapping("/Edit/{id}")
    public String Edit() {
        return "Edit";
    }

}
