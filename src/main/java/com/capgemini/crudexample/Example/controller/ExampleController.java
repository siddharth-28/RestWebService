package com.capgemini.crudexample.Example.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.capgemini.crudexample.Example.Exceptions.ExampleNotFoundException;
import com.capgemini.crudexample.Example.domain.ExampleDomain;
import com.capgemini.crudexample.Example.repository.ExampleRepository;

@RestController
public class ExampleController {

	@Autowired
	private ExampleRepository exRepo;
	
	@GetMapping("/example")
	public List<ExampleDomain> retrieveAllExamples(){
		return exRepo.findAll();
	}
	@GetMapping("/example/{id}")
	public ExampleDomain retrieveExample(@PathVariable long id) throws ExampleNotFoundException{
		Optional<ExampleDomain> ex = exRepo.findById(id);
	
				if(!ex.isPresent()){
					throw new ExampleNotFoundException("not found");
				}
				return ex.get();
	}
	@DeleteMapping("/example/{id}")
	public void deleteExample(@PathVariable long id){
	 exRepo.deleteById(id);
	}
	@PostMapping("/examples")
	public ResponseEntity<Object> createExample(@RequestBody ExampleDomain example){
		ExampleDomain savedExample = exRepo.save(example);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedExample.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
}
