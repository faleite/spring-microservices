package com.faleite.processamento.consumer;

import com.faleite.processamento.dto.PedidoDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProcessamentoConsumer {

    @RabbitListener(queues = "${broker.queue.processamento.name}")
    public void ListenerProcessamentoQueue(PedidoDto pedidoDto){
        System.out.println(pedidoDto.getDescricao());
    }
}
