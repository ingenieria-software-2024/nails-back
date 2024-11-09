package jsges.nails.controller.articulos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jsges.nails.DTO.articulos.ArticuloVentaDTO;
import jsges.nails.controller.mapper.ArticuloVentaMapper;
import jsges.nails.domain.articulos.ArticuloVenta;
import jsges.nails.domain.articulos.Linea;
import jsges.nails.excepcion.RecursoNoEncontradoExcepcion;
import jsges.nails.service.articulos.IArticuloVentaService;
import jsges.nails.service.articulos.ILineaService;
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
public class ArticuloVentaController {

  private static final Logger logger = LoggerFactory.getLogger(
      ArticuloVentaController.class);

  @Autowired
  private IArticuloVentaService modelService;

  @Autowired
  private ILineaService lineaService;

  public ArticuloVentaController() {
  }

  private List<ArticuloVentaDTO> convertArticuloVentaToDto(List<ArticuloVenta> list) {
    List<ArticuloVentaDTO> listadoDTO = new ArrayList<>();

    for (ArticuloVenta model : list) {
      listadoDTO.add(ArticuloVentaMapper.toArticuloVentaDTO(model));
    }

    return listadoDTO;
  }

  @GetMapping({ "/articulos" })
  public List<ArticuloVentaDTO> getAll() {
    // Obtener la lista de articulos.
    List<ArticuloVenta> list = modelService.listar();

    return convertArticuloVentaToDto(list);
  }

  @GetMapping({ "/articulosPageQuery" })
  public ResponseEntity<Page<ArticuloVentaDTO>> getItems(
      @RequestParam(defaultValue = "") String consulta,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "${page.max}") int size) {
    // Obtener el listado.
    List<ArticuloVenta> listado = modelService.listar(consulta);

    // Convertir a DTO.
    List<ArticuloVentaDTO> listadoDTO = convertArticuloVentaToDto(listado);

    // Crear una pagina del listado en base a los parametros.
    Page<ArticuloVentaDTO> bookPage = modelService.findPaginated(
        PageRequest.of(page, size),
        listadoDTO);

    // Retornar la pagina.
    return ResponseEntity.ok().body(bookPage);
  }

  @PostMapping("/articulos")
  public ArticuloVenta agregar(@RequestBody ArticuloVentaDTO model) {
    logger.info("entra");

    // Obtener el ID de la linea.
    Integer idLinea = model.linea;

    // Crear un nuevo modelo.
    ArticuloVenta newModel = new ArticuloVenta();
    newModel.setDenominacion(model.denominacion);

    // Buscar la linea por ID primero.
    Linea linea = lineaService.buscarPorId(idLinea);

    if (!Optional.ofNullable(linea).isPresent())
      throw new RecursoNoEncontradoExcepcion("No se encontro la linea con el id: " + idLinea);

    // Establecer la linea del modelo.
    newModel.setLinea(lineaService.buscarPorId(idLinea));

    // Guardar la nueva linea.
    ArticuloVenta modelSave = modelService.guardar(newModel);
    return modelSave;
  }

  @DeleteMapping("/articuloEliminar/{id}")
  public ResponseEntity<ArticuloVenta> eliminar(@PathVariable Integer id) {
    ArticuloVenta model = modelService.buscarPorId(id);

    if (model == null)
      throw new RecursoNoEncontradoExcepcion("El id recibido no existe: " + id);

    model.asEliminado();
    modelService.guardar(model);
    return ResponseEntity.ok(model);
  }

  @GetMapping("/articulos/{id}")
  public ResponseEntity<ArticuloVentaDTO> getPorId(@PathVariable Integer id) {
    ArticuloVenta articuloVenta = modelService.buscarPorId(id);

    if (articuloVenta == null)
      throw new RecursoNoEncontradoExcepcion("No se encontro el id: " + id);

    ArticuloVentaDTO model = new ArticuloVentaDTO(articuloVenta);
    return ResponseEntity.ok(model);
  }

  @PutMapping("/articulos/{id}")
  public ResponseEntity<ArticuloVenta> actualizar(
      @PathVariable Integer id,
      @RequestBody ArticuloVentaDTO modelRecibido) {
    logger.info("articulo " + modelRecibido);

    ArticuloVenta model = modelService.buscarPorId(id);

    logger.info("articulo " + model);

    if (model == null)
      throw new RecursoNoEncontradoExcepcion("El id recibido no existe: " + id);

    logger.info("articulo " + model);

    model.setDenominacion(modelRecibido.denominacion);
    model.setLinea(lineaService.buscarPorId(modelRecibido.linea));

    modelService.guardar(model);

    return ResponseEntity.ok(model);
  }
}
