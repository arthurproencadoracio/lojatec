package br.com.tecloja.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class RootController {

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> root() {
        return ResponseEntity.ok(Map.of(
            "status", "online",
            "message", "API da Tecloja",
            "timestamp", LocalDateTime.now().toString(),
            "endpoints", Map.of(
                "login", "POST /api/v1/auth/login",
                "produtos", "GET /api/v1/produtos",
                "categorias", "GET /api/v1/categorias",
                "pedidos", "GET /api/v1/pedidos/cliente/{id}",
                "h2-console", "/h2-console"
            )
        ));
    }
}
