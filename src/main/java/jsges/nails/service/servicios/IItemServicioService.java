package jsges.nails.service.servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jsges.nails.domain.servicios.ItemServicio;

public interface IItemServicioService {
  /**
   * Obtiene todos los items de servicio registrados en el dominio.
   *
   * @return Una lista con todos los items de servicio registrados.
   */
  public List<ItemServicio> listar();

  /**
   * Busca un item de servicio por su ID.
   *
   * @param id El ID del item de servicio a buscar.
   *
   * @return El item de servicio encontrado.
   */
  public ItemServicio buscarPorId(Integer id);

  /**
   * Guarda un item de servicio en el dominio.
   *
   * @param model El item de servicio a guardar.
   *
   * @return El item de servicio guardado.
   */
  public ItemServicio guardar(ItemServicio model);

  /**
   * Encuentra una pagina de items de servicio a partir de una lista dada.
   *
   * @param pageable  La informacion de paginacion.
   * @param servicios La lista de items de servicio a paginar.
   *
   * @return Una pagina de items de servicio.
   */
  public Page<ItemServicio> findPaginated(Pageable pageable, List<ItemServicio> servicios);

  /**
   * Obtiene una pagina de items de servicio.
   *
   * @param pageable La informacion de paginacion.
   *
   * @return Una pagina de items de servicio.
   */
  public Page<ItemServicio> getItemServicios(Pageable pageable);

  /**
   * Busca items de servicio por el ID del servicio.
   *
   * @param idServicio El ID del servicio para filtrar los items de servicio.
   *
   * @return Una lista de items de servicio que coinciden con el ID del servicio.
   */
  public List<ItemServicio> buscarPorServicio(Integer idServicio);
}