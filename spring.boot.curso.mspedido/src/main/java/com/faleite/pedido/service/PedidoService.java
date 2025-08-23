package com.faleite.pedido.service;

import com.faleite.pedido.model.ItemPedido;
import com.faleite.pedido.model.Pedido;
import com.faleite.pedido.repository.PediddoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PediddoRepository pediddoRepository;

    public PedidoService(PediddoRepository pediddoRepository) {
        this.pediddoRepository = pediddoRepository;
    }

    public Pedido savePedido(Pedido pedido){

        if (pedido.getItens() != null){
            for (ItemPedido item : pedido.getItens()){
                item.setPedido(pedido);
            }

        }
        return pediddoRepository.save(pedido);
    }

    public List<Pedido> listPedidos(){
        return pediddoRepository.findAll();
    }
}
