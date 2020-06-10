package com.dred.spring.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dred.spring.rest.modelo.Producto;
import com.dred.spring.rest.modelo.dao.ProductoDAO;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDAO productoDAO;
	
	@Override
	public List<Producto> getProductos() {
		List<Producto> listaProductos = productoDAO.getListaProductos();
		return listaProductos;
	}

	@Override
	public Producto getProducto(int id) {
		Producto p = productoDAO.getProducto(id);
		return p;
	}

	@Override
	public void guardarProducto(Producto producto) {
		productoDAO.insertarProducto(producto);
	}

	@Override
	public void borraProducto(int id) {
		productoDAO.eliminarProducto(id);
	}

}
