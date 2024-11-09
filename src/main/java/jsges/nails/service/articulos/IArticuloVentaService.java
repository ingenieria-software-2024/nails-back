package jsges.nails.service.articulos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jsges.nails.DTO.articulos.ArticuloVentaDTO;
import jsges.nails.domain.articulos.ArticuloVenta;

public interface IArticuloVentaService {
  /**
   * Obtiene todos los articulos de venta registrados en el dominio.
   *
   * @return Una lista con todos los articulos de venta registrados.
   */
  public List<ArticuloVenta> listar();

  /**
   * Busca un articulo de venta por su ID.
   *
   * @param id El ID del articulo de venta a buscar.
   *
   * @return El articulo de venta encontrado.
   */
  public ArticuloVenta buscarPorId(Integer id);

  /**
   * Guarda un articulo de venta en el dominio.
   *
   * @param model El articulo de venta a guardar.
   *
   * @return El articulo de venta guardado.
   */
  public ArticuloVenta guardar(ArticuloVenta model);

  /**
   * Elimina un articulo de venta del dominio.
   *
   * @param model El articulo de venta a eliminar.
   */
  public void eliminar(ArticuloVenta model);

  /**
   * Obtiene una lista de articulos de venta que coinciden con la consulta dada.
   *
   * @param consulta La consulta para filtrar los articulos de venta.
   *
   * @return Una lista de articulos de venta que coinciden con la consulta.
   */
  public List<ArticuloVenta> listar(String consulta);

  /**
   * Obtiene una pagina de articulos de venta.
   *
   * @param pageable La informacion de paginacion.
   *
   * @return Una pagina de articulos de venta.
   */
  public Page<ArticuloVenta> getArticulos(Pageable pageable);

  /**
   * Encuentra una pagina de ArticuloVentaDTO a partir de una lista dada.
   *
   * @param pageable La informacion de paginacion.
   * @param list     La lista de ArticuloVentaDTO a paginar.
   *
   * @return Una pagina de ArticuloVentaDTO.
   */
  public Page<ArticuloVentaDTO> findPaginated(Pageable pageable, List<ArticuloVentaDTO> list);
}
