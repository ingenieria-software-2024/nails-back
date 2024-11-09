package jsges.nails.controller.services;

import java.util.ArrayList;
import java.util.List;
import jsges.nails.domain.servicios.ItemServicio;
import jsges.nails.domain.servicios.Servicio;
import jsges.nails.domain.servicios.TipoServicio;
import jsges.nails.dto.servicios.ItemServicioDTO;
import jsges.nails.dto.servicios.ServicioDTO;
import jsges.nails.exception.RecursoNoEncontradoExcepcion;
import jsges.nails.services.organizacion.IClienteService;
import jsges.nails.services.servicios.interfaces.IItemServicioService;
import jsges.nails.services.servicios.interfaces.IServicioService;
import jsges.nails.services.servicios.interfaces.ITipoServicioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${path.mapping}")
@CrossOrigin(value = "${path.cors}")
public class ServicioController {

  private static final Logger logger = LoggerFactory.getLogger(ServicioController.class);

  @Autowired
  private IServicioService modelService;

  @Autowired
  private IClienteService clienteService;

  @Autowired
  private ITipoServicioService tipoServicioService;

  @Autowired
  private IItemServicioService itemServicioService;

  private List<ServicioDTO> convertServicioToDto(List<Servicio> list) {
    List<ServicioDTO> listadoDTO = new ArrayList<>();

    for (Servicio model : list) {
      listadoDTO.add(new ServicioDTO(model));
    }

    return listadoDTO;
  }

  @GetMapping("/servicios")
  public List<ServicioDTO> getAll() {
    List<Servicio> servicios = this.modelService.listar();
    List<ServicioDTO> lista = convertServicioToDto(servicios);

    return lista;
  }

  @GetMapping("/servicios/{id}")
  public ResponseEntity<ServicioDTO> getPorId(@PathVariable Integer id) {
    Servicio model = modelService.buscarPorId(id);

    if (model == null)
      throw new RecursoNoEncontradoExcepcion(
          "No se encontro el servicio especificado");

    List<ItemServicio> listItems = itemServicioService.buscarPorServicio(model.getId());
    ServicioDTO modelDTO = new ServicioDTO(model, listItems);

    return ResponseEntity.ok(modelDTO);
  }

  @GetMapping("/serviciosPageQuery")
  public ResponseEntity<Page<ServicioDTO>> getItems(
      @RequestParam(defaultValue = "") String consulta,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "${page.max}") int size) {
    List<Servicio> listado = modelService.listar(consulta);
    List<ServicioDTO> listadoDTO = convertServicioToDto(listado);

    // Crear una pagina con el listado correspondiente.
    Page<ServicioDTO> bookPage = modelService.findPaginated(
        PageRequest.of(page, size),
        listadoDTO);

    // Retornar la pagina completa.
    return ResponseEntity.ok().body(bookPage);
  }

  @PostMapping("/servicios")
  public ServicioDTO agregar(@RequestBody ServicioDTO model) {
    // Obtener el ID del cliente.
    Integer idCliente = model.getCliente();

    // Crear un nuevo modelo.
    Servicio newModel = new Servicio();
    newModel.setCliente(clienteService.buscarPorId(idCliente));
    newModel.setFechaRegistro(model.getFechaDocumento());
    newModel.setFechaRealizacion(model.getFechaDocumento());
    newModel.setEstado(0);

    // Guardar el nuevo modelo.
    Servicio servicioGuardado = modelService.guardar(newModel);
    for (ItemServicioDTO elemento : model.getListaItems()) {
      double precio = elemento.getPrecio();

      TipoServicio tipoServicio = tipoServicioService.buscarPorId(
          elemento.getTipoServicioId());
      String observacion = elemento.getObservaciones();
      ItemServicio item = new ItemServicio(newModel, tipoServicio, precio, observacion);

      itemServicioService.guardar(item);
    }

    return new ServicioDTO(servicioGuardado);
  }
}
