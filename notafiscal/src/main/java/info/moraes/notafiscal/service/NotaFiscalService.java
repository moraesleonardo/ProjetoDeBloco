package info.moraes.notafiscal.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import info.moraes.notafiscal.model.Pedido;
import info.moraes.notafiscal.rabbitmq.NotaFiscalProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotaFiscalService {
    private final NotaFiscalProducer producer;
    public void emitirNotaFiscal(Pedido pedido) throws JsonProcessingException {
        producer.send(pedido);
    }
}
