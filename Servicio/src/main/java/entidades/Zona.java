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

// Agregar NamedQueries para realizar búsquedas de datos
@Entity
@Table(name = "tont_zonas")
@NamedQueries(@NamedQuery(name="zonas.getAll",query="SELECT z FROM Zona z"))

public class Zona {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "CDZONA")
    private String cd;
	
	@Column(name = "DSNOMBRE")
    private String nombre;

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
}
