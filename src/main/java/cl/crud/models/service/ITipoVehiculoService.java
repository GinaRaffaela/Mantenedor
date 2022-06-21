/*Creado por Gina Gaggero Schivo 
*/

package cl.crud.models.service;

import java.util.List;

import cl.crud.models.entity.TipoVehiculo;

public interface ITipoVehiculoService {
	
	public List<TipoVehiculo> findAll();

	public List<TipoVehiculo> getNaves();

}
