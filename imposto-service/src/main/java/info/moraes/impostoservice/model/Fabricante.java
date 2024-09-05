package info.moraes.impostoservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fabricante {
    private long id;
    private String nome;
    private Pais pais;
}
