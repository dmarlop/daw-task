package com.daw.web.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daw.persistence.entities.Tarea;
import com.daw.persistence.entities.enums.Estado;
import com.daw.service.TareaService;

import jakarta.annotation.PostConstruct;

//http://localhost:8082/dawtask/api/tarea
@RestController
@RequestMapping("/tareas")
public class TareaController {
	
	@Autowired
	private TareaService tareaService;
	
	@GetMapping
	public ResponseEntity<List<Tarea>> listAll(){
		return ResponseEntity.ok(this.tareaService.getTareas());
		
	}
	
	@GetMapping("/{idTarea}")
	public ResponseEntity<Tarea> findOne(@PathVariable int idTarea){
		Optional<Tarea> tarea = this.tareaService.getTarea(idTarea);
		
		if(tarea.isPresent()) {
			return ResponseEntity.ok(tarea.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Tarea> create(@RequestBody Tarea tarea){
		return new ResponseEntity<Tarea>(this.tareaService.crear(tarea), HttpStatus.CREATED);
		
	}
	@PutMapping("/{idTarea}")
	public ResponseEntity<Tarea> update(@PathVariable int idTarea, @RequestBody Tarea tarea){
		if (idTarea == tarea.getId()) {
			if(this.tareaService.getTarea(idTarea).isPresent()) {
				return ResponseEntity.ok(this.tareaService.actualizarTarea(tarea));
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		else {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@DeleteMapping("/{idTarea}")
	public ResponseEntity<Tarea> delete(@PathVariable int idTarea){
		if(this.tareaService.delete(idTarea)) {
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();

		}
	}
	
	//Metodo GET de las tareas cuyo titulo  empiezan por la letra P
	@GetMapping("/empiezan")
	public ResponseEntity<List<Tarea>> empiezan(@RequestParam String titulo){
		return ResponseEntity.ok(this.tareaService.getTareasEmpiezan(titulo));
	}
	
	//Get Tareas cuyo ID es mayor que 4.
	@GetMapping("/mayores")
	public ResponseEntity<List<Tarea>> mayores(@RequestParam int idTarea){
		return ResponseEntity.ok(this.tareaService.getTareasCuyoIdMayorQue(idTarea));
	}
	
	@GetMapping("/pendientes")
	public ResponseEntity<List<Tarea>> pendientes(@RequestParam Estado estado){
		return ResponseEntity.ok(this.tareaService.getTareasPendientes(estado.PENDIENTE));
	}
	
	@GetMapping("/enProceso")
	public ResponseEntity<List<Tarea>> enProceso(@RequestParam Estado estado){
		return ResponseEntity.ok(this.tareaService.getTareasEnProceso(estado.EN_PROCESO));
	}
	
	@GetMapping("/completadas")
	public ResponseEntity<List<Tarea>> completadas(@RequestParam Estado estado){
		return ResponseEntity.ok(this.tareaService.getTareasCompletadas(estado.COMPLETADA));
	}
	
	@GetMapping("/vencidas")
	public ResponseEntity<List<Tarea>> vencidas (){
		return ResponseEntity.ok(this.tareaService.getTareasVencidas());
	}
	
	@GetMapping("/noVencidas")
	public ResponseEntity<List<Tarea>> noVencidas (){
		return ResponseEntity.ok(this.tareaService.getTareasNoVencidas());
	}
	

}
