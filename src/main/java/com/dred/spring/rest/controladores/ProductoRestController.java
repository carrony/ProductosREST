package com.dred.spring.rest.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dred.spring.rest.modelo.Producto;
import com.dred.spring.rest.services.ProductoService;

@RestController
@RequestMapping("/api")
public class ProductoRestController {

	@Autowired
	ProductoService productoService;
	
	@GetMapping("/productos")
	public List<Producto> getProductos (){
		return productoService.getProductos();
	}
	
	@GetMapping("/producto/{id}")
	public Producto getProducto (@PathVariable int id){
		Producto producto = productoService.getProducto(id);
		if (producto==null) {
			throw new RuntimeException("Producto no encontrado: "+id);
		}
		return producto;
	}
	
	@PostMapping("/productos")
	public Producto addProducto(@RequestBody Producto producto) {
		producto.setId(0);
		productoService.guardarProducto(producto);
		return producto;		
	}
	
	@DeleteMapping("/producto/{id}")
	public String eliminarProducto (@PathVariable int id){
		Producto producto = productoService.getProducto(id);
		if (producto==null) {
			throw new RuntimeException("Producto no encontrado: "+id);
		}
		productoService.borraProducto(id);
		return " Borrado producto id="+id;
	}
}
