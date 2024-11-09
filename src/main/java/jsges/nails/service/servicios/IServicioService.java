package jsges.nails.service.servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jsges.nails.DTO.servicios.ServicioDTO;
import jsges.nails.domain.servicios.Servicio;

public interface IServicioService {
  public List<Servicio> listar();

  public Servicio buscarPorId(Integer id);

  public Servicio guardar(Servicio model);

  public Page<ServicioDTO> findPaginated(Pageable pageable, List<ServicioDTO> servicios);

  public Page<Servicio> getServicios(Pageable pageable);

  public List<Servicio> listar(String consulta);
}
