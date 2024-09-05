package info.moraes.notafiscalworker.service;


import info.moraes.notafiscalworker.model.Pedido;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class NotaFiscalService {
    public void processar(Pedido pedido) {
        int i = new Random().nextInt(1000);
        log.info("Random: " + i);
        if (i > 60) {
            try {
                Thread.sleep(10_000);
                log.info("Gerando nota fiscal do pedido: " + pedido);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}