package bo.gob.aduanda.apps.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientRequestFactory;
import org.jboss.resteasy.client.ClientResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.istack.logging.Logger;

import bo.gob.aduanda.apps.model.Operador;

public class OperadoresServiceRESTTest {

	private static String baseUri = "http://localhost:8080/jee6qs/rest";

	private static Logger log = Logger
			.getLogger(OperadoresServiceRESTTest.class);

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testObtenerOperador() {
		String command = "/operador/id/1971674";
		ClientRequest request = new ClientRequest(baseUri + command);
		try {
			ClientResponse<String> response = request.get();
			if (response.getStatus() != 200) {
				fail("Error HTTP: " + response.getStatus());
			}
			String resultado = response.getEntity(String.class);
			assertNotNull(resultado);
			log.info(resultado.toString() + "\n");

		} catch (Exception e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testObtenerOperadores() {
		String command = "/operador/list";
		ClientRequest request = new ClientRequest(baseUri + command);
		try {
			ClientResponse<String> response = request.get();
			if (response.getStatus() != 200) {
				fail("Error HTTP: " + response.getStatus());
			}
			String resultado = response.getEntity(String.class);
			assertNotNull(resultado);
			log.info(resultado.toString() + "\n");

		} catch (Exception e) {
			fail(e.getMessage());
		}

	}

	//@Test
	public void testObtenerOperadoresJuridicos() {
		fail("Not yet implemented");
	}

	//@Test
	public void testObtenerOperadoresNaturales() {
		fail("Not yet implemented");
	}

	@Test
	public void testAltaOperadorNatural() {
		/*
		 * { "nombre":"Nueva Persona", "ci":"1111", "apellido":"MERCADO RODAS",
		 * "fechaNacimiento":26280000000, "domicilioLegal":{ "calle":"CALLE 12",
		 * "numero":"21", "edificio":null, "piso":null, "oficina":null,
		 * "celular":null, "telefono":"2912527", "barrio":{ "id":5 } } }
		 */

		String command = "/operador/natural/create";
		ClientRequest request = new ClientRequest(baseUri + command);
		try {
			String operadorNaturalJson = "{  \"nombre\":\"Nueva Persona\",  \"ci\":\""+System.currentTimeMillis()+"\", "
					+ " \"apellido\":\"MERCADO RODAS\",  \"fechaNacimiento\":26280000000, "
					+ " \"domicilioLegal\":{   \"calle\":\"CALLE 15\",   "
					+ " \"numero\":\"21\",    \"edificio\":null,    \"piso\":null,   "
					+ " \"oficina\":null,    \"celular\":null,    \"telefono\":\"2912527\", "
					+ "   \"barrio\":{      \"id\":5    }  }}";
			request.body("application/json", operadorNaturalJson);
			ClientResponse<String> response = request.post();
			
			if (response.getStatus() != 200) {
				fail("Error HTTP: " + response.getStatus());
			}
			String resultado = response.getEntity(String.class);
			log.info(resultado);
			assertEquals(resultado,"");
			

		} catch (Exception e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testAltaOperadorJuridico() {

		/*
		 * { "nit":"111111", "razonSocial":"Nueva Empresa Operadora",
		 * "fechaConstitucion":961041600000, "domicilioLegal":{
		 * "calle":"Calle Abdon Saavedra", "numero":"1925",
		 * "edificio":"Los Laureles", "piso":"P.B.", "oficina":"Of. n 1",
		 * "celular":null, "telefono":"2413325", "barrio":{ "id":4 } } }
		 */



		String command = "/operador/juridico/create";
		ClientRequest request = new ClientRequest(baseUri + command);
		try {
			String operadorJuridicoJson = "{ \"nit\":\""+ System.currentTimeMillis() +"\", \"razonSocial\":\"Nueva Empresa Operadora\","
					+ "\"fechaConstitucion\":961041600000, "
					+ "\"domicilioLegal\":{\"calle\":\"Calle Abdon Saavedra2\","
					+ " \"numero\":\"1925\",\"edificio\":\"Los Laureles\","
					+ " \"piso\":\"P.B.\", \"oficina\":\"Of. n 1\","
					+ "\"celular\":null, \"telefono\":\"2413325\", "
					+ "\"barrio\":{ \"id\":4 } } }";
			System.out.println(operadorJuridicoJson);
			request.body("application/json", operadorJuridicoJson);
			ClientResponse<String> response = request.post();
			
			if (response.getStatus() != 200) {
				fail("Error HTTP: " + response.getStatus());
			}
			String resultado = response.getEntity(String.class);
			log.info(resultado);
			assertEquals(resultado,"");
			

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	//@Test
	public void testEditarOperadorNatural() {
		fail("Not yet implemented");
	}

	//@Test
	public void testEditarOperadorJuridico() {
		/*
		 *{
			  "nit":"1020304050",
			  "razonSocial":"AGC SRL UPDATED",
			  "domicilioFisico":null,
			  "fechaConstitucion":909892800000,
			  "cantidadEmpleados":null,
			  "id":14,
			  "domicilioLegal":{
			    "id":9,
			    "calle":"Calle Abdon Saavedra",
			    "numero":"1925",
			    "edificio":"Los Laureles",
			    "piso":"P.B.",
			    "oficina":"Of. NÃ‚Âº 1",
			    "celular":null,
			    "telefono":"2413325",
			    "barrio":{
			      "id":4
			    }
			  }
			}
		 * */
		
		
		
		fail("Not yet implemented");
	}

	//@Test
	public void testBorrarOperador() {
		fail("Not yet implemented");
	}

}
