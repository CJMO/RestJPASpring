package logica_negocio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.AVES_PAISES;

public class avePaisDAO {
	
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
    
    public void agregar_ave_pais(AVES_PAISES ap) {
    	
    	em.getTransaction().begin();
		em.persist(ap);		
		em.getTransaction().commit();
	}

	public void editar_ave(AVES_PAISES ap) {
		em.getTransaction().begin();
		em.merge(ap);	
		em.getTransaction().commit();
	}

	public void eliminar_ave(String cd_pais, String cd_ave) {
		em.getTransaction().begin();
		em.remove(obtener_ave_pais(cd_pais, cd_ave));		
		em.getTransaction().commit();
	}


	public AVES_PAISES obtener_ave_pais(String cd_pais, String cd_ave) {
		return (AVES_PAISES) em.createNamedQuery("aves_paises.get")
		  .setParameter("pais",cd_pais)
		  .setParameter("ave",cd_ave).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<AVES_PAISES> lista_aves() {		
		return em.createNamedQuery("aves_paises.getAll").getResultList();
	}

}
