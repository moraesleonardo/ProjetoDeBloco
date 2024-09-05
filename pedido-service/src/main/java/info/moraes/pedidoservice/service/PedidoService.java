package info.moraes.pedidoservice.service;

import info.moraes.pedidoservice.model.Carro;
import info.moraes.pedidoservice.model.ItemPedido;
import info.moraes.pedidoservice.model.Pedido;
import info.moraes.pedidoservice.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final CarroService carroService;
    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    public BigDecimal calcularValorTotal(Pedido pedido) {
        return pedido.getItems().stream().map(this::calcularValorDeItem)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    private BigDecimal calcularValorDeItem(ItemPedido itemPedido) {
        Carro carro = carroService.getById(itemPedido.getCarroId());
        return carro.getPreco().multiply(BigDecimal.valueOf(itemPedido.getQuantidade()));
    }
}
