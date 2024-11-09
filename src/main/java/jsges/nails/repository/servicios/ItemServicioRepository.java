package jsges.nails.repository.servicios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jsges.nails.domain.servicios.ItemServicio;

public interface ItemServicioRepository extends JpaRepository<ItemServicio, Integer> {
  @Query("SELECT p FROM ItemServicio p WHERE p.estado = 0")
  List<ItemServicio> buscarNoEliminados();

  @Query("SELECT p FROM ItemServicio p WHERE p.estado = 0")
  List<ItemServicio> buscarExacto();

  @Query("SELECT p FROM ItemServicio p WHERE p.estado = 0 AND p.servicio.id = :idServicio")
  List<ItemServicio> buscarPorServicio(@Param("idServicio") Integer idServicio);
}
