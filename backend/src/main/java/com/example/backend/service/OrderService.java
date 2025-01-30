package com.example.backend.service;

import com.example.backend.model.Order;
import com.example.backend.model.OrderItem;
import com.example.backend.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) {
        order.getOrderItems().forEach(orderItem -> orderItem.setOrder(order));
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public List<Order> getOrdersByUserId(int userId) {
        return orderRepository.findByUserid(userId);
    }

    @Transactional
    public boolean updateOrderStatus(int orderId, String newStatus) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            if (order.getStatus().equalsIgnoreCase("pending")) {
                order.setStatus(newStatus);
                orderRepository.save(order);
                return true;
            }
        }
        return false;
    }
}
