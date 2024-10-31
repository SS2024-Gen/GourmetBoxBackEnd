package com.GourmetBoxBackEnd.gourmetBoxBackEnd.service;

import com.GourmetBoxBackEnd.gourmetBoxBackEnd.model.Producto;
import com.GourmetBoxBackEnd.gourmetBoxBackEnd.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public List<Producto> getProductos() {
        List<Producto> listaProductos = productoRepository.findAll();
        return listaProductos;
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public Producto findProductoById(Integer id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        return producto;
    }

    @Override
    public void deleteProducto(Integer id) {
        productoRepository.deleteById(id);
    }

    @Override
    public void editProducto(Integer idOriginal, String nuevoNombreProducto,
                             String nuevoDescripcionProducto, String nuevoCategoria,
                             String nuevoImgProducto, Double nuevoPrecioProducto) {

            Producto producto=this.findProductoById(idOriginal);
            producto.setNombreProducto(nuevoNombreProducto);
            producto.setDescripcionProducto(nuevoDescripcionProducto);
            producto.setCategoria(nuevoCategoria);
            producto.setImgProducto(nuevoImgProducto);
            producto.setPrecioProducto(nuevoPrecioProducto);
    }
}
