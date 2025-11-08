package com.example.juani

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.juani.ui.theme.JuaniTheme

@Composable
fun CitasAdminScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(15.dp))

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text("JUANI", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            JuaniTabItem("Inicio", false)
            JuaniTabItem("Citas", true)
            JuaniTabItem("Clientes", false)
            JuaniTabItem("Servicios", false)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text("Citas Programadas", fontSize = 18.sp, fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Clientes", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text("Servicio", fontWeight = FontWeight.Bold, fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            CitaFila("Selina Salvador", "Belleza Natural", Color.Red)
            CitaFila("Daniel Sánchez", "Relajación Total", Color.Red)
            CitaFila("Carlo Emilion", "Facial", Color.Green)
            CitaFila("Daniel Jay Park", "Masaje Terapéutico", Color.Green)
            CitaFila("Mark Rojas", "Spa Premium", Color.Green)
        }

        Spacer(modifier = Modifier.height(24.dp))

        EtiquetaNegra("Tipo de Servicio")
        OutlinedTextField(
            value = "Paquete Relajación Total",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            enabled = false
        )

        Spacer(modifier = Modifier.height(12.dp))

        EtiquetaNegra("Fecha")
        OutlinedTextField(
            value = "24 / 10 / 2025",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            enabled = false
        )

        Spacer(modifier = Modifier.height(12.dp))

        EtiquetaNegra("Estado")
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(Color.Green)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Pendiente", fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { /* Acción buscar */ },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA5D6A7))
            ) {
                Icon(Icons.Default.Search, contentDescription = "Buscar", tint = Color.Black)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Buscar", color = Color.Black)
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = { /* Acción agregar cita */ },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text("Agregar cita", color = Color.White)
            }
        }
    }
}

@Composable
fun CitaFila(nombre: String, servicio: String, estadoColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(nombre, fontSize = 14.sp)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(servicio, fontSize = 14.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(estadoColor)
            )
        }
    }
}

@Composable
fun EtiquetaNegra(texto: String) {
    Text(texto, fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color.Black)
}

@Composable
fun JuaniTabItem(titulo: String, activo: Boolean) {
    Text(
        text = titulo,
        fontSize = 14.sp,
        fontWeight = if (activo) FontWeight.Bold else FontWeight.Normal,
        color = if (activo) Color.Black else Color.Gray,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(if (activo) Color(0xFFE0E0E0) else Color.Transparent)
            .padding(horizontal = 12.dp, vertical = 8.dp)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CitasAdminPreview() {
    JuaniTheme {
        CitasAdminScreen()
    }
}