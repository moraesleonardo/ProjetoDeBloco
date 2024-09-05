package info.moraes.impostoservice.service;

import info.moraes.impostoservice.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImpostoService {
    private final CarroService carroService;
    private final FabricanteService fabricanteService;

    public BigDecimal calcularImpostoTotal(PedidoPayload payload) {
        // Verifica se a lista de itens é nula ou vazia e retorna 0 como imposto total nesses casos
        List<ItemPedido> items = payload.items() != null ? payload.items() : Collections.emptyList();

        return items.stream()
                .map(this::calcularImposto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calcularImposto(ItemPedido itemPedido) {
        Carro carro = carroService.getById(itemPedido.getCarroId());
        Fabricante fabricante = fabricanteService.getById((long) carro.getFabricanteId());
        BigDecimal taxa = getTaxas(fabricante.getPais());
        var impostoDoItem = carro.getPreco().multiply(taxa).multiply(new BigDecimal(itemPedido.getQuantidade()));
        return impostoDoItem;
    }

    private BigDecimal getTaxas(Pais pais) {
        return switch (pais) {
            case USA -> new BigDecimal("0.45");
            case BRASIL -> new BigDecimal("0.05");
            case EUROPA -> new BigDecimal("0.31");
        };
    }
}
