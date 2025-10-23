package com.example.project.EmployeeManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.EmployeeManagement.Config.AppProperties;
import com.example.project.EmployeeManagement.Entity.EmployeeManagementEntity;
import com.example.project.EmployeeManagement.Service.EmployeeManagementService;

@RestController
@RequestMapping("/employees")
public class EmployeeEntityController {
	
	@Autowired
	private EmployeeManagementService service;
	
	@Autowired
	private AppProperties appProperties;
	@PostMapping
	public ResponseEntity<EmployeeManagementEntity> create(@RequestBody EmployeeManagementEntity entity)
	{
		EmployeeManagementEntity created = service.save(entity);
		return new ResponseEntity<>(created,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeManagementEntity>> getall()
	{
		List<EmployeeManagementEntity> get = service.getall();
		return new ResponseEntity<>(get,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeManagementEntity> findbyid(@PathVariable Long id)
	{
		EmployeeManagementEntity find = service.getbyid(id);
		return new ResponseEntity<>(find,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeManagementEntity> update(@RequestBody EmployeeManagementEntity entity,@PathVariable Long id )
	{
		EmployeeManagementEntity updating = service.update(entity, id);
		return new ResponseEntity<>(updating,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id)
	{
		String deleted = service.delete(id);
		return new ResponseEntity<>(deleted,HttpStatus.OK); 
		
	}
	
	
	 @GetMapping("/info")
	    public ResponseEntity<String> getAppInfo() {
	        String info = "App Name: " + appProperties.getName()
	                + " | Version: " + appProperties.getVersion()
	                + " | Admin Email: " + appProperties.getAdminEmail();
	        return ResponseEntity.ok(info);
	    }
	
	

}
