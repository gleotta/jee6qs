package bo.gob.aduanda.apps.test;

import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.jpamodelgen.xml.jaxb.Persistence.PersistenceUnit;
import org.hibernate.jpamodelgen.xml.jaxb.PersistenceUnitDefaults;
import org.hibernate.jpamodelgen.xml.jaxb.PersistenceUnitMetadata;

import bo.gob.aduanda.apps.model.Barrio;
import bo.gob.aduanda.apps.model.Ciudad;
import bo.gob.aduanda.apps.model.Departamento;

public class TestModel {
	
	//entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
	
	public static void main(String[] args) {
		try {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("jee6qs-test");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.createQuery("delete from Barrio");
			em.createQuery("delete from Ciudad");
			em.createQuery("delete from Departamento");
			em.flush();
			
			//create Departamento
			Departamento d = new Departamento();
			d.setNombre("La Paz");
			d.setCiudades(new HashSet<Ciudad>());
			
			//create ciudad
			Ciudad c = new Ciudad();
			c.setNombre("La Paz");
			c.setBarrios(new HashSet<Barrio>());
			c.setDepartamento(d);
			d.getCiudades().add(c);
			
			//create barrio
			Barrio b = new Barrio();
			b.setCiudad(c);
			b.setNombre("Sopocachi");
			c.getBarrios().add(b);
			
			em.persist(d);
			
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
