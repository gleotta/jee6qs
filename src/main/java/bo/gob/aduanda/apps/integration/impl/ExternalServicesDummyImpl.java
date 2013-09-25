package bo.gob.aduanda.apps.integration.impl;

import bo.gob.aduanda.apps.integration.ExternalServices;
import bo.gob.aduanda.apps.model.OperadorJuridico;
import bo.gob.aduanda.apps.model.OperadorNatural;

public class ExternalServicesDummyImpl implements ExternalServices {

	@Override
	public boolean validarOperadorNatural(OperadorNatural on) {
		// Implementacion dummy
		return true;
	}

	@Override
	public boolean validarOperadorJuridico(OperadorJuridico oj) {
		// Implementacion dummy
		return true;
	}

}
