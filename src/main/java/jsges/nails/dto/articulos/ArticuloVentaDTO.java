package jsges.nails.dto.articulos;

import jsges.nails.domain.articulos.ArticuloVenta;
import lombok.Data;

@Data
public class ArticuloVentaDTO {

  private Integer id;
  private String denominacion;
  private Integer linea;

  public ArticuloVentaDTO() {}

  public ArticuloVentaDTO(ArticuloVenta model) {
    this.id = model.getId();
    this.denominacion = model.getDenominacion();
    this.linea = model.getLinea().getId();
  }
}
