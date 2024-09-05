package info.moraes.notafiscalworker.rabbit;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.moraes.notafiscalworker.model.Pedido;
import info.moraes.notafiscalworker.service.NotaFiscalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Slf4j
@Component
public class NotaFiscalConsumer {

    private final ObjectMapper objectMapper;
    private final NotaFiscalService notaFiscalService;
    @RabbitListener(queues = {"nota-fiscal-queue"})
    public void receive(@Payload String json){
        try {
            Pedido pedido = objectMapper.readValue(json, Pedido.class);
            log.info("Nota fiscal received: {}", pedido);
            notaFiscalService.processar(pedido);

        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
