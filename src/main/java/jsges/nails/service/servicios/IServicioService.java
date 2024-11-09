package jsges.nails.service.servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jsges.nails.DTO.servicios.ServicioDTO;
import jsges.nails.domain.servicios.Servicio;

public interface IServicioService {
  /**
   * Obtiene todos los servicios registrados en el dominio.
   *
   * @return Una lista con todos los servicios registrados.
   */
  public List<Servicio> listar();

  /**
   * Busca un servicio por su ID.
   *
   * @param id El ID del servicio a buscar.
   *
   * @return El servicio encontrado.
   */
  public Servicio buscarPorId(Integer id);

  /**
   * Guarda un servicio en el dominio.
   *
   * @param model El servicio a guardar.
   *
   * @return El servicio guardado.
   */
  public Servicio guardar(Servicio model);

  /**
   * Encuentra una pagina de ServicioDTO a partir de una lista dada.
   *
   * @param pageable  La informacion de paginacion.
   * @param servicios La lista de ServicioDTO a paginar.
   *
   * @return Una pagina de ServicioDTO.
   */
  public Page<ServicioDTO> findPaginated(Pageable pageable, List<ServicioDTO> servicios);

  /**
   * Obtiene una pagina de servicios.
   *
   * @param pageable La informacion de paginacion.
   *
   * @return Una pagina de servicios.
   */
  public Page<Servicio> getServicios(Pageable pageable);

  /**
   * Obtiene una lista de servicios que coinciden con la consulta dada.
   *
   * @param consulta La consulta para filtrar los servicios.
   *
   * @return Una lista de servicios que coinciden con la consulta.
   */
  public List<Servicio> listar(String consulta);
}