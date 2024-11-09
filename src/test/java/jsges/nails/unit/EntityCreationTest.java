package jsges.nails.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import jsges.nails.domain.articulos.Linea;
import jsges.nails.domain.organizacion.Cliente;
import jsges.nails.domain.servicios.ItemServicio;
import jsges.nails.domain.servicios.Servicio;
import jsges.nails.domain.servicios.TipoServicio;
import jsges.nails.dto.Organizacion.ClienteDTO;
import jsges.nails.dto.articulos.LineaDTO;
import jsges.nails.dto.servicios.ItemServicioDTO;

@SpringBootTest
public class EntityCreationTest {

    @Test
    public void testLineaDTO() {
        Linea linea = new Linea();
        linea.setId(1);
        linea.setDenominacion("Linea 1");

        LineaDTO lineaDTO = new LineaDTO(linea);

        assertEquals(linea.getId(), lineaDTO.getId());
        assertEquals(linea.getDenominacion(), lineaDTO.getDenominacion());
    }

    @Test
    public void testClienteDTO() {
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setRazonSocial("Cliente 1");

        ClienteDTO clienteDTO = new ClienteDTO(cliente);

        assertEquals(cliente.getId(), clienteDTO.getId());
        assertEquals(cliente.getRazonSocial(), clienteDTO.getRazonSocial());
    }

    @Test
    public void testItemServicioDTO() {
        Cliente cliente = new Cliente();
        cliente.setId(1);

        Servicio servicio = new Servicio();
        servicio.setId(1);
        servicio.setCliente(cliente);

        TipoServicio tipoServicio = new TipoServicio();
        tipoServicio.setId(1);

        ItemServicio itemServicio = new ItemServicio();
        itemServicio.setId(1);
        itemServicio.setObservacion("Item 1");
        itemServicio.setTipoServicio(tipoServicio);
        itemServicio.setServicio(servicio);
        itemServicio.setPrecio(100.0);

        ItemServicioDTO itemServicioDTO = new ItemServicioDTO(itemServicio);

        assertEquals(itemServicio.getId(), itemServicioDTO.getId());
        assertEquals(itemServicio.getObservacion(), itemServicioDTO.getObservaciones());
        assertEquals(itemServicio.getTipoServicio().getId(), itemServicioDTO.getTipoServicioId());
        assertEquals(itemServicio.getPrecio(), itemServicioDTO.getPrecio());
    }
}
