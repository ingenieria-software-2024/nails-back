package jsges.nails.domain.servicios;

import jakarta.persistence.*;
import java.sql.Timestamp;
import jsges.nails.domain.organizacion.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@ToString
public class Servicio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private int estado;

  @ManyToOne(cascade = CascadeType.ALL)
  private Cliente cliente;

  private Timestamp fechaRegistro;
  private Timestamp fechaRealizacion;
  private double total;

  public Servicio() {}
}
