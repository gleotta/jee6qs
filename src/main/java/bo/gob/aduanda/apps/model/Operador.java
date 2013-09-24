package bo.gob.aduanda.apps.model;

import java.util.Set;

public abstract class Operador {
	
	
	private Domicilio domicilioLegal;
	
	private Set<OperadorPorAduana> aduanas;
	
	
	public abstract String getIdentificador();

	public Domicilio getDomicilioLegal() {
		return domicilioLegal;
	}

	public void setDomicilioLegal(Domicilio domicilioLegal) {
		this.domicilioLegal = domicilioLegal;
	}

	public Set<OperadorPorAduana> getAduanas() {
		return aduanas;
	}

	public void setAduanas(Set<OperadorPorAduana> aduanas) {
		this.aduanas = aduanas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getIdentificador() == null) ? 0 : getIdentificador().hashCode());
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
		Operador other = (Operador) obj;
		if (getIdentificador() == null) {
			if (other.getIdentificador() != null)
				return false;
		} else if (!getIdentificador().equals(other.getIdentificador()))
			return false;
		return true;
	}

}
