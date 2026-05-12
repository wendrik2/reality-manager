package com.reality.reality_manager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ← автоінкремент: 1, 2, 3...
    private Long id;

    private String address;
    private Double price;
    private Integer rooms;

    @Column(length = 1000)
    private String description;

    // --- Конструктори ---

    public Property() {}

    public Property(String address, Double price, Integer rooms, String description) {
        this.address = address;
        this.price = price;
        this.rooms = rooms;
        this.description = description;
    }

    // --- Getters та Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getRooms() { return rooms; }
    public void setRooms(Integer rooms) { this.rooms = rooms; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
