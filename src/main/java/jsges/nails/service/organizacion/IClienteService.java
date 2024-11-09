package jsges.nails.service.organizacion;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jsges.nails.DTO.Organizacion.ClienteDTO;
import jsges.nails.domain.organizacion.Cliente;

public interface IClienteService {
  /**
   * Obtiene todos los clientes registrados en el dominio.
   *
   * @return Una lista con todos los clientes registrados.
   */
  public List<Cliente> listar();

  /**
   * Busca un cliente por su ID.
   *
   * @param id El ID del cliente a buscar.
   *
   * @return El cliente encontrado.
   */
  public Cliente buscarPorId(Integer id);

  /**
   * Guarda un cliente en el dominio.
   *
   * @param cliente El cliente a guardar.
   *
   * @return El cliente guardado.
   */
  public Cliente guardar(Cliente cliente);

  /**
   * Elimina un cliente del dominio.
   *
   * @param cliente El cliente a eliminar.
   */
  public void eliminar(Cliente cliente);

  /**
   * Obtiene una lista de clientes que coinciden con la consulta dada.
   *
   * @param consulta La consulta para filtrar los clientes.
   *
   * @return Una lista de clientes que coinciden con la consulta.
   */
  public List<Cliente> listar(String consulta);

  /**
   * Obtiene una pagina de clientes.
   *
   * @param pageable La informacion de paginacion.
   *
   * @return Una pagina de clientes.
   */
  public Page<Cliente> getClientes(Pageable pageable);

  /**
   * Encuentra una pagina de ClienteDTO a partir de una lista dada.
   *
   * @param pageable La informacion de paginacion.
   * @param clientes La lista de ClienteDTO a paginar.
   *
   * @return Una pagina de ClienteDTO.
   */
  public Page<ClienteDTO> findPaginated(Pageable pageable, List<ClienteDTO> clientes);
}