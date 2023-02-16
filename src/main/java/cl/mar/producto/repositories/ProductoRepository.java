package cl.mar.producto.repositories;

import org.springframework.data.repository.CrudRepository;

import cl.mar.producto.models.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer>{ }