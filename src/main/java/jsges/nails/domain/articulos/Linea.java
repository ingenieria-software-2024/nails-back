package jsges.nails.domain.articulos;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jsges.nails.DTO.articulos.LineaDTO;
import jsges.nails.domain.TipoObjeto;
import lombok.Data;
import lombok.ToString;
import java.util.List;

@Entity
@Data
@ToString
public class Linea extends TipoObjeto {

  //@Id
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  //private Integer id;

  //@Column(columnDefinition = "TEXT")
  //String denominacion;
  //int estado;

  //@Column(columnDefinition = "TEXT")
  //String observacion;

  @OneToMany(mappedBy = "linea")
  private List<ArticuloVenta> articulosVenta;

  public Linea() {
    // Constructor por defecto necesario para JPA
  }

  public Linea(String nombre) {
    this.setDenominacion(nombre);
  }

  public Linea(LineaDTO model) {
    this.setDenominacion(model.denominacion);
  }
}
