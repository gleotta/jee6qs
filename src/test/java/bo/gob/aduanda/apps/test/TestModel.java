package bo.gob.aduanda.apps.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.jpamodelgen.xml.jaxb.Persistence.PersistenceUnit;
import org.hibernate.jpamodelgen.xml.jaxb.PersistenceUnitDefaults;
import org.hibernate.jpamodelgen.xml.jaxb.PersistenceUnitMetadata;

import bo.gob.aduanda.apps.model.Aduana;
import bo.gob.aduanda.apps.model.Barrio;
import bo.gob.aduanda.apps.model.Ciudad;
import bo.gob.aduanda.apps.model.Departamento;
import bo.gob.aduanda.apps.model.Domicilio;
import bo.gob.aduanda.apps.model.Operador;
import bo.gob.aduanda.apps.model.OperadorJuridico;
import bo.gob.aduanda.apps.model.OperadorNatural;
import bo.gob.aduanda.apps.model.OperadorPorAduana;

public class TestModel {
	
	//entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
	
	private static EntityManager em;
	
	private static void cargarLocalidades() {
		
		//create Departamento
		Departamento d = new Departamento();
		d.setNombre("La Paz");
		d.setCiudades(new HashSet<Ciudad>());
		
		//create ciudades
		Ciudad c = new Ciudad();
		c.setNombre("La Paz");
		c.setBarrios(new HashSet<Barrio>());
		c.setDepartamento(d);
		d.getCiudades().add(c);
		
		Ciudad c2 = new Ciudad();
		c2.setNombre("El Alto");
		c2.setBarrios(new HashSet<Barrio>());
		c2.setDepartamento(d);
		d.getCiudades().add(c2);

		//create barrios
		Barrio b = new Barrio();
		b.setCiudad(c);
		b.setNombre("Sopocachi");
		c.getBarrios().add(b);
		
		Barrio b2 = new Barrio();
		b2.setCiudad(c);
		b2.setNombre("Miraflores");
		c.getBarrios().add(b2);
		
		Barrio b3 = new Barrio();
		b3.setCiudad(c2);
		b3.setNombre("Villa Adela");
		c2.getBarrios().add(b3);
		
		
		Barrio b4 = new Barrio();
		b4.setCiudad(c2);
		b4.setNombre("16 de Julio");
		c2.getBarrios().add(b4);
		
		
		em.persist(d);
		
		//agrgear 1 ciudad y 2 barrios
		
	}
	
	private static  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyyy");
	
