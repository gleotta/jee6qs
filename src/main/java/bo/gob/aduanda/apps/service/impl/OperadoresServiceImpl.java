package bo.gob.aduanda.apps.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import bo.gob.aduanda.apps.exceptions.BusinessException;
import bo.gob.aduanda.apps.exceptions.TechnicalException;
import bo.gob.aduanda.apps.integration.ExternalServices;
import bo.gob.aduanda.apps.model.OperadorNatural;
import bo.gob.aduanda.apps.service.OperadoresService;

@Stateless
public class OperadoresServiceImpl implements OperadoresService{

	private @Inject EntityManager em;
	
	private @Inject ExternalServices external;
	
	@Override
	public void altaOperadorNatural(OperadorNatural op) throws BusinessException {

		if (!external.validarOperadorNatural(op))
			throw new BusinessException("El operador no es valido");
		try {
			em.persist(op);
		} catch (Exception e) {
			throw new TechnicalException("Problema al persistir operador natural", e);
		}
		
	}
	

}
