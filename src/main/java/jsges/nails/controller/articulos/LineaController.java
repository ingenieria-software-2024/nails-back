package jsges.nails.controller.articulos;

import java.util.ArrayList;
import java.util.List;

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

import jsges.nails.domain.articulos.Linea;
import jsges.nails.dto.articulos.LineaDTO;
import jsges.nails.exception.RecursoNoEncontradoExcepcion;
import jsges.nails.services.articulos.ILineaService;

@RestController
@RequestMapping(value = "${path.mapping}")
@CrossOrigin(value = "${path.cors}")
public class LineaController {

  private static final Logger logger = LoggerFactory.getLogger(LineaController.class);

  @Autowired
  private ILineaService modelService;

  private List<LineaDTO> convertLineaToDto(List<Linea> list) {
    List<LineaDTO> listadoDTO = new ArrayList<>();

    for (Linea model : list) {
      listadoDTO.add(new LineaDTO(model));
    }

    return listadoDTO;
  }

  @GetMapping("/lineas")
  public List<LineaDTO> getAll() {
    List<LineaDTO> listadoDTO = convertLineaToDto(modelService.listar());

    return listadoDTO;
  }

  @GetMapping("/lineasPageQuery")
  public ResponseEntity<Page<LineaDTO>> getItems(
      @RequestParam(defaultValue = "") String consulta,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "${page.max}") int size) {
    List<LineaDTO> listadoDTO = convertLineaToDto(modelService.listar(consulta));

    // Crear una pagina con el listado correspondiente.
    Page<LineaDTO> bookPage = modelService.findPaginated(
        PageRequest.of(page, size),
        listadoDTO);

    // Retornar la pagina completa.
    return ResponseEntity.ok().body(bookPage);
  }

  @PostMapping("/lineas")
  public ResponseEntity<LineaDTO> agregar(@RequestBody LineaDTO model) {
    List<Linea> list = modelService.buscar(model.denominacion);

    if (!list.isEmpty())
      return ResponseEntity.status(HttpStatus.CONFLICT).build();

    Linea nuevaLinea = modelService.newModel(model);
    return ResponseEntity.ok(new LineaDTO(nuevaLinea));
  }

  @DeleteMapping("/lineas/{id}")
  public ResponseEntity<LineaDTO> eliminar(@PathVariable Integer id) {
    Linea model = modelService.buscarPorId(id);

    if (model == null)
      throw new RecursoNoEncontradoExcepcion(
          "La linea especificada no existe.");

    model.asEliminado();
    modelService.guardar(model);

    return ResponseEntity.ok(new LineaDTO(model));
  }

  @GetMapping("/lineas/{id}")
  public ResponseEntity<LineaDTO> getPorId(@PathVariable Integer id) {
    Linea linea = modelService.buscarPorId(id);

    if (linea == null)
      throw new RecursoNoEncontradoExcepcion(
          "La linea especificada no existe.");

    LineaDTO model = new LineaDTO(linea);
    return ResponseEntity.ok(model);
  }

  @PutMapping("/lineas/{id}")
  public ResponseEntity<LineaDTO> actualizar(
      @PathVariable Integer id,
      @RequestBody LineaDTO modelRecibido) {
    Linea model = modelService.buscarPorId(modelRecibido.id);

    if (model == null)
      throw new RecursoNoEncontradoExcepcion(
          "La linea especificada no existe.");

    model.setDenominacion(modelRecibido.denominacion);
    modelService.guardar(model);

    return ResponseEntity.ok(new LineaDTO(model));
  }
}
