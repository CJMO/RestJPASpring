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
@Table(name = "tont_paises")
@NamedQueries(@NamedQuery(name="paises.getAll",query="SELECT p FROM Pais p"))
public class Pais {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "CDPAIS")
    private String cd;
	
	@Column(name = "DSNOMBRE")
    private String nombre;
	
	@Column(name = "CDZONA")
    private String zona;
	
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
	
	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

}
