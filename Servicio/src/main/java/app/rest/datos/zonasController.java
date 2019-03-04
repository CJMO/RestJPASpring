package app.rest.datos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entidades.Zona;
import logica_negocio.zonaDAO;

@RestController
public class zonasController {
	
	zonaDAO gestor_zonas = new zonaDAO();
	
	/***
	 * Retorna lista de zonas para lista desplegable en página de búsquedas
	 * @return lista List
	 */
	@RequestMapping(value = "/zonas/lista", method = RequestMethod.GET)
	public List<Zona> listaZonas() {
	 
		// Usar función que retorna lista de zonas
		List<Zona> lista = new ArrayList<Zona>();
		lista = gestor_zonas.lista_zonas();
		
		return lista;
	}

}
