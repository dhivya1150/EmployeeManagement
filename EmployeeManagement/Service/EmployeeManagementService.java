package com.example.project.EmployeeManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.EmployeeManagement.Config.AppProperties;
import com.example.project.EmployeeManagement.Entity.EmployeeManagementEntity;
import com.example.project.EmployeeManagement.Exception.ResourceNotFoundException;
import com.example.project.EmployeeManagement.Repository.EmployeeManagementRepository;

@Service
public class EmployeeManagementService {
	
	@Autowired
	private EmployeeManagementRepository repo;
	
	@Autowired
	private AppProperties appProperties;
	
	public EmployeeManagementEntity save(EmployeeManagementEntity entity)
	{
		return repo.save(entity);
	}
	
	public List<EmployeeManagementEntity> getall()
	{
		return repo.findAll();
	}
	
	public EmployeeManagementEntity getbyid(Long id)
	{
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Id not found"  + id) );
	}
	
	public EmployeeManagementEntity update(EmployeeManagementEntity entity , Long id)
	{
		EmployeeManagementEntity updating = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException ("Id not found to update"));
		
		updating.setName(entity.getName());
		updating.setEmail(entity.getEmail());
		updating.setPassword(entity.getPassword());
		
		return repo.save(updating);
		
	}
	
	public String delete(Long id)
	{
		EmployeeManagementEntity deleted = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException ("Id not found to delete"));
		
		repo.delete(deleted);
		
		return "ID Sucessfully Deleted";
		
	}
	
	public EmployeeManagementEntity saveEmployee(EmployeeManagementEntity entity)
	{
		System.out.println("App Name : " + appProperties.getName());
		System.out.println("App Version : " + appProperties.getVersion());
		System.out.println("Admin Email : " + appProperties.getAdminEmail());
		 
		return repo.save(entity);
	}

}
