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
@Table(name = "tont_aves_pais")
@NamedQueries({
@NamedQuery(name="aves_paises.getAll",query="SELECT ap FROM AVES_PAISES ap"),
@NamedQuery(name = "aves_paises.get", query = "SELECT ap FROM AVES_PAISES ap WHERE ap.cd_pais = :pais and ap.cd_ave = :ave")})
public class AVES_PAISES {

	@Id
    @Column(name = "CDPAIS")
    private String cd_pais;
	
	@Id
    @Column(name = "CDAVE")
    private String cd_ave;

	public String getCd_pais() {
		return cd_pais;
	}

	public void setCd_pais(String cd_pais) {
		this.cd_pais = cd_pais;
	}

	public String getCd_ave() {
		return cd_ave;
	}

	public void setCd_ave(String cd_ave) {
		this.cd_ave = cd_ave;
	}
	
}
