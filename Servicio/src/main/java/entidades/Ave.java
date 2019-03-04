package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/***
 * 
 * @author CRISTIAN.MUÑOZ
 *
 */

//Agregar NamedQueries para realizar búsquedas de datos
@Entity
@Table(name = "tont_aves")
@NamedQueries({
		@NamedQuery(name="aves.getAll",query="SELECT a FROM Ave a"),
		@NamedQuery(name = "aves.get", query = " SELECT a FROM Ave a INNER JOIN AVES_PAISES ap ON a.cd=ap.cd_ave "
			+ "INNER JOIN Pais p ON p.cd=ap.cd_pais INNER JOIN Zona z ON z.cd=p.zona "
			+ "WHERE a.nombre LIKE CONCAT('%',:nombre, '%') "
			+ "OR a.nombre_cientifico LIKE CONCAT('%',:nombre_cient, '%') "
			+ "OR z.cd=:zona")})

public class Ave{
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "CDAVE")
    private String cd;
	
	@Column(name = "DSNOMBRE_COMUN")
    private String nombre;    
	
	@Column(name = "DSNOMBRE_CIENTIFICO")
    private String nombre_cientifico;

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre_cientifico() {
		return nombre_cientifico;
	}

	public void setNombre_cientifico(String nombre_cientifico) {
		this.nombre_cientifico = nombre_cientifico;
	}

}
