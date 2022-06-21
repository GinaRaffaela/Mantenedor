/*Creado por Gina Gaggero Schivo 
*/

package cl.crud.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "sifaVehiculo")
public class Vehiculo {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVehiculo;
	
	@NotEmpty
	private String IdentificacionVehiculo;
	
	private String capacidadCarga;
	
	private String patenteRemolque;
	
	private String capCargaRemolque;
	
	private String modelo;
	
	@NotEmpty
	private String nombreVehiculo;
	
	private String tratamAgua;
	
	@NotEmpty
	private String CBoCA;
	
	@Column(name = "fechaModificacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaModificacion;
	
	private String deshabilitado;

	@NotNull
	@ManyToOne
    @JoinColumn(name = "idTipoVehiculo")
    private TipoVehiculo tipoVehiculo;
	
	@ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

	public Long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getIdentificacionVehiculo() {
		return IdentificacionVehiculo;
	}

	public void setIdentificacionVehiculo(String identificacionVehiculo) {
		IdentificacionVehiculo = identificacionVehiculo;
	}

	public String getCapacidadCarga() {
		return capacidadCarga;
	}

	public void setCapacidadCarga(String capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	public String getPatenteRemolque() {
		return patenteRemolque;
	}

	public void setPatenteRemolque(String patenteRemolque) {
		this.patenteRemolque = patenteRemolque;
	}

	public String getCapCargaRemolque() {
		return capCargaRemolque;
	}

	public void setCapCargaRemolque(String capCargaRemolque) {
		this.capCargaRemolque = capCargaRemolque;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNombreVehiculo() {
		return nombreVehiculo;
	}

	public void setNombreVehiculo(String nombreVehiculo) {
		this.nombreVehiculo = nombreVehiculo;
	}

	public String getTratamAgua() {
		return tratamAgua;
	}

	public void setTratamAgua(String tratamAgua) {
		this.tratamAgua = tratamAgua;
	}

	public String getCBoCA() {
		return CBoCA;
	}

	public void setCBoCA(String cBoCA) {
		CBoCA = cBoCA;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getDeshabilitado() {
		return deshabilitado;
	}

	public void setDeshabilitado(String deshabilitado) {
		this.deshabilitado = deshabilitado;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}