package com.project.billingSoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.billingSoftware.entity.OrderItemEntity;

public interface OrderItemEntityRepository extends JpaRepository<OrderItemEntity, Long>{
    
}
