package bo.gob.aduanda.apps.integration;

import bo.gob.aduanda.apps.model.OperadorJuridico;
import bo.gob.aduanda.apps.model.OperadorNatural;


public interface ExternalServices {
	
	public boolean validarOperadorNatural(OperadorNatural on);
	
	public boolean validarOperadorJuridico(OperadorJuridico oj);

}
