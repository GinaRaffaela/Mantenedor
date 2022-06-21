/*Creado por Gina Gaggero Schivo 
*/
package cl.crud.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "sifaUsuario")
public class Usuario {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	private Long idTipoUsuario;
	
	private String nombres;
	
	private String email;
	
	private String nombreUsuario;
	
	private String estado;
	
	private int comuna;
	
	private int region;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private String genero;
	
	@Column(name = "fechaCreacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date fechaCreacion;
	
	@Column(name = "fechaultActualizacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date fechaultActualizacion;
	
	private String tipoIdentificador;
	
	private String nroIdentificador;
	
	private int IdOficina;
	
	private int encargadoOficina;
	
	private String contraseniaUser;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIidTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUduario(Long idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getComuna() {
		return comuna;
	}

	public void setComuna(int comuna) {
		this.comuna = comuna;
	}

	public int getRegion() {
		return region;
	}

	public void setRegion(int region) {
		this.region = region;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaultActualizacion() {
		return fechaultActualizacion;
	}

	public void setFechaultActualizacion(Date fechaultActualizacion) {
		this.fechaultActualizacion = fechaultActualizacion;
	}

	public String getTipoIdentificador() {
		return tipoIdentificador;
	}

	public void setTipoIdentificador(String tipoIdentificador) {
		this.tipoIdentificador = tipoIdentificador;
	}

	public String getNroIdentificador() {
		return nroIdentificador;
	}

	public void setNroIdentificador(String nroIdentificador) {
		this.nroIdentificador = nroIdentificador;
	}

	public int getIdOficina() {
		return IdOficina;
	}

	public void setIdOficina(int idOficina) {
		IdOficina = idOficina;
	}

	public int getEncargadoOficina() {
		return encargadoOficina;
	}

	public void setEncargadoOficina(int encargadoOficina) {
		this.encargadoOficina = encargadoOficina;
	}

	public String getContraseniaUser() {
		return contraseniaUser;
	}

	public void setContraseniaUser(String contraseniaUser) {
		this.contraseniaUser = contraseniaUser;
	}
	
	
}
