package com.daw.persistence.crud;



import org.springframework.data.repository.CrudRepository;

import com.daw.persistence.entities.Tarea;



public interface TareaCrudRepository extends CrudRepository<Tarea, Integer> {

	
	
}
