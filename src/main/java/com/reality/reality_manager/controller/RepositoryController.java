package com.reality.reality_manager.controller;

import com.reality.reality_manager.model.Property;
import com.reality.reality_manager.service.PropertyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin(origins = "*")
public class RepositoryController {

    private final PropertyService service;

    public RepositoryController(PropertyService service) {
        this.service = service;
    }

    @GetMapping
    public List<Property> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Property create(@RequestBody Property property) {
        return service.create(property);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Property> update(@PathVariable Long id,
                                           @RequestBody Property property) {
        return service.update(id, property)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
