package com.reality.reality_manager.service;

import com.reality.reality_manager.model.Property;
import com.reality.reality_manager.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    private final Repository repository;

    public PropertyService(Repository repository) {
        this.repository = repository;
    }

    public List<Property> getAll() {
        return repository.findAll();
    }

    public Optional<Property> getById(Long id) {
        return repository.findById(id);
    }

    public Property create(Property property) {
        return repository.save(property);
    }

    public Optional<Property> update(Long id, Property updated) {
        return repository.findById(id).map(existing -> {
            existing.setAddress(updated.getAddress());
            existing.setPrice(updated.getPrice());
            existing.setRooms(updated.getRooms());
            existing.setDescription(updated.getDescription());
            return repository.save(existing);
        });
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
