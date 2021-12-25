package main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String getInfoForAllEmployees() {
        return "view-for-all-employees";
    }

    @GetMapping("/hr-info")
    public String getInfoForHr() {
        return "view-for-hr";
    }

    @GetMapping("/manager-info")
    public String getInfoForManagers() {
        return "view-for-managers";
    }
}
