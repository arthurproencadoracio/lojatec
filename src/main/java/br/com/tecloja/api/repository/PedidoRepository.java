package br.com.tecloja.api.repository;

import br.com.tecloja.api.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT DISTINCT p FROM Pedido p JOIN FETCH p.cliente JOIN FETCH p.itens ip JOIN FETCH ip.produto WHERE p.cliente.id = :clienteId")
    List<Pedido> findPedidosCompletosPorCliente(@Param("clienteId") Long clienteId);
}
