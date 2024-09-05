package info.moraes.pedidoservice.service.feign;

import info.moraes.pedidoservice.model.Pedido;
import info.moraes.pedidoservice.service.ImpostoResponsePayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("IMPOSTO-SERVICE")
public interface ImpostoClient {
    @PostMapping("/")
    ImpostoResponsePayload calcularImposto(@RequestBody Pedido pedido);
}
