package cl.mar.producto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.mar.producto.models.Producto;
import cl.mar.producto.services.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	//mostrar todos los productos
	@GetMapping("/mostrar")
	public String listarProductos(Model model){
		
		List<Producto> productos = productoService.mostrarTodos();
		
		model.addAttribute("productos", productos);
	    
		return "mostrar";
	}
	
	
	//agragar producto
	@GetMapping("/agregar")
	public String agregarProducto(Model model) {
		
	    model.addAttribute("producto", new Producto());
	    
	    return "agregar";
	}
	
	@PostMapping("/agregar")
	public String guardarProducto(@ModelAttribute Producto producto) {    		
	    
		productoService.crearActualizar(producto);
		
	    return "redirect:/productos/mostrar";
	}
	
	
	//editar un producto
	@GetMapping("/editar/{id}")
	public String mostrarEditar(@PathVariable Integer id, Model model) {
		
		Producto producto = productoService.buscarUnProducto(id);
		
		model.addAttribute("producto", producto );
		
	    return "editar";
	}
	
	@PostMapping("/editar/{id}")
	public String actualizarProducto(@ModelAttribute Producto producto) {		
	    
	    productoService.crearActualizar(producto);
	   
	    return "redirect:/productos/mostrar";
	}
	
	
	//eliminar un producto de la BBDD
	@GetMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable Integer id) {
	    
		productoService.eliminarProducto(id);

		return "redirect:/productos/mostrar";
	}
	
}
