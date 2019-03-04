package logica_negocio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Ave;

public class aveDAO {
	
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
    
	public void agregar_ave(Ave ave) {
    	
    	em.getTransaction().begin();
		em.persist(ave);		
		em.getTransaction().commit();
	}

	public void editar_ave(Ave ave) {
		em.getTransaction().begin();
		em.merge(ave);	
		em.getTransaction().commit();
	}

	public void eliminar_ave(String cd_ave) {
		em.getTransaction().begin();
		em.remove(obtener_ave(cd_ave));		
		em.getTransaction().commit();
	}


	public Ave obtener_ave(String cd_ave) {
		return em.find(Ave.class, cd_ave);
	}

	@SuppressWarnings("unchecked")
	public List<Ave> lista_aves() {		
		return em.createNamedQuery("aves.getAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Ave> lista_aves_zona(String nom, String nom_cient, String zona){
		return em.createNamedQuery("aves.get")
		  .setParameter("nombre",nom)
		  .setParameter("nombre_cient",nom_cient)
		  .setParameter("zona",zona).getResultList();
	}

 
    /*public static void main(String[] args) {
 
        EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();
 
        Ave ave = new Ave();
        ave.setCd("ABC");
		ave.setNombre("AVE 1");
		ave.setNombre_cientifico("AESTRFGTONUS");
        entityMgr.persist(ave);
 
        entityMgr.getTransaction().commit();
 
        entityMgr.clear();
        System.out.println("Guardado");
    }*/

}
