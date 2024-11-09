package jsges.nails.controller.mapper;

import jsges.nails.domain.organizacion.Cliente;
import jsges.nails.dto.Organizacion.ClienteDTO;

public class ClienteMapper {

    public ClienteMapper() {
        super();
    }

    public static ClienteDTO toClienteDTO(Cliente cliente) {
        return new ClienteDTO(cliente);
    }

    public static Cliente toCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setRazonSocial(clienteDTO.getRazonSocial());
        cliente.setLetra(clienteDTO.getLetra());
        cliente.setContacto(clienteDTO.getContacto());
        cliente.setCelular(clienteDTO.getCelular());
        cliente.setMail(clienteDTO.getMail());
        cliente.setFechaInicio(clienteDTO.getFechaInicio());
        cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
        return cliente;
    }
}
