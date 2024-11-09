package jsges.nails.services.articulos;

import java.util.Collections;
import java.util.List;
import jsges.nails.domain.articulos.ArticuloVenta;
import jsges.nails.dto.articulos.ArticuloVentaDTO;
import jsges.nails.repositories.articulos.ArticuloVentaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticuloVentaService implements IArticuloVentaService {

  @Autowired
  private ArticuloVentaRepository modelRepository;

  private static final Logger logger = LoggerFactory.getLogger(
    ArticuloVentaService.class
  );

  @Override
  public List<ArticuloVenta> listar() {
    return modelRepository.buscarNoEliminados();
  }

  @Override
  public ArticuloVenta buscarPorId(Integer id) {
    return modelRepository.findById(id).orElse(null);
  }

  @Override
  public ArticuloVenta guardar(ArticuloVenta model) {
    return modelRepository.save(model);
  }

  @Override
  public void eliminar(ArticuloVenta model) {
    modelRepository.save(model);
  }

  @Override
  public List<ArticuloVenta> listar(String consulta) {
    // logger.info("service " +consulta);
    return modelRepository.buscarNoEliminados(consulta);
  }

  @Override
  public Page<ArticuloVenta> getArticulos(Pageable pageable) {
    return modelRepository.findAll(pageable);
  }

  @Override
  public Page<ArticuloVentaDTO> findPaginated(
    Pageable pageable,
    List<ArticuloVentaDTO> listado
  ) {
    int pageSize = pageable.getPageSize();
    int currentPage = pageable.getPageNumber();
    int startItem = currentPage * pageSize;
    List<ArticuloVentaDTO> list;
    if (listado.size() < startItem) {
      list = Collections.emptyList();
    } else {
      int toIndex = Math.min(startItem + pageSize, listado.size());
      list = listado.subList(startItem, toIndex);
    }

    Page<ArticuloVentaDTO> bookPage = new PageImpl<ArticuloVentaDTO>(
      list,
      PageRequest.of(currentPage, pageSize),
      listado.size()
    );

    return bookPage;
  }
}
