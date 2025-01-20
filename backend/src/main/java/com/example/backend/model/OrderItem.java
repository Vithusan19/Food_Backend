package com.example.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;

    private String name;

    private int quantity;

    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;  // Reference to the order
}
