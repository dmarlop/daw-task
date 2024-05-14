package com.daw.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.persistence.entities.Tarea;
import com.daw.service.TareaService;

@RestController
@RequestMapping("/tareas")
public class TareaController {
	
	@Autowired
	private TareaService tareaService;
	
	@GetMapping
	public ResponseEntity<List<Tarea>> listAll(){
		return new ResponseEntity<List<Tarea>>(this.tareaService.getTareas(), HttpStatus.OK);
		
	}

}
