package jsges.nails.controller.mapper;

import jsges.nails.domain.articulos.Linea;
import jsges.nails.dto.articulos.LineaDTO;

public class LineaMapper {

  public LineaMapper() {
    super();
  }

  public static LineaDTO toLineaDTO(Linea linea) {
    return new LineaDTO(linea);
  }

  public static Linea toLinea(LineaDTO lineaDTO) {
    Linea linea = new Linea();
    linea.setId(lineaDTO.getId());
    linea.setDenominacion(lineaDTO.getDenominacion());
    return linea;
  }
}
