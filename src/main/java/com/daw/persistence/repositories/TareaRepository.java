package com.daw.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.persistence.crud.TareaCrudRepository;
import com.daw.persistence.entities.Tarea;


@Repository
public class TareaRepository {

	@Autowired
	private TareaCrudRepository tareaCrudRepository;
	
	//Listar todas las tareas
	public List<Tarea> findAll(){
		return (List<Tarea>) this.tareaCrudRepository.findAll();
	}
	
	
	
	//Obtener una tarea por id
	public Optional<Tarea> findById(int idTarea){
		return this.tareaCrudRepository.findById(idTarea);
	}
	
	
	//Guardar una tarea
	public Tarea save(Tarea tarea) {
		return this.tareaCrudRepository.save(tarea);
	}
	
	
	//Borrar una tarea
	public void deleteById(int idTarea) {
		this.tareaCrudRepository.deleteById(idTarea);
	}
	
	
	
}
