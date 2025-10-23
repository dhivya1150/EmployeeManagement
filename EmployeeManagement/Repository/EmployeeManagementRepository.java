package com.example.project.EmployeeManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.EmployeeManagement.Entity.EmployeeManagementEntity;

public interface EmployeeManagementRepository extends JpaRepository<EmployeeManagementEntity , Long>
{

}
