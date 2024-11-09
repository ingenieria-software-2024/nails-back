package jsges.nails.dto.articulos;

import jsges.nails.domain.articulos.Linea;
import jsges.nails.dto.TipoObjetoDTO;

public class LineaDTO extends TipoObjetoDTO {

  public LineaDTO() {
    super();
  }

  public LineaDTO(Linea linea) {
    this.id = linea.getId();
    this.denominacion = linea.getDenominacion();
  }
}
