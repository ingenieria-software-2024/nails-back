package jsges.nails.service.organizacion;

import java.util.List;
import jsges.nails.DTO.Organizacion.ClienteDTO;
import jsges.nails.domain.organizacion.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClienteService {
  public List<Cliente> listar();

  public Cliente buscarPorId(Integer id);

  public Cliente guardar(Cliente cliente);

  public void eliminar(Cliente cliente);

  public List<Cliente> listar(String consulta);

  public Page<Cliente> getClientes(Pageable pageable);

  public Page<ClienteDTO> findPaginated(Pageable pageable, List<ClienteDTO> clientes);
}
