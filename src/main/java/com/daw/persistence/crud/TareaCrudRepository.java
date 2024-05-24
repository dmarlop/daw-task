package com.daw.persistence.crud;



import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.daw.persistence.entities.Tarea;
import com.daw.persistence.entities.enums.Estado;


public interface TareaCrudRepository extends CrudRepository<Tarea, Integer> {

	//Select * FROM tarea where titulo LIKE 'Titulo%'
	List<Tarea> findByTituloStartingWith(String titulo);
	
	//Select * FROM tarea where ID > ?
	List<Tarea> findByIdGreaterThan(int id);
	
	//Select * from TAREA where status LIKE 'Pendiente'
 	
	List<Tarea> findByEstadoLike(Estado estado);
	
	//Select * from tarea where fecha_vencimiento < CURRENT_DATE
	
	List<Tarea> findByfechaVencimientoBefore(LocalDate fechaActual);
	
	List<Tarea> findByfechaVencimientoAfter(LocalDate fechaActual);
	
	
	
	
}
