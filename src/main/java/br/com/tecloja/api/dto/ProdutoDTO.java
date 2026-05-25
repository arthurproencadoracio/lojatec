package br.com.tecloja.api.dto;

import java.math.BigDecimal;

public record ProdutoDTO(
    Long id,
    String nome,
    String descricao,
    BigDecimal preco,
    int estoque,
    Long categoriaId,
    String categoriaNome
) {}
