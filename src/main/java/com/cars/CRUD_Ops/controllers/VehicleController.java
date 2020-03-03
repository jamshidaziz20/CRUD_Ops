package com.cars.CRUD_Ops.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cars.CRUD_Ops.models.Vehicle;
import com.cars.CRUD_Ops.repository.VehicleRepository;

@RestController
public class VehicleController {

	@Autowired
	private VehicleRepository vehicleRepository;

	// GET vehicles
	@GetMapping("vehicles")
	public List<Vehicle> getAllVehicles() {
		return vehicleRepository.findAll();
	}

	// GET vehicles/{id}
	@GetMapping("vehicles/{id}")
	public ResponseEntity<?> getVehicleById(@PathVariable(value = "id") long id) {
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);
		if (vehicle.isEmpty()) {
			return ((BodyBuilder) ResponseEntity.notFound()).body("Vehicle with id: " + id + " was not found");
		}

		return ResponseEntity.ok(vehicle);
	}

	// POST vehicles
	@PostMapping("vehicles")
	public ResponseEntity<?> addVehicle(@Valid @RequestBody Vehicle vehicle) {
		vehicleRepository.save(vehicle);
		return ResponseEntity.ok("Vehicle added succesfully");

	}

	// PUT vehicles/{id}
	@PutMapping("vehicles/{id}")
	public ResponseEntity<?> updateVehicle(@PathVariable(value = "id") long id, @Valid @RequestBody Vehicle newVehicle){
		
		Optional<Vehicle> tempVehicle = vehicleRepository.findById(id);
		if (tempVehicle.isEmpty()) {
			return ((BodyBuilder) ResponseEntity.notFound()).body("Vehicle with id: " + id + " was not found");
		}
		Vehicle currVehicle = tempVehicle.get();
		currVehicle.setMake(newVehicle.getMake());
		currVehicle.setModel(newVehicle.getModel());
		currVehicle.setYear(newVehicle.getYear());
		vehicleRepository.save(currVehicle);
		return ResponseEntity.ok("Vehicle updated succesfully");
			
	}

	// DELETE vehicles/{id}
	@DeleteMapping("vehicles/{id}")
	public ResponseEntity<?> deleteById(@PathVariable long id) {
		if (vehicleRepository.findById(id).isEmpty()) {
			return ((BodyBuilder) ResponseEntity.notFound()).body("Vehicle with id: " + id + " was not found");
		}
		
		vehicleRepository.deleteById(id);
		return ResponseEntity.ok("Vehicle deleted succesfully");
	}

}
