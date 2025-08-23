package com.faleite.pedido.controller;

import com.faleite.pedido.model.Pedido;
import com.faleite.pedido.service.PedidoService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final RabbitTemplate rabbitTemplate;
    private final PedidoService pedidoService;

    public PedidoController(RabbitTemplate rabbitTemplate, PedidoService pedidoService) {
        this.rabbitTemplate = rabbitTemplate;
        this.pedidoService = pedidoService;
    }

    @Value("${broker.queue.processamento.name}")
    private String rountingKey;

    @PostMapping
    public String saveNewPedido(@RequestBody Pedido pedido){
        Pedido pedidoSalvo = pedidoService.savePedido(pedido);
        rabbitTemplate.convertAndSend("", rountingKey, pedidoSalvo);
        return "Pedido salvo e enviado para processamento " + pedido.getDescricao();
    }

    @GetMapping
    public List<Pedido> listPedidos(){
        return pedidoService.listPedidos();
    }
}
