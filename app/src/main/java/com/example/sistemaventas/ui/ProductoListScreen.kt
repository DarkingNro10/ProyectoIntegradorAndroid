package com.example.sistemaventas.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sistemaventas.model.Producto
import com.example.sistemaventas.repository.ProductoRepository

@Composable
fun ProductoListScreen(navController: NavController) {
    val productos = remember { ProductoRepository.obtenerProductos() }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Lista de Productos", style = MaterialTheme.typography.headlineLarge)

        // Botón para navegar a la pantalla de agregar producto
        Button(
            onClick = { navController.navigate("agregar_producto") },
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text("Agregar Producto")
        }

        LazyColumn {
            items(productos) { producto ->
                ProductoItem(producto = producto)
            }
        }
    }
}

@Composable
fun ProductoItem(producto: Producto) {
    Row(modifier = Modifier.padding(8.dp)) {
        Text(text = producto.nombre)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "${producto.precio} USD")
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "${producto.cantidad} unidades")
    }
}
