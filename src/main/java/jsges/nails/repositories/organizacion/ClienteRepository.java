package jsges.nails.repositories.organizacion;

import java.util.List;
import jsges.nails.domain.organizacion.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
  @Query("SELECT p FROM Cliente p WHERE p.estado = 0 ORDER BY p.razonSocial")
  List<Cliente> buscarNoEliminados();

  @Query(
    "SELECT p FROM Cliente p WHERE p.estado = 0 AND p.razonSocial LIKE %:consulta% ORDER BY p.razonSocial"
  )
  List<Cliente> buscarNoEliminados(@Param("consulta") String consulta);
}
