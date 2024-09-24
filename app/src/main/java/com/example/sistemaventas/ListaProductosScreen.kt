package com.example.sistemaventas

import Producto
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ListaProductosScreen() {
    val productos = listOf(
        Producto(id = 1, nombre = "Producto A", precio = 15.99, cantidad = 3),
        Producto(id = 2, nombre = "Producto B", precio = 29.99, cantidad = 1),
        Producto(id = 3, nombre = "Producto C", precio = 9.99, cantidad = 10)
    )

    Column(modifier = Modifier.padding(16.dp)) {
        productos.forEach { producto ->
            ProductoCard(producto = producto)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


@Composable
fun <T : Producto> ProductoCard(producto: T) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = producto.nombre, style = MaterialTheme.typography.titleLarge)
            Text(text = "Precio: ${producto.precio}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Cantidad: ${producto.cantidad}", style = MaterialTheme.typography.bodyMedium)
            Row {
                Button(onClick = { /* Implement edit logic */ }) {
                    Text("Editar")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { /* Implement delete logic */ }, colors = ButtonDefaults.buttonColors(Color.Red)) {
                    Text("Eliminar")
                }
            }
        }
    }
}
