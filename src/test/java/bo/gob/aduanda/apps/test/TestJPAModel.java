package bo.gob.aduanda.apps.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestJPAModel {

	EntityManagerFactory emf;
	@Before
	public void setUp() throws Exception {
		emf= Persistence.createEntityManagerFactory( "jee6qs-test" );
	}

	@Test
	public void test() {
		try {
			emf.createEntityManager();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fail("Not yet implemented");
	}

}
