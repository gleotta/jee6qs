package bo.gob.aduanda.apps.service;

import javax.ejb.Local;

import bo.gob.aduanda.apps.exceptions.BusinessException;
import bo.gob.aduanda.apps.model.OperadorNatural;


@Local
public interface OperadoresService {
	
	public void altaOperadorNatural(OperadorNatural op) throws BusinessException;

}
