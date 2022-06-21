/*Creado por Gina Gaggero Schivo 
*/

package cl.crud.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


import cl.crud.models.entity.Vehiculo;


public interface IVehiculoDAO extends PagingAndSortingRepository<Vehiculo, Long>{

		//CONSULTA PARA BUSQUEDA
		@Query(nativeQuery = true,value ="SELECT * FROM sifaVehiculo sv "
				+ "where (?1 is null or sv.nombreVehiculo like ?1) "
				+   "or (?2 is null or sv.CBoCA like ?2) "
				+   "or (?3 is null or sv.IdentificacionVehiculo like ?3)")	
		Iterable<Vehiculo> buscar(String nombreVehiculo, String CBoCA, String IdentificacionVehiculo);


		
		
}
