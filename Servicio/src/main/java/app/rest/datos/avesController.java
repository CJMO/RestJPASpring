package app.rest.datos;

import java.util.ArrayList;
import java.util.List;

import logica_negocio.aveDAO;

import logica_negocio.avePaisDAO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import entidades.AVES_PAISES;
import entidades.Ave;

@RestController
public class avesController {
	
	// Definir objetos DAO para gestión de entidades
	aveDAO gestor_aves = new aveDAO();
	avePaisDAO gestor_aves_paises = new avePaisDAO();
	
	@RequestMapping(value="/ave",method = RequestMethod.GET)
	public @ResponseBody String ave() {
		return "Página de inicio";
	}
	
	/***
	 * Servicio para insertar nueva ave
	 * @param codigo Código del ave
	 * @param nombre_comun Nombre común del ave
	 * @param nombre_cient Nombre científico del ave
	 * @param codigo_pais Código de país del ave (para tener registro de la zona)
	 * @return respuesta String
	 */
	@RequestMapping(value="/aves/insertar",method = RequestMethod.POST)
	public @ResponseBody String insertar(@RequestParam String codigo, @RequestParam String nombre_comun, 
			@RequestParam String nombre_cient, @RequestParam String codigo_pais) {		
	    		
		// Asignar datos de ave
		Ave a;
		
		// Validar que ave no exista		
		a = gestor_aves.obtener_ave(codigo);
		
		if( a!=null && a.getCd().equals(codigo) ){
			return "Ya existe una ave con la información suministrada";
		}
		
		else{
			a = new Ave();
			
			a.setCd(codigo);
			a.setNombre(nombre_comun);
			a.setNombre_cientifico(nombre_cient);
			gestor_aves.agregar_ave(a);
			
			//Asignar datos de ave por país
			AVES_PAISES ap = new AVES_PAISES();
			ap.setCd_ave(codigo);
			ap.setCd_pais(codigo_pais);
			gestor_aves_paises.agregar_ave_pais(ap);
			return "Ave ingresada";
		}		
		
	}
	
	/***
	 * Editar información de ave
	 * @param codigo Código del ave
	 * @param nombre_comun Nombre común del ave
	 * @param nombre_cient Nombre científico del ave
	 * @return
	 */
	@RequestMapping(value="/aves/editar",method = RequestMethod.POST)
	public @ResponseBody String editar(@RequestParam String codigo, @RequestParam String nombre_comun, 
			@RequestParam String nombre_cient) {		
	    		
		// Consultar ave
		Ave a = new Ave();
		a = gestor_aves.obtener_ave(codigo);
		
		if(a==null || a.getCd()==null){
			return "El ave especificada no existe";
		}
		
		// Actualizar datos de ave
		a.setNombre(nombre_comun);
		a.setNombre_cientifico(nombre_cient);		
		gestor_aves.editar_ave(a);
			
		return "Datos de ave actualizados";
	}
	
	/***
	 * Eliminar ave
	 * @param codigo Código del ave
	 * @param codigo_pais Código del país para ave
	 * @return respuesta String
	 */
	@RequestMapping(value="/aves/eliminar",method = RequestMethod.POST)
	public @ResponseBody String eliminar(@RequestParam String codigo, @RequestParam String codigo_pais) {		
	    		
		// Consultar ave
		Ave a = new Ave();
		a = gestor_aves.obtener_ave(codigo);
		
		if(a==null || a.getCd()==null){
			return "El ave especificada no existe";
		}		
		
		//Eliminar datos en tabla de aves por país
		gestor_aves_paises.eliminar_ave(codigo_pais, codigo);
		
		// Eliminar ave
		gestor_aves.eliminar_ave(codigo);
		
		return "Ave eliminada";
	}
	
	/***
	 * Retornar listado de aves
	 * @return lista List
	 */
	@RequestMapping(value = "/aves/lista", method = RequestMethod.GET)
	public List<Ave> listaAves() {
	 
		// Usar función que retorna aves sin filtrar datos
		List<Ave> lista = new ArrayList<Ave>();
		lista = gestor_aves.lista_aves();
		
		return lista;
	}
	
	/***
	 * Retornar listado de aves, filtrando por zona
	 * @param nombre_comun Nombre común del ave
	 * @param nombre_cient Nombre científico del ave
	 * @param zona Código de zona del ave
	 * @return lista List
	 */
	@RequestMapping(value = "/aves/lista_zona", method = RequestMethod.GET)
	public List<Ave> listaAvesZona(@RequestParam String nombre_comun, @RequestParam String nombre_cient, @RequestParam String zona) {
	 
		// Usar función que realiza filtrado por nombre o zona
		List<Ave> lista = new ArrayList<Ave>();
		lista = gestor_aves.lista_aves_zona(nombre_comun, nombre_cient, zona);
		
		return lista;
	}

}
