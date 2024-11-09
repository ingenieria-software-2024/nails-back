package jsges.nails.service.servicios;

import java.util.List;
import jsges.nails.DTO.servicios.TipoServicioDTO;
import jsges.nails.domain.servicios.TipoServicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITipoServicioService {
  /**
   * Obtiene todos los tipos de servicio registrados en el dominio.
   *
   * @return Una lista con todos los tipos de servicio registrados.
   */
  public List<TipoServicio> listar();

  /**
   * Busca un tipo de servicio por su ID.
   *
   * @param id El ID del tipo de servicio a buscar.
   *
   * @return El tipo de servicio encontrado.
   */
  public TipoServicio buscarPorId(Integer id);

  /**
   * Guarda un tipo de servicio en el dominio.
   *
   * @param model El tipo de servicio a guardar.
   *
   * @return El tipo de servicio guardado.
   */
  public TipoServicio guardar(TipoServicio model);

  /**
   * Elimina un tipo de servicio del dominio.
   *
   * @param model El tipo de servicio a eliminar.
   */
  public void eliminar(TipoServicio model);

  /**
   * Obtiene una lista de tipos de servicio que coinciden con la consulta dada.
   *
   * @param consulta La consulta para filtrar los tipos de servicio.
   *
   * @return Una lista de tipos de servicio que coinciden con la consulta.
   */
  public List<TipoServicio> listar(String consulta);

  /**
   * Obtiene una pagina de tipos de servicio.
   *
   * @param pageable La informacion de paginacion.
   *
   * @return Una pagina de tipos de servicio.
   */
  public Page<TipoServicio> getTiposServicios(Pageable pageable);

  /**
   * Encuentra una pagina de tipos de servicio a partir de una lista dada.
   *
   * @param pageable      La informacion de paginacion.
   * @param tipoServicios La lista de tipos de servicio a paginar.
   *
   * @return Una pagina de tipos de servicio.
   */
  public Page<TipoServicio> findPaginated(
    Pageable pageable,
    List<TipoServicio> tipoServicios
  );

  /**
   * Busca tipos de servicio que coinciden con la consulta dada.
   *
   * @param consulta La consulta para filtrar los tipos de servicio.
   *
   * @return Una lista de tipos de servicio que coinciden con la consulta.
   */
  public List<TipoServicio> buscar(String consulta);

  /**
   * Convierte un DTO en un modelo.
   *
   * @param dto El DTO a convertir.
   *
   * @return El modelo creado.
   */
  public TipoServicio newModel(TipoServicioDTO dto);
}
