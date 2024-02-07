package id.ac.ui.cs.advprog.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomePageController {
    @GetMapping("/")
    public String homePage() {
        return "homePage";
    }
}