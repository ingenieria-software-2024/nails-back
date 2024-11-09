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
import jsges.nails.domain.organizacion.ArticuloVenta;
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

  @Column(columnDefinition = "TEXT")
  String razonSocial;

  int estado;

  @Column(columnDefinition = "TEXT")
  String letra;

  @Column(columnDefinition = "TEXT")
  String contacto;

  @Column(columnDefinition = "TEXT")
  String celular;

  @Column(columnDefinition = "TEXT")
  String mail;

  @OneToMany(mappedBy = "cliente")
  private List<ArticuloVenta> articulosVenta;

  @OneToMany(mappedBy = "cliente")
  private List<Servicio> servicios;

  Date fechaInicio;
  Date fechaNacimiento;
}
