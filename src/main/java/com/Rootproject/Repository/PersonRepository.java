package com.Rootproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Rootproject.Model.PersonModel;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Long> {

	 List<PersonModel> findByName(String name);
}
