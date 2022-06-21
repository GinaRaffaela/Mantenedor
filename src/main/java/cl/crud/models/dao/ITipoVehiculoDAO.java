/*Creado por Gina Gaggero Schivo 
*/
package cl.crud.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cl.crud.models.entity.TipoVehiculo;

public interface ITipoVehiculoDAO extends PagingAndSortingRepository<TipoVehiculo, Long> {


	//

	/**
	 * 
	 * Obtiene listado acotado de tipos de vehiculo desde tabla TipoVehiculo 
	 * restringido a los de categoria 3,correspondientes a barcos o naves acuaticas. 
	 * 
	 */
	//@Query("SELECT o.idTipoVehiculo, o.idCategoriaTransporte, o.nombreTipoVehiculo FROM TipoVehiculo o WHERE o.idCategoriaTransporte = 3")
	@Query(nativeQuery = true,value ="SELECT idTipoVehiculo, idCategoriaTransporte, nombreTipoVehiculo FROM sifaTipoVehiculo WHERE idCategoriaTransporte = 3")
	List<TipoVehiculo> getNaves();
	
	

}


