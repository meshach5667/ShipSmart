package com.mesh.delivery.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mesh.delivery.Entity.Vehicle;
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long > {


    
}
