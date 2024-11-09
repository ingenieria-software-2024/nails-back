package jsges.nails.service.articulos;

import java.util.List;
import jsges.nails.DTO.articulos.ArticuloVentaDTO;
import jsges.nails.domain.articulos.ArticuloVenta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IArticuloVentaService {
  public List<ArticuloVenta> listar();

  public ArticuloVenta buscarPorId(Integer id);

  public ArticuloVenta guardar(ArticuloVenta model);

  public void eliminar(ArticuloVenta model);

  public List<ArticuloVenta> listar(String consulta);

  public Page<ArticuloVenta> getArticulos(Pageable pageable);

  public Page<ArticuloVentaDTO> findPaginated(
    Pageable pageable,
    List<ArticuloVentaDTO> list
  );
}
