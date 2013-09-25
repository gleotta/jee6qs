package bo.gob.aduanda.apps.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="OPERADOR_POR_ADUANA",uniqueConstraints={@UniqueConstraint(columnNames={"operador", "aduana"})})
public class OperadorPorAduana {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private Date fechaAceptacion;
	
	private Integer cantTramites;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name="operador")
	private Operador operador;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name="aduana")
	private Aduana aduana;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaAceptacion() {
		return fechaAceptacion;
	}

	public void setFechaAceptacion(Date fechaAceptacion) {
		this.fechaAceptacion = fechaAceptacion;
	}

	public Integer getCantTramites() {
		return cantTramites;
	}

	public void setCantTramites(Integer cantTramites) {
		this.cantTramites = cantTramites;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public Aduana getAduana() {
		return aduana;
	}

	public void setAduana(Aduana aduana) {
		this.aduana = aduana;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aduana == null) ? 0 : aduana.hashCode());
		result = prime * result
				+ ((operador == null) ? 0 : operador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OperadorPorAduana other = (OperadorPorAduana) obj;
		if (aduana == null) {
			if (other.aduana != null)
				return false;
		} else if (!aduana.equals(other.aduana))
			return false;
		if (operador == null) {
			if (other.operador != null)
				return false;
		} else if (!operador.equals(other.operador))
			return false;
		return true;
	} 

}
