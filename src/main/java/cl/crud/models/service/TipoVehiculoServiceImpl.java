/*Creado por Gina Gaggero Schivo 
*/
package cl.crud.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.crud.models.dao.ITipoVehiculoDAO;
import cl.crud.models.entity.TipoVehiculo;

@Service
public class TipoVehiculoServiceImpl implements ITipoVehiculoService{
	
	@Autowired
	private ITipoVehiculoDAO tipoVehiculoDAO;

	@Transactional(readOnly = true)
	@Override
	public List<TipoVehiculo> findAll() {
		return (List<TipoVehiculo>) tipoVehiculoDAO.findAll();

	}

	@Override
	public List<TipoVehiculo> getNaves() {
		return (List<TipoVehiculo>) tipoVehiculoDAO.getNaves();
	}

}
