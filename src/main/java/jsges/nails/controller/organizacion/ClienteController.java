package jsges.nails.controller.organizacion;

import java.util.ArrayList;
import java.util.List;
import jsges.nails.domain.organizacion.Cliente;
import jsges.nails.dto.Organizacion.ClienteDTO;
import jsges.nails.exception.RecursoNoEncontradoExcepcion;
import jsges.nails.services.organizacion.IClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${path.mapping}")
@CrossOrigin(value = "${path.cors}")
public class ClienteController {

  private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

  @Autowired
  private IClienteService clienteServicio;

  /**
   * Obtiene todos los clientes
   *
   * @return lista de clientes
   */
  @GetMapping("/clientes")
  public List<ClienteDTO> getAll() {
    List<ClienteDTO> listadoDTO = new ArrayList<>();
    List<Cliente> list = this.clienteServicio.listar();

    list.forEach(model -> {
      listadoDTO.add(new ClienteDTO(model));
    });
    return listadoDTO;
  }

  /**
   * Obtiene todos los clientes paginados
   *
   * @param consulta // consulta para filtrar
   * @param page     // pagina
   * @param size     // tamaño de la pagina
   *
   * @return lista de clientes paginados
   */
  @GetMapping("/clientesPageQuery")
  public ResponseEntity<Page<ClienteDTO>> getItems(
    @RequestParam(defaultValue = "") String consulta,
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "${page.max}") int size
  ) {
    List<Cliente> listado = clienteServicio.listar(consulta);
    List<ClienteDTO> listadoDTO = new ArrayList<>();
    listado.forEach(model -> {
      listadoDTO.add(new ClienteDTO(model));
    });
    Page<ClienteDTO> bookPage = clienteServicio.findPaginated(
      PageRequest.of(page, size),
      listadoDTO
    );
    return ResponseEntity.ok().body(bookPage);
  }

  /**
   * Agrega un cliente
   *
   * @param cliente // cliente a agregar
   *
   * @return cliente agregado
   */
  @PostMapping("/clientes")
  public Cliente agregar(@RequestBody Cliente cliente) {
    // logger.info("Cliente a agregar: " + cliente);
    return clienteServicio.guardar(cliente);
  }

  /**
   * Elimina un cliente
   *
   * @param id // id del cliente a eliminar
   *
   * @return cliente eliminado
   */
  @DeleteMapping("/clientes/{id}")
  public ResponseEntity<Cliente> eliminar(@PathVariable Integer id) {
    Cliente model = clienteServicio.buscarPorId(id);
    if (model == null) throw new RecursoNoEncontradoExcepcion(
      "El id recibido no existe: " + id
    );

    model.setEstado(1);

    clienteServicio.guardar(model);
    return ResponseEntity.ok(model);
  }

  /**
   * Obtiene un cliente por id
   *
   * @param id // id del cliente
   *
   * @return cliente
   */
  @GetMapping("/clientes/{id}")
  public ResponseEntity<Cliente> getPorId(@PathVariable Integer id) {
    Cliente cliente = clienteServicio.buscarPorId(id);
    if (cliente == null) throw new RecursoNoEncontradoExcepcion(
      "No se encontro el id: " + id
    );
    return ResponseEntity.ok(cliente);
  }

  /**
   * Actualiza un cliente
   *
   * @param id            // id del cliente
   * @param modelRecibido // cliente a actualizar
   *
   * @return cliente actualizado
   */
  @PutMapping("/clientes/{id}")
  public ResponseEntity<Cliente> actualizar(
    @PathVariable Integer id,
    @RequestBody Cliente modelRecibido
  ) {
    Cliente model = clienteServicio.buscarPorId(id);
    if (model == null) throw new RecursoNoEncontradoExcepcion(
      "El id recibido no existe: " + id
    );

    clienteServicio.guardar(modelRecibido);
    return ResponseEntity.ok(modelRecibido);
  }
}
