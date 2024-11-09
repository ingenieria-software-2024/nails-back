package jsges.nails.repository.articulos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jsges.nails.domain.articulos.ArticuloVenta;

public interface ArticuloVentaRepository extends JpaRepository<ArticuloVenta, Integer> {
  @Query("select p from ArticuloVenta p  where p.estado=0 order by p.denominacion")
  List<ArticuloVenta> buscarNoEliminados();

  @Query(
    "SELECT p FROM ArticuloVenta p WHERE p.estado = 0 AND  p.denominacion LIKE %:consulta% ORDER BY p.denominacion"
  )
  List<ArticuloVenta> buscarNoEliminados(@Param("consulta") String consulta);
}
