package com.es.seguridadsession.controller;

import com.es.seguridadsession.dto.ProductoDTO;
import com.es.seguridadsession.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getById(
            @PathVariable String id
    ) {
        Long idProducto = Long.parseLong(id);
        return ResponseEntity.ok(productoService.getById(idProducto));
    }

    @PostMapping("/")
    public ResponseEntity<ProductoDTO> insert(
            @RequestBody ProductoDTO productoDTO
    ) {
        return ResponseEntity.ok(productoService.insert(productoDTO));
    }
}
