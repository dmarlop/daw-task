package com.daw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.persistence.entities.Tarea;
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

	public Tarea save(Tarea tarea) {
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

}
