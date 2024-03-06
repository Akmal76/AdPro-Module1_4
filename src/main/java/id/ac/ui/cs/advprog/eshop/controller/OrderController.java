package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("/create")
    public String createOrderPage (Model model) {
//        Order order = new Order();
//        model.addAttribute("order", order);
        return "createOrder";
    }

    @GetMapping("/history")
    public String historyOrderPage () {
        return "orderHistory";
    }

    @PostMapping("/history")
    public String historyOrderPost () {
        return "orderHistory";
    }

    @GetMapping("/pay/{orderId}")
    public String payOrderPage () {
        return "payOrder";
    }

    @PostMapping("/pay/{orderId}")
    public String payOrderPost () {
        return "redirect:history";
    }
}
