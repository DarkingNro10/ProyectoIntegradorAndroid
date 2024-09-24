package com.example.sistemaventas.repository

import Producto


object ProductoRepositorio {
    private val productos = mutableListOf(
        Producto(id = 1, nombre = "Producto 1", precio = 10.0, cantidad = 5),
        Producto(id = 2, nombre = "Producto 2", precio = 20.0, cantidad = 3)
    )

    fun agregarProducto(producto: Producto) {
        productos.add(producto)
    }

    fun obtenerProductos(): List<Producto> {
        return productos
    }

    fun eliminarProducto(id: Int) {
        productos.removeAll { it.id == id }
    }
}
