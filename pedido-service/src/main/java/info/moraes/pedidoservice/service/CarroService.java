package info.moraes.pedidoservice.service;

import info.moraes.pedidoservice.model.Carro;
import info.moraes.pedidoservice.service.feign.CarroClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class CarroService {
    private final CarroClient carroClient;
    public Carro getById(Long id){
        return carroClient.getById(id);
        //RestClient restClient = RestClient.create();
        //var serverUrl = String.format("http://localhost:8081/%d", id);
        //return restClient.get().uri(serverUrl).retrieve().toEntity(Carro.class).getBody();
    }

}
// Client Side Load Balancer <> Server Side LoadBalancer