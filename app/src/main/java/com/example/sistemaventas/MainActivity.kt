package com.example.sistemaventas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sistemaventas.ui.AgregarProductoScreen
import com.example.sistemaventas.ui.ProductoListScreen
import com.example.sistemaventas.repository.ProductoRepository
import com.example.sistemaventas.ui.theme.SistemaVentasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SistemaVentasTheme {
                val navController = rememberNavController()  // Asegúrate de que esto esté presente
                SistemaVentasApp(navController = navController)
            }
        }
    }
}

@Composable
fun SistemaVentasApp(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Sistema de Ventas") })
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,  // Asegúrate de que navController se pase aquí correctamente
            startDestination = "lista_productos",
            modifier = Modifier.padding(innerPadding)  // Asegúrate de tener la importación de Modifier
        ) {
            composable("lista_productos") {
                ProductoListScreen(navController = navController)
            }
            composable("agregar_producto") {
                AgregarProductoScreen { producto ->
                    ProductoRepository.agregarProducto(producto)
                    navController.popBackStack()  // Vuelve a la pantalla anterior después de agregar un producto
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SistemaVentasAppPreview() {
    val navController = rememberNavController()
    SistemaVentasApp(navController = navController)
}
