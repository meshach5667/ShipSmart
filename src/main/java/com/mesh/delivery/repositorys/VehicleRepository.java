package com.mesh.delivery.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mesh.delivery.Entity.Vehicle;



@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v WHERE v.status = 'maintenance'")
    List<Vehicle> getVehiclesInMaintenance();

    List<Vehicle> getVehicleByCarryingWeightGreaterThan(float weight);

    Vehicle getVehicleByPlateNumber(String plateNumber);
}
