package info.moraes.pedidoservice.service;


import info.moraes.pedidoservice.model.NotaFiscalPayload;
import info.moraes.pedidoservice.model.Pedido;
import info.moraes.pedidoservice.service.feign.NotaFiscalClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotaFiscalService {
    private final NotaFiscalClient client;
    public NotaFiscalPayload emitirNotaFiscal(Pedido pedido){
        return client.emitirNotaFiscal(pedido);
    }
}
