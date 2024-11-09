package jsges.nails.repositories.articulos;

import java.util.List;
import jsges.nails.domain.articulos.ArticuloVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticuloVentaRepository extends JpaRepository<ArticuloVenta, Integer> {
  @Query("SELECT p FROM ArticuloVenta p WHERE p.estado = 0 ORDER BY p.denominacion")
  List<ArticuloVenta> buscarNoEliminados();

  @Query(
    "SELECT p FROM ArticuloVenta p WHERE p.estado = 0 AND p.denominacion LIKE %:consulta% ORDER BY p.denominacion"
  )
  List<ArticuloVenta> buscarNoEliminados(@Param("consulta") String consulta);
}
