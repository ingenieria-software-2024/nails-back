package jsges.nails.domain.organizacion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jsges.nails.domain.articulos.ArticuloVenta;
import jsges.nails.domain.servicios.Servicio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cliente implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  String razonSocial;

  int estado;

  String letra;

  String contacto;

  String celular;

  String mail;

  @OneToMany(mappedBy = "cliente")
  private List<ArticuloVenta> articulosVenta;

  @OneToMany(mappedBy = "cliente")
  private List<Servicio> servicios;

  Date fechaInicio;
  Date fechaNacimiento;
}
