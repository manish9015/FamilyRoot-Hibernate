package com.Rootproject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rootproject.Model.PersonModel;
import com.Rootproject.Repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public PersonModel addmember(PersonModel personModel)
	{	
		
		return personRepository.save(personModel);
	}
	
	public List<PersonModel> getAllPersons() {
        return personRepository.findAll();
    }
	
	public List<PersonModel> getPersonByName(String name) {
        return personRepository.findByName(name);
    }
	
	public boolean deleteById(Long id)
	{
		if(personRepository.findById(id).isPresent())
		{
			personRepository.deleteById(id);
			return true;
		}
		
		throw new IllegalArgumentException("the is not found");
	}
	
	public Optional<PersonModel> getMemberById(long id)
	{
		return personRepository.findById(id);
	}
	
	public PersonModel updatePerson(PersonModel personModel,Long id)
	{
		Optional<PersonModel> optionalPersonOptional=personRepository.findById(id);
		
		if(optionalPersonOptional.isPresent())
		{
			PersonModel personModel2=optionalPersonOptional.get();
			personModel2.setName(personModel.getName());
			personModel2.setGender(personModel.getGender());
			personModel2.setDob(personModel.getDob());
			personModel2.setProfession(personModel.getProfession());
			personModel2.setChildrenFromMother(personModel.getChildrenFromMother());
			personModel2.setChildrenFromFather(personModel.getChildrenFromMother());
			return personRepository.save(personModel2);
		}
		throw new IllegalArgumentException("the member is not found"+id);
	}

}
