package jsges.nails.dto.articulos;

import jsges.nails.domain.articulos.ArticuloVenta;
import jsges.nails.dto.TipoObjetoDTO;

public class ArticuloVentaDTO extends TipoObjetoDTO {

  public Integer id;
  public String denominacion;
  public Integer linea;

  public ArticuloVentaDTO(ArticuloVenta model) {
    this.id = model.getId();
    this.denominacion = model.getDenominacion();
    this.linea = model.getLinea().getId();
  }

  public ArticuloVentaDTO() {}
}
