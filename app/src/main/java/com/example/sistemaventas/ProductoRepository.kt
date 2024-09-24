package com.example.sistemaventas.repository

import com.example.sistemaventas.model.Producto

object ProductoRepository {
    private val productos = mutableListOf<Producto>()

    fun obtenerProductos(): List<Producto> = productos

    fun agregarProducto(producto: Producto) {
        productos.add(producto)
    }

    fun eliminarProducto(producto: Producto) {
        productos.remove(producto)
    }

    fun actualizarProducto(producto: Producto) {
        val index = productos.indexOfFirst { it.id == producto.id }
        if (index != -1) {
            productos[index] = producto
        }
    }
}
