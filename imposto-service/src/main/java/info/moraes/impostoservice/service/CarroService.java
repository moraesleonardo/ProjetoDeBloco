package info.moraes.impostoservice.service;

import info.moraes.impostoservice.model.Carro;
import info.moraes.impostoservice.service.feign.CarroClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class CarroService {
    private final CarroClient client;
    public Carro getById(Long id){
        return client.findById(id);
        /*
        Interface antiga (Spring < 6.0)
         */
        //RestTemplate restTemplate = new RestTemplate();
        //RestClient restClient = RestClient.create();
        //var serverUrl = String.format("http://localhost:8081/%d", id);
        //Carro carro = restClient.get()
        //        .uri(serverUrl)
        //        .retrieve()
        //        .toEntity(Carro.class).getBody();
        //return carro;
    }

}
