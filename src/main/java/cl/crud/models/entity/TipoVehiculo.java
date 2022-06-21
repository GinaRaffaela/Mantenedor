/*Creado por Gina Gaggero Schivo 
*/

package cl.crud.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "sifaTipoVehiculo")
public class TipoVehiculo { 
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoVehiculo;

	@NotEmpty
	private Long idCategoriaTransporte;

	@NotEmpty
	private String nombreTipoVehiculo;
	
	public TipoVehiculo() {
	}

	public Long getIdTipoVehiculo() {
		return idTipoVehiculo;
	}

	public void setIdTipoVehiculo(Long idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
	}

	public Long getIdCategoriaTransporte() {
		return idCategoriaTransporte;
	}

	public void setIdCategoriaTransporte(Long idCategoriaTransporte) {
		this.idCategoriaTransporte = idCategoriaTransporte;
	}

	public String getNombreTipoVehiculo() {
		return nombreTipoVehiculo;
	}

	public void setNombreTipoVehiculo(String nombreTipoVehiculo) {
		this.nombreTipoVehiculo = nombreTipoVehiculo;
	}
	

	
	
}