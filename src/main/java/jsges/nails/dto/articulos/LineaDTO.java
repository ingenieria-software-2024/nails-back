package jsges.nails.dto.articulos;

import jsges.nails.domain.articulos.Linea;
import lombok.Data;

@Data
public class LineaDTO {

  private Integer id;
  private String denominacion;

  public LineaDTO() {}

  public LineaDTO(Linea model) {
    this.id = model.getId();
    this.denominacion = model.getDenominacion();
  }
}
