package jsges.nails.controller.mapper;

import jsges.nails.domain.articulos.ArticuloVenta;
import jsges.nails.dto.articulos.ArticuloVentaDTO;

public class ArticuloVentaMapper {

  public ArticuloVentaMapper() {
    super();
  }

  public static ArticuloVentaDTO toArticuloVentaDTO(ArticuloVenta articuloVenta) {
    return new ArticuloVentaDTO(articuloVenta);
  }

  public static ArticuloVenta toArticuloVenta(ArticuloVentaDTO articuloVentaDTO) {
    ArticuloVenta articuloVenta = new ArticuloVenta();
    articuloVenta.setId(articuloVentaDTO.id);
    articuloVenta.setDenominacion(articuloVentaDTO.denominacion);
    return articuloVenta;
  }
}
