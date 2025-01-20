//package com.example.backend.controller;
//
//
//
//import com.example.backend.model.Order;
//import com.example.backend.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/orders")
//public class OrderController {
//    @Autowired
//    private OrderService orderService;
//
//    @PostMapping
//    public Order createOrder(@RequestBody Order order) {
//        return orderService.saveOrder(order);
//    }
//
//    @GetMapping
//    public List<Order> getAllOrders() {
//        return orderService.getAllOrders();
//    }
//
//    @GetMapping("/{id}")
//    public Order getOrderById(@PathVariable int id) {
//        return orderService.getOrderById(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteOrder(@PathVariable int id) {
//        orderService.deleteOrder(id);
//        return "Order deleted successfully!";
//    }
//}
//
