package com.reality.reality_manager.repository;

import com.reality.reality_manager.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
@org.springframework.stereotype.Repository

public interface Repository extends JpaRepository<Property, Long> {

}
