package jsges.nails.dto.Organizacion;

import java.util.Date;
import jsges.nails.domain.organizacion.Cliente;
import lombok.Data;

@Data
public class ClienteDTO {

  private Integer id;
  private String razonSocial;
  private String letra;
  private String contacto;
  private String celular;
  private String mail;
  private Date fechaInicio;
  private Date fechaNacimiento;

  public ClienteDTO(Cliente model) {
    this.id = model.getId();
    this.razonSocial = model.getRazonSocial();
    this.celular = model.getCelular();
    this.mail = model.getMail();
  }

  public ClienteDTO() {}
}
