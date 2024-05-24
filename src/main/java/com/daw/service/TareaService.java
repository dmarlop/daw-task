package com.daw.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.persistence.entities.Tarea;
import com.daw.persistence.entities.enums.Estado;
import com.daw.persistence.repositories.TareaRepository;

@Service
public class TareaService {

	@Autowired
	private TareaRepository tareaRepository;

	public List<Tarea> getTareas() {
		return this.tareaRepository.findAll();
	}

	public Optional<Tarea> getTarea(int idTarea) {
		return this.tareaRepository.findById(idTarea);
	}

	//titulo
	//descripcion
	//fecha vencimiento
	
	//Fecha creacion -> hoy
	//Estado -> PENDIENTE
	public Tarea crear(Tarea tarea) {
		tarea.setEstado(Estado.PENDIENTE);
		tarea.setFechaCreacion(LocalDate.now());
		
		return this.tareaRepository.save(tarea);
	}
	
	
	public Tarea actualizarTarea(Tarea tarea) {
		return this.tareaRepository.save(tarea);
	}
	
	
	public boolean delete(int idTarea) {
		boolean result = false;		
		if (this.tareaRepository.findById(idTarea).isPresent()) {
			this.tareaRepository.deleteById(idTarea);
			result = true;
		}
		return result;

	}
	
	
	public List<Tarea> getTareasEmpiezan(String titulo){
		return this.tareaRepository.findByTituloStartingWith(titulo);
	}
	
	public List<Tarea> getTareasCuyoIdMayorQue(int idTarea){
		return this.tareaRepository.findByIdGreaterThan(idTarea);
	}
	
	public List<Tarea> getTareasPendientes(Estado estado){
		return this.tareaRepository.findByEstadoPendiente(estado.PENDIENTE);
	}
	
	public List<Tarea> getTareasEnProceso(Estado estado){
		return this.tareaRepository.findByEstadoEnProceso(estado.EN_PROCESO);
	}
	
	public List<Tarea> getTareasCompletadas(Estado estado){
		return this.tareaRepository.findByEstadoCompletadas(estado.COMPLETADA);
	}
	
	public List<Tarea> getTareasVencidas(){
		return this.tareaRepository.findByfechaVencimientoBefore(LocalDate.now());
	}
	
	public List<Tarea> getTareasNoVencidas(){
		return this.tareaRepository.findByfechaVencimientoAfter(LocalDate.now());
	}

}
