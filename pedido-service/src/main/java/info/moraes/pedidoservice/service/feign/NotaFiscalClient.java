package info.moraes.pedidoservice.service.feign;


import info.moraes.pedidoservice.model.NotaFiscalPayload;
import info.moraes.pedidoservice.model.Pedido;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("NOTAFISCAL-SERVICE")
public interface NotaFiscalClient {
    @PostMapping("/")
    NotaFiscalPayload emitirNotaFiscal(@RequestBody Pedido pedido);

}
