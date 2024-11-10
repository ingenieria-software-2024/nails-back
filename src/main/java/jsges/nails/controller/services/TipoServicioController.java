package jsges.nails.controller.services;

import java.util.List;
import jsges.nails.domain.servicios.TipoServicio;
import jsges.nails.dto.servicios.TipoServicioDTO;
import jsges.nails.exception.RecursoNoEncontradoExcepcion;
import jsges.nails.services.servicios.interfaces.ITipoServicioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
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
public class TipoServicioController {

  private static final Logger logger = LoggerFactory.getLogger(
    TipoServicioController.class
  );

  @Autowired
  private ITipoServicioService modelService;

  @GetMapping("/tiposervicios")
  public List<TipoServicio> getAll() {
    List<TipoServicio> tipoServicios = this.modelService.listar();
    return tipoServicios;
  }

  @GetMapping("/tiposerviciosPageQuery")
  public ResponseEntity<Page<TipoServicio>> getItems(
    @RequestParam(defaultValue = "") String consulta,
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "${page.max}") int size
  ) {
    List<TipoServicio> listado = modelService.listar(consulta);
    Page<TipoServicio> bookPage = modelService.findPaginated(
      PageRequest.of(page, size),
      listado
    );
    return ResponseEntity.ok().body(bookPage);
  }

  @PostMapping("/tiposervicios")
  public ResponseEntity<TipoServicio> agregar(@RequestBody TipoServicioDTO model) {
    List<TipoServicio> list = modelService.buscar(model.getDenominacion());
    if (!list.isEmpty()) {
      return ResponseEntity.status(HttpStatus.CONFLICT).build();
      // throw new RecursoNoEncontradoExcepcion("Ya existe una linea con la
      // denominacion: " + model.denominacion);
    }

    TipoServicio nuevoModelo = modelService.newModel(model);
    return ResponseEntity.ok(nuevoModelo);
  }

  @DeleteMapping("/tiposervicios/{id}")
  public ResponseEntity<TipoServicio> eliminar(@PathVariable Integer id) {
    TipoServicio model = modelService.buscarPorId(id);
    if (model == null) throw new RecursoNoEncontradoExcepcion(
      "El id recibido no existe: " + id
    );

    model.setEstado(1);

    modelService.guardar(model);
    return ResponseEntity.ok(model);
  }

  @GetMapping("/tiposervicios/{id}")
  public ResponseEntity<TipoServicio> getPorId(@PathVariable Integer id) {
    TipoServicio cliente = modelService.buscarPorId(id);
    if (cliente == null) throw new RecursoNoEncontradoExcepcion(
      "No se encontro el id: " + id
    );
    return ResponseEntity.ok(cliente);
  }

  @PutMapping("/tiposervicios/{id}")
  public ResponseEntity<TipoServicio> actualizar(
    @PathVariable Integer id,
    @RequestBody TipoServicio modelRecibido
  ) {
    TipoServicio model = modelService.buscarPorId(id);
    if (model == null) throw new RecursoNoEncontradoExcepcion(
      "El id recibido no existe: " + id
    );

    modelService.guardar(modelRecibido);
    return ResponseEntity.ok(modelRecibido);
  }
}
