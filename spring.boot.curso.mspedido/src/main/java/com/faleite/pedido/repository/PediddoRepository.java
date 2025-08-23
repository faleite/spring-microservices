package com.faleite.pedido.repository;

import com.faleite.pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PediddoRepository extends JpaRepository<Pedido, Long> {
}
