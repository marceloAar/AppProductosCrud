package cl.mar.producto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.mar.producto.models.Producto;
import cl.mar.producto.repositories.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	//mostrar todos los productos
	public List<Producto> mostrarTodos(){
		
		return (List<Producto>) productoRepository.findAll();
	}
	
	
	//buscar un producto
	public Producto buscarUnProducto(Integer id) {
		
		return productoRepository.findById(id).orElse(null);
	}
	
	
	//crear nuevo producto o actualizar producto existente
	public void crearActualizar(Producto producto) {
		
		productoRepository.save(producto);	
	}
	
	
	//eliminar un producto de la BBDD por su id
	public void eliminarProducto(Integer id) {
		
		productoRepository.deleteById(id);		
	}
	
		
}
