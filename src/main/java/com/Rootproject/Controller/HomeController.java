package com.Rootproject.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Rootproject.Model.PersonModel;
import com.Rootproject.Service.PersonService;

@RestController
public class HomeController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/start")
	public String start()
	{
		return "started";
	}
	
	@PostMapping("/post")
	public PersonModel addmember(@RequestBody PersonModel personModel)
	{
		return personService.addmember(personModel);
	}
	@GetMapping("/getall")
	public List<PersonModel> getAllPersons() {
        return personService.getAllPersons();
    }
	
	@GetMapping("/byname/{name}")
	public List<PersonModel> getPersonByName(@PathVariable String name) {
        return personService.getPersonByName(name);
    }
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable Long id)
	{
		personService.deleteById(id);
		return "the Family Member is deleted";
	}
	
	@GetMapping("/get/{id}")
	public Optional<PersonModel> getMemberById(@PathVariable Long id)
	{
		return personService.getMemberById(id);
	}
	@PutMapping("/update/{id}")
	public PersonModel updatePerson(@RequestBody PersonModel personModel,@PathVariable Long id)
	{
		return personService.updatePerson(personModel, id);
	}
}
