package bo.gob.aduanda.apps.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="OPERADOR_JURIDICO")
public class OperadorJuridico extends Operador{
	
	@NotNull
	@Column(unique=true)
	private String nit;
	
	@NotNull
	private String razonSocial;
	
	@ManyToOne
	private Domicilio domicilioFisico;
	
	private Date fechaConstitucion;
	
	private Integer cantidadEmpleados;
	
	@OneToMany(mappedBy="empleador")
	private Set<OperadorNatural> operadores;
	
	public OperadorJuridico() {
		
	}
	
	public OperadorJuridico(String nit) {
		super();
		this.nit = nit;
	}

	@Override
	public String getIdentificador() {
		
		return nit;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public Domicilio getDomicilioFisico() {
		return domicilioFisico;
	}

	public void setDomicilioFisico(Domicilio domicilioFisico) {
		this.domicilioFisico = domicilioFisico;
	}

	public Date getFechaConstitucion() {
		return fechaConstitucion;
	}

	public void setFechaConstitucion(Date fechaConstitucion) {
		this.fechaConstitucion = fechaConstitucion;
	}

	public Integer getCantidadEmpleados() {
		return cantidadEmpleados;
	}

	public void setCantidadEmpleados(Integer cantidadEmpleados) {
		this.cantidadEmpleados = cantidadEmpleados;
	}

	public Set<OperadorNatural> getOperadores() {
		return operadores;
	}

	public void setOperadores(Set<OperadorNatural> operadores) {
		this.operadores = operadores;
	}

	@Override
	public String toString() {
		return "OperadorJuridico [nit=" + nit + ", razonSocial=" + razonSocial
				+ ", domicilioFisico=" + domicilioFisico
				+ ", fechaConstitucion=" + fechaConstitucion
				+ ", cantidadEmpleados=" + cantidadEmpleados+"]";
	}

}
