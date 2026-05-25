package br.com.tecloja.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record PedidoDTO(
    Long id,
    LocalDateTime dataPedido,
    String status,
    Long clienteId,
    String clienteNome,
    List<ItemPedidoDTO> itens,
    BigDecimal valorTotal
) {}
