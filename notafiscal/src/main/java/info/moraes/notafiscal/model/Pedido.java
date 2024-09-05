package info.moraes.notafiscal.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Pedido {

    private String id;
    private List<ItemPedido> items;
    private BigDecimal totalImposto;
    private BigDecimal valorTotalSemImposto;
    private BigDecimal valorTotalComImposto;
}
