/*Creado por Gina Gaggero Schivo 
*/


package cl.crud.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.crud.models.dao.IVehiculoDAO;
import cl.crud.models.entity.Vehiculo;

@Service
public class VehiculoServiceImpl  implements IVehiculoService{
	
	@Autowired
	private IVehiculoDAO vehiculoDAO;

	//Lista todos los vehiculos
	@Transactional(readOnly = true)
	@Override
	public List<Vehiculo> findAll() {
		return (List<Vehiculo>) vehiculoDAO.findAll();
	}

	//paginado al final del listado de vehiculos
	@Override
	public Page<Vehiculo> findAll(Pageable pageable) {
		pageable.getPageNumber();
		pageable.getPageSize();
		return vehiculoDAO.findAll(pageable);
	}

	//Guardar vehiculo 
	@Override
	public void save(Vehiculo vehiculo) {
		vehiculoDAO.save(vehiculo);
		
	}

	//selecciona un vehiculo por su id para visualizar una nave
	@Override
	@Transactional(readOnly = true)
	public Vehiculo findOne(Long idVehiculo) {
		return vehiculoDAO.findOne(idVehiculo);
	}

	//elimina una nave
	@Override
	public void delete(Long idVehiculo) {
		vehiculoDAO.delete(idVehiculo);
	}

	//busqueda de nave por nombre, cboca y matricula
	@Override
	public Iterable<Vehiculo> buscar(String nombreVehiculo, String CBoCA, String IdentificacionVehiculo) {
		
		if ((nombreVehiculo != null) || (CBoCA != null) || (IdentificacionVehiculo != null)) {
			return vehiculoDAO.buscar(nombreVehiculo, CBoCA, IdentificacionVehiculo);
		}


		return vehiculoDAO.findAll();
	}

	


}
