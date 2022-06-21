/*Creado por Gina Gaggero Schivo 
*/
package cl.crud.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cl.crud.models.entity.Vehiculo;

public interface IVehiculoService {
	
	public List<Vehiculo> findAll();
	
	public Page<Vehiculo> findAll(Pageable pageable);

	public void save(Vehiculo vehiculos);
	
	public Vehiculo findOne(Long idVehiculo);
	
	public void delete(Long idVehiculo);
	
	public Iterable<Vehiculo> buscar(String nombreVehiculo, String CBoCA, String IdentificacionVehiculo);
	

}
