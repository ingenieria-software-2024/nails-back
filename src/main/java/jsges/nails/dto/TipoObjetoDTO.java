package jsges.nails.dto;

import lombok.Data;

@Data
public class TipoObjetoDTO {

  private Integer id;
  private String denominacion;

  public TipoObjetoDTO(Integer id, String denominacion) {
    this.id = id;
    this.denominacion = denominacion;
  }
}