	public static void cargarOperadores() {
		
		List<Barrio> barrios = em.createQuery("select b from Barrio b").getResultList();
		
		try {
			Domicilio dom1 = new Domicilio();
			dom1.setBarrio(barrios.get(1));
			dom1.setCalle("Av. 20 de Octubre");
			dom1.setNumero("2038");
			dom1.setTelefono("1112222");
			em.persist(dom1);
			
			Domicilio dom2 = new Domicilio();
			dom2.setBarrio(barrios.get(0));
			dom2.setCalle("Av. Arce");
			dom2.setNumero("333");
			dom2.setTelefono("44445555");
			em.persist(dom2);
			
			//cargar 2 operadores juridicos
			OperadorJuridico op1 = new OperadorJuridico();
			op1.setDomicilioLegal(dom1);
			op1.setFechaConstitucion(new Date());
			op1.setNit("NIT222333");
			op1.setRazonSocial("Amancay SL");
			em.persist(op1);
			
			OperadorJuridico op2 = new OperadorJuridico();
			op2.setDomicilioLegal(dom1);
			op2.setFechaConstitucion(new Date());
			op2.setNit("NIT222334");
			op2.setRazonSocial("Tupacaru SL");
			em.persist(op2);
			
			//cargar 3 operadores naturales
			OperadorNatural on1 = new OperadorNatural();
			on1.setApellido("Argento");
			on1.setNombre("Pepe");
			on1.setCi("CI111112222");
			on1.setDomicilioLegal(dom2);
			on1.setFechaNacimiento(dateFormat.parse("01/11/1970"));
			em.persist(on1);
			
			OperadorNatural on2 = new OperadorNatural();
			on2.setApellido("Simpson");
			on2.setNombre("Homero");
			on2.setCi("CI6667777");
			on2.setDomicilioLegal(dom2);
			on2.setFechaNacimiento(dateFormat.parse("01/11/1960"));
			em.persist(on2);
			
			OperadorNatural on3 = new OperadorNatural();
			on3.setApellido("Diaz");
			on3.setNombre("Bruno");
			on3.setCi("CI7777");
			on3.setDomicilioLegal(dom2);
			on3.setFechaNacimiento(dateFormat.parse("15/1/1965"));
			em.persist(on3);
			
			//asignar a 1 operador juridico 2 operadores naturales
			on1.setEmpleador(op1);
			on2.setEmpleador(op1);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
		//asignar a 1 operador juridico 2 operadores naturales
	}
	
	public static void cargarOperadoresPorAduana() {
		
		List<Barrio> barrios = em.createQuery("select b from Barrio b").getResultList();
		

		Domicilio dom1 = new Domicilio();
		dom1.setBarrio(barrios.get(3));
		dom1.setCalle("Av. 20 de Octubre");
		dom1.setNumero("3535");
		dom1.setTelefono("444444");
		em.persist(dom1);
		
		Domicilio dom2 = new Domicilio();
		dom2.setBarrio(barrios.get(2));
		dom2.setCalle("Av. Arce");
		dom2.setNumero("1111");
		dom2.setTelefono("88888");
		em.persist(dom2);
		
		//cargar 2 aduanas
		Aduana a1 = new Aduana();
		a1.setCodigo("211");
		a1.setDescripcion("Aeropuerto El Alto");
		a1.setDomicilio(dom1);
		em.persist(a1);
		//asignar 2 operadores juridicos a Aduana1
		Aduana a2 = new Aduana();
		a2.setCodigo("201");
		a2.setDescripcion("Interior La Paz");
		a2.setDomicilio(dom1);
		em.persist(a2);
		
		//Traigo lista de opredaores
		List<OperadorJuridico> operadoresJuridicos = em.createQuery("select o from OperadorJuridico o").getResultList();
		List<OperadorNatural> operadoresNaturales = em.createQuery("select o from OperadorNatural o").getResultList();

		//asignar 2 operadore juridicos a Aduana1
		OperadorPorAduana opd1 = new OperadorPorAduana();
		opd1.setAduana(a1);
		opd1.setOperador(operadoresJuridicos.get(0));
		opd1.setFechaAceptacion(new Date());
		em.persist(opd1);
		
		OperadorPorAduana opd2 = new OperadorPorAduana();
		opd2.setAduana(a1);
		opd2.setOperador(operadoresJuridicos.get(1));
		opd2.setFechaAceptacion(new Date());
		em.persist(opd2);
		
		//asignar 1 operador natural a Aduana2
		OperadorPorAduana opd3 = new OperadorPorAduana();
		opd3.setAduana(a2);
		opd3.setOperador(operadoresNaturales.get(0));
		opd3.setFechaAceptacion(new Date());
		em.persist(opd3);
		
	}

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jee6qs-test");
		em = emf.createEntityManager();
		try {
//			//Incio transaccion
//			em.getTransaction().begin();
//			
//			cargarLocalidades();
//			
//			//Imprimr localidades
//			List<Barrio> barrios = em.createQuery("select b from Barrio b").getResultList();
//			for (Barrio barrio : barrios) {
//				System.out.println("barrio: "+barrio.getNombre()+" ,ciudad "+barrio.getCiudad().getNombre()+", departamento: "+barrio.getCiudad().getDepartamento().getNombre());
//			}
//			
//			cargarOperadores();
//			//Imprimr operadores
//			List<Operador> operadores = em.createQuery("select o from Operador o").getResultList();
//			for (Operador operador : operadores) {
//				System.out.println("Operador id: "+operador.getIdentificador()+ ", operador: "+operador);
//			}
//			
//			cargarOperadoresPorAduana();
//			List<OperadorPorAduana> opds = em.createQuery("select o from OperadorPorAduana o").getResultList();
//			for (OperadorPorAduana operadorPorAduana : opds) {
//				System.out.println("Operadores por aduana:"+operadorPorAduana);
//			}
//			
//			//Departamento d = em.find(Departamento.class, 1l);
//			//em.remove(d);
//			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

}
