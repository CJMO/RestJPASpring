package logica_negocio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Zona;

public class zonaDAO {
	
EntityManager em = getEntityManager();
	
	private static final EntityManagerFactory emFactoryObj;
    private static final String PERSISTENCE_UNIT_NAME = "unidadPersistencia";  
    
    static {
        emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
    
    // Retornar objeto 'EntityManager'
    public static EntityManager getEntityManager() {
        return emFactoryObj.createEntityManager();
    }
    
    @SuppressWarnings("unchecked")
	public List<Zona> lista_zonas() {		
		return em.createNamedQuery("zonas.getAll").getResultList();
	}

}
