//package com.example.backend.service;
//
//import com.example.backend.model.Order;
//import com.example.backend.repository.OrderRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class OrderService {
//    @Autowired
//    private OrderRepository orderRepository;
//
//    public Order saveOrder(Order order) {
//        return orderRepository.save(order);
//    }
//
//    public List<Order> getAllOrders() {
//        return orderRepository.findAll();
//    }
//
//    public Order getOrderById(int orderId) {
//        return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
//    }
//
//    public void deleteOrder(int orderId) {
//        orderRepository.deleteById(orderId);
//    }
//}
