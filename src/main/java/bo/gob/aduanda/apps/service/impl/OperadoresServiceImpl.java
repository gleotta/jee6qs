package bo.gob.aduanda.apps.service.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceUnitUtil;

import bo.gob.aduanda.apps.exceptions.BusinessException;
import bo.gob.aduanda.apps.exceptions.TechnicalException;
import bo.gob.aduanda.apps.integration.ExternalServices;
import bo.gob.aduanda.apps.model.Operador;
import bo.gob.aduanda.apps.model.OperadorJuridico;
import bo.gob.aduanda.apps.model.OperadorNatural;
import bo.gob.aduanda.apps.service.OperadoresService;

@Stateless
public class OperadoresServiceImpl implements OperadoresService{

	private @Inject EntityManager em;
	
	private @Inject ExternalServices external;
	
	@Inject
    private Logger log;
	
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Operador> obtenerOperadores() {
		
		try {
			List<Operador> ret = em.createQuery("select o from Operador o").getResultList();
			
			return ret;
		} catch (Exception e) {
			throw new TechnicalException("Error al obtwner operadores", e);
		}
	}
	
	@Override
	public Operador obtenerOperador(String identificador) {
		Operador ret = null;
		try {
			ret = (Operador) em.createQuery("select o from OperadorJuridico o where o.nit = :identificador")
					.setParameter("identificador", identificador).getSingleResult();
			if (ret != null)
				return ret;
			
		} catch (NoResultException e) {
			//buso los naturales
		} 
		catch (Exception e) {
			throw new TechnicalException("Error al obtener operador", e);
		}
		
		
		try {
			ret = (Operador) em.createQuery("select o from OperadorNatural o where o.ci = :identificador")
					.setParameter("identificador", identificador).getSingleResult();
			
		} catch (NoResultException e) {
			//buso los naturales
		} 
		catch (Exception e) {
			throw new TechnicalException("Error al obtener operador", e);
		}
		
		return ret;
		
	}

	@Override
	public List<Operador> obtenerOperadoresJuridicos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Operador> obtenerOperadoresNaturales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void altaOperadorJuridico(OperadorJuridico op)
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editarOperadorNatural(OperadorNatural op)
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editarOperadorJuridico(OperadorJuridico op)
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarOperador(String identificadoro) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	

}
