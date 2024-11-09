package jsges.nails.service.servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jsges.nails.domain.servicios.ItemServicio;

public interface IItemServicioService {
  public List<ItemServicio> listar();

  public ItemServicio buscarPorId(Integer id);

  public ItemServicio guardar(ItemServicio model);

  public Page<ItemServicio> findPaginated(
    Pageable pageable,
    List<ItemServicio> servicios
  );

  public Page<ItemServicio> getItemServicios(Pageable pageable);

  public List<ItemServicio> buscarPorServicio(Integer idServicio);
}
