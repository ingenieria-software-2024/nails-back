package jsges.nails.controller.mapper;

import jsges.nails.domain.servicios.Servicio;
import jsges.nails.dto.servicios.ServicioDTO;

public class ServicioMapper {

  public ServicioMapper() {
    super();
  }

  public static ServicioDTO toServicioDTO(Servicio servicio) {
    return new ServicioDTO(servicio);
  }

  public static Servicio toServicio(ServicioDTO servicioDTO) {
    Servicio servicio = new Servicio();
    servicio.setId(servicioDTO.getId());
    servicio.setFechaRealizacion(servicioDTO.getFechaDocumento());
    servicio.setTotal(servicioDTO.getTotal());
    return servicio;
  }
}
