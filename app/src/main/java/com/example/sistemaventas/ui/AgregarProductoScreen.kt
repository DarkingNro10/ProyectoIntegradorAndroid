package com.example.sistemaventas.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.sistemaventas.model.Producto

@Composable
fun AgregarProductoScreen(onGuardar: (Producto) -> Unit) {
    var nombre by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var cantidad by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre del Producto") }
        )
        TextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio") },
            keyboardType = KeyboardType.Number
        )
        TextField(
            value = cantidad,
            onValueChange = { cantidad = it },
            label = { Text("Cantidad") },
            keyboardType = KeyboardType.Number
        )

        Button(onClick = {
            val producto = Producto(
                id = 0,  // Genera un ID adecuado para tu producto
                nombre = nombre,
                precio = precio.toDouble(),
                cantidad = cantidad.toInt()
            )
            onGuardar(producto)
        }) {
            Text("Guardar Producto")
        }
    }
}
