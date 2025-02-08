package com.mesh.delivery.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mesh.delivery.Entity.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}

