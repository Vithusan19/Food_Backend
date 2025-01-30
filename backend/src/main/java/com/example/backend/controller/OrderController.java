package com.example.backend.controller;

import com.example.backend.model.Order;
import com.example.backend.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        Order savedOrder = orderService.saveOrder(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    // Get Orders by User ID
    @GetMapping("/user/{userid}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable int userid) {
        List<Order> orders = orderService.getOrdersByUserId(userid);
        if (orders.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(orders);
    }

    // Update Order Status
    @PostMapping("/{orderid}/status")
    public ResponseEntity<String> updateOrderStatus(@PathVariable int orderid) {
        boolean updated = orderService.updateOrderStatus(orderid, "finished");
        if (updated) {
            return ResponseEntity.ok("Order status updated to 'finished'");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Order is already completed or cancelled.");
        }
    }

}
