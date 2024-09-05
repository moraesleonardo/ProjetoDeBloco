package info.moraes.pedidoservice.controller;

import info.moraes.pedidoservice.model.Pedido;
import info.moraes.pedidoservice.service.ImpostoService;
import info.moraes.pedidoservice.service.NotaFiscalService;
import info.moraes.pedidoservice.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;
    private final ImpostoService impostoService;
    private final NotaFiscalService notaFiscalService;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Pedido pedido){
        log.info("Creating Pedido");
        log.info("Pedido: {}", pedido);
        BigDecimal totalImposto = impostoService.getTotalImposto(pedido).totalImposto();
        BigDecimal valorTotalSemImposto = pedidoService.calcularValorTotal(pedido);
        pedido.setTotalImposto(totalImposto);
        pedido.setValorTotalSemImposto(valorTotalSemImposto);
        pedido.setValorTotalComImposto(valorTotalSemImposto.add(totalImposto));
        Pedido saved = pedidoService.salvar(pedido);
        notaFiscalService.emitirNotaFiscal(saved);
        return ResponseEntity.ok(saved);
    }

}
