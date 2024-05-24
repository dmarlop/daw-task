package com.daw.persistence.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.persistence.crud.TareaCrudRepository;
import com.daw.persistence.entities.Tarea;
import com.daw.persistence.entities.enums.Estado;


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
	
	
	
	public List<Tarea> findByTituloStartingWith(String tarea){
		return this.tareaCrudRepository.findByTituloStartingWith(tarea);
	}
	
	public List<Tarea> findByIdGreaterThan(int id){
		return this.tareaCrudRepository.findByIdGreaterThan(id);
	}
	
	public List<Tarea> findByEstadoPendiente(Estado estado){
		return this.tareaCrudRepository.findByEstadoLike(estado.PENDIENTE);
	}
	
	
	public List<Tarea> findByEstadoEnProceso(Estado estado){
		return this.tareaCrudRepository.findByEstadoLike(estado.EN_PROCESO);
	}
	
	public List<Tarea> findByEstadoCompletadas(Estado estado){
		return this.tareaCrudRepository.findByEstadoLike(estado.COMPLETADA);
	}
	
	public List<Tarea> findByfechaVencimientoBefore(LocalDate fecha){		
		return this.tareaCrudRepository.findByfechaVencimientoBefore(LocalDate.now());
	}
	
	public List<Tarea> findByfechaVencimientoAfter(LocalDate fecha){		
		return this.tareaCrudRepository.findByfechaVencimientoAfter(LocalDate.now());
	}
	
}
