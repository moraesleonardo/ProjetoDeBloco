package info.moraes.impostoservice.service.feign;


import info.moraes.impostoservice.model.Carro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CARRO-SERVICE")
public interface CarroClient {
    @GetMapping("/{id}")
    Carro findById(@PathVariable Long id);
}
