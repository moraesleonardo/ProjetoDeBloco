package info.moraes.pedidoservice.service.feign;

import info.moraes.pedidoservice.model.Carro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;



@FeignClient("CARRO-SERVICE")
public interface CarroClient {
    @GetMapping("/{id}")
    Carro getById(@PathVariable("id") Long id);
}
