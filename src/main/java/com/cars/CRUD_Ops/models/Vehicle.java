package com.cars.CRUD_Ops.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="vehicles")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Min(1950)
	@Max(2050)
	@Column(name="year")
	private int year;
	
	@NotBlank(message="Please provide the make of the vehicle.")
	@Column(name="make")
	private String make;
	
	@NotBlank(message="Please provide the model of the vehicle.")
	@Column(name="model")
	private String model;
	
	
	public Vehicle() {
		super();
	}
	public Vehicle(int year, String make, String model) {
		super();
		this.year = year;
		this.make = make;
		this.model = model;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

}
