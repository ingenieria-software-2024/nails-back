package jsges.nails.service.articulos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jsges.nails.DTO.articulos.LineaDTO;
import jsges.nails.domain.articulos.Linea;

public interface ILineaService {
  /**
   * Obtiene todos los lineas registrados en el dominio.
   *
   * @return Una lista con todos los lineas registrados.
   */
  public List<Linea> listar();

  /**
   * Busca un linea por su ID.
   *
   * @param id El ID del linea a buscar.
   *
   * @return El linea encontrado.
   */
  public Linea buscarPorId(Integer id);

  /**
   * Guarda un linea en el dominio.
   *
   * @param model El linea a guardar.
   *
   * @return El linea guardado.
   */
  public Linea guardar(Linea model);

  /**
   * Elimina un linea del dominio.
   *
   * @param model El linea a eliminar.
   */
  public void eliminar(Linea model);

  /**
   * Obtiene una lista de lineas que coinciden con la consulta dada.
   *
   * @param consulta La consulta para filtrar los lineas.
   *
   * @return Una lista de lineas que coinciden con la consulta.
   */
  public List<Linea> listar(String consulta);

  /**
   * Obtiene una pagina de lineas.
   *
   * @param pageable La informacion de paginacion.
   *
   * @return Una pagina de lineas.
   */
  public Page<Linea> getLineas(Pageable pageable);

  /**
   * Encuentra una pagina de LineaDTO a partir de una lista dada.
   *
   * @param pageable La informacion de paginacion.
   * @param lineas   La lista de LineaDTO a paginar.
   *
   * @return Una pagina de LineaDTO.
   */
  public Page<LineaDTO> findPaginated(Pageable pageable, List<LineaDTO> lineas);

  /**
   * Busca lineas que coinciden con la consulta dada.
   *
   * @param consulta La consulta para filtrar los lineas.
   *
   * @return Una lista de lineas que coinciden con la consulta.
   */
  public List<Linea> buscar(String consulta);

  /**
   * Crea un nuevo modelo de Linea a partir de un LineaDTO.
   *
   * @param model El LineaDTO a convertir en Linea.
   *
   * @return El nuevo Linea creado.
   */
  public Linea newModel(LineaDTO model);
}