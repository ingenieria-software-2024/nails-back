package jsges.nails.repository.servicios;

import java.util.List;
import jsges.nails.domain.servicios.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
  @Query("SELECT p FROM Servicio p WHERE p.estado = 0")
  List<Servicio> buscarNoEliminados();

  @Query("SELECT p FROM Servicio p WHERE p.estado = 0")
  List<Servicio> buscarExacto();

  @Query("SELECT p FROM Servicio p WHERE p.estado = 0")
  List<Servicio> buscarNoEliminados(@Param("consulta") String consulta);
}
