package info.moraes.pedidoservice.service;

import info.moraes.pedidoservice.model.Pedido;
import info.moraes.pedidoservice.service.feign.ImpostoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class ImpostoService {
    private final ImpostoClient impostoClient;
    public ImpostoResponsePayload getTotalImposto(Pedido pedido){
        return impostoClient.calcularImposto(pedido);
        //var serverUrl = "http://localhost:8084";
        //RestClient client = RestClient.create();
        //return client.post()
        //        .uri(serverUrl)
        //        .contentType(MediaType.APPLICATION_JSON)
        //        .body(pedido)
        //        .retrieve()
        //        .toEntity(ImpostoResponsePayload.class).getBody();
    }
}
