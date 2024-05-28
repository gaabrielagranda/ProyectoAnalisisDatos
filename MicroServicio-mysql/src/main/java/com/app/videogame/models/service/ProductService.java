package com.app.videogame.models.service;

import com.app.videogame.models.entity.Producto;
import com.app.videogame.models.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductoRepository productRepository;

    public Optional<Producto> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Producto> getAllProducts() {
        return productRepository.findAll();
    }
}
