package com.dred.spring.rest.services;

import java.util.List;

import com.dred.spring.rest.modelo.Producto;

public interface ProductoService {

	public List<Producto> getProductos();
	public Producto getProducto(int id);
	public void guardarProducto(Producto producto);
	public void borraProducto(int id);
}
