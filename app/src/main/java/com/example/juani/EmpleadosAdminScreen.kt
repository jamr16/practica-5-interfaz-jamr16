package com.example.juani

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.juani.ui.theme.JuaniTheme

@Composable
fun EmpleadosAdminScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
        ) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text("JUANI", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TabItemEmpleados("Citas", false)
                TabItemEmpleados("Clientes", false)
                TabItemEmpleados("Servicios", false)
                TabItemEmpleados("Empleados", true)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ResumenItem("Empleados activos", "20")
                    ResumenItem("En servicio", "4")
                    ResumenItem("Citas hoy", "18")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFF0F0F0)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar",
                    tint = Color.Gray,
                    modifier = Modifier.padding(start = 12.dp)
                )
                Text(
                    text = "Buscar empleado",
                    color = Color.Gray,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FiltroItem("Todos", true)
                FiltroItem("Disponibles", false)
                FiltroItem("En sesión", false)
                FiltroItem("Inactivos", false)
            }

            Spacer(modifier = Modifier.height(16.dp))

            EmpleadoCard("Daniela Pérez", "Terapeuta Masaje", "Disponible", R.drawable.img_daniela)
            EmpleadoCard("Carlota Elithion", "Manicurista", "En sesión", R.drawable.img_carlota)
            EmpleadoCard("Mark Rojas", "Terapeuta Spa", "No disponible", R.drawable.img_mark)
            EmpleadoCard("Esteban Morales", "Terapeuta Masaje", "En sesión", R.drawable.img_esteban)
            EmpleadoCard("Susana López", "Terapeuta Masaje", "En sesión", R.drawable.img_susana)
            EmpleadoCard("Erick Blancas", "Terapeuta Masaje", "", R.drawable.img_erick)
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            IconButton(
                onClick = { /* Acción agregar */ },
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar empleado",
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun TabItemEmpleados(titulo: String, activo: Boolean) {
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

@Composable
fun ResumenItem(titulo: String, valor: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = titulo, fontSize = 12.sp, color = Color.Gray)
        Text(text = valor, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun FiltroItem(titulo: String, activo: Boolean) {
    Text(
        text = titulo,
        fontSize = 13.sp,
        fontWeight = if (activo) FontWeight.Bold else FontWeight.Normal,
        color = if (activo) Color.Black else Color.Gray,
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(if (activo) Color(0xFFE0E0E0) else Color.Transparent)
            .padding(horizontal = 12.dp, vertical = 6.dp)
    )
}

@Composable
fun EmpleadoCard(nombre: String, rol: String, estado: String, imagenId: Int) {
    val estadoColor = when (estado) {
        "Disponible" -> Color(0xFFA5D6A7)
        "En sesión" -> Color(0xFFFFE082)
        "No disponible" -> Color(0xFFEF9A9A)
        else -> Color.Transparent
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                Image(
                    painter = painterResource(id = imagenId),
                    contentDescription = nombre,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = nombre, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = rol, fontSize = 14.sp)
            }

            if (estado.isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(estadoColor)
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = estado,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EmpleadosAdminScreenPreview() {
    JuaniTheme {
        EmpleadosAdminScreen()
    }
}