package com.bdo.ccups.model;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	private Employee() {}
	public Employee(String name, String department, String gender, Date dob) {
		this.name = name;
		this.department = department;
		this.gender = gender;
		this.dob=dob;
	}
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;


 private String name;

 private String department;

 private Date dob;

 private String gender;
@Override
 public String toString() {
  return "Employee [id= " + id + ", name=" + name + ", department=" + department + ", dob=" + dob + ", gender="
    + gender + "]";
 }

 @Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return Objects.equals(id, employee.id) &&
			Objects.equals(name, employee.name) &&
			Objects.equals(department, employee.department) &&
			Objects.equals(gender, employee.gender)&&
			Objects.equals(dob, employee.dob);
	}

 @Override
	public int hashCode() {

		return Objects.hash(id, name, department, gender,dob);
	}
public Long getId() {
  return id;
 }
public void setId(Long id) {
  this.id = id;
 }
public String getName() {
  return name;
 }
public void setName(String name) {
  this.name = name;
 }
public String getDepartment() {
  return department;
 }
public void setDepartment(String department) {
  this.department = department;
 }
public Date getDob() {
  return dob;
 }
public void setDob(Date dob) {
  this.dob = dob;
 }
public String getGender() {
  return gender;
 }
public void setGender(String gender) {
  this.gender = gender;
 }
}