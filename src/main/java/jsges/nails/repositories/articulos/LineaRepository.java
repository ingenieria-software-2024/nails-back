package jsges.nails.repositories.articulos;

import java.util.List;
import jsges.nails.domain.articulos.Linea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LineaRepository extends JpaRepository<Linea, Integer> {
  @Query("SELECT p FROM Linea p WHERE p.estado = 0 ORDER BY p.denominacion")
  List<Linea> buscarNoEliminados();

  @Query(
    "SELECT p FROM Linea p WHERE p.estado = 0 AND p.denominacion LIKE %:consulta% ORDER BY p.denominacion"
  )
  List<Linea> buscarNoEliminados(@Param("consulta") String consulta);

  @Query(
    "SELECT p FROM Linea p WHERE p.estado = 0 AND p.denominacion LIKE :consulta ORDER BY p.denominacion"
  )
  List<Linea> buscarExacto(@Param("consulta") String consulta);

  List<Linea> findByDenominacionContaining(String consulta);
}
