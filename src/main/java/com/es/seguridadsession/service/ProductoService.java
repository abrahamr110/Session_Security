package com.es.seguridadsession.service;

import com.es.seguridadsession.dto.ProductoDTO;
import com.es.seguridadsession.model.Producto;
import com.es.seguridadsession.model.Usuario;
import com.es.seguridadsession.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    private Usuario usuario;

    public ProductoDTO mapToDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        //productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setStock(producto.getStock());
        productoDTO.setPrecio(producto.isPrecio());
        return productoDTO;
    }

    public ProductoDTO getById(Long id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        return mapToDTO(producto);
    }

    public ProductoDTO insert(ProductoDTO productoDTO) {
        if(usuario.getRol().equalsIgnoreCase("admin")){
            Producto producto = new Producto(productoDTO.getNombre(), productoDTO.getStock(), productoDTO.isPrecio());
            productoRepository.save(producto);
            return mapToDTO(producto);
        }
        return null;
    }
}
