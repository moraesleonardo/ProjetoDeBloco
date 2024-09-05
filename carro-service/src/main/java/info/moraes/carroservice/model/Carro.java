package info.moraes.carroservice.model;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
@Entity
public class Carro {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private BigDecimal preco;
    private String fabricante;
    @Column(name = "fabricante_id")
    private int fabricanteId;

}
