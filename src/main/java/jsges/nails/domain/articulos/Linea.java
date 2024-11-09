package jsges.nails.domain.articulos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import jsges.nails.domain.TipoObjeto;
import jsges.nails.dto.articulos.LineaDTO;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Linea extends TipoObjeto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  String denominacion;

  int estado;

  String observacion;

  @OneToMany(mappedBy = "linea")
  private List<ArticuloVenta> articulosVenta;

  public Linea() {}

  public Linea(String nombre) {
    this.setDenominacion(nombre);
  }

  public Linea(LineaDTO model) {
    this.setDenominacion(model.denominacion);
  }
}
