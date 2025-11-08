package com.example.juani

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.juani.ui.theme.JuaniTheme

@Composable
fun ClientesAdminScreen(modifier: Modifier = Modifier) {
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
            TabItemClientes("Inicio", false)
            TabItemClientes("Citas", false)
            TabItemClientes("Clientes", true)
            TabItemClientes("Servicios", false)
        }

        Spacer(modifier = Modifier.height(24.dp))

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
                text = "Buscar",
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            )
            Button(
                onClick = { /* Acción agregar cliente */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = RoundedCornerShape(0.dp),
                modifier = Modifier
                    .height(56.dp)
                    .clip(RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp))
            ) {
                Text("Agregar cliente", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        ClienteCardItem(
            nombre = "Selina Salvador",
            estado = "Cliente frecuente",
            estadoColor = Color(0xFFC8E6C9),
            telefono = "555-123-4567",
            fecha = "01/03/2023",
            imagenId = R.drawable.img_perfil_selina
        )

        ClienteCardItem(
            nombre = "Mariana Sanchez",
            estado = "Nuevo",
            estadoColor = Color(0xFFFFF9C4),
            telefono = "555-982-4461",
            fecha = "05/08/2023",
            imagenId = R.drawable.img_perfil_mariana
        )

        ClienteCardItem(
            nombre = "Carlo Emilion",
            estado = "Deudor",
            estadoColor = Color(0xFFFFCDD2),
            telefono = "555-123-4567",
            fecha = "01/03/2023",
            imagenId = R.drawable.img_perfil_carlo
        )

        ClienteCardItem(
            nombre = "Carlos García",
            estado = "Cliente frecuente",
            estadoColor = Color(0xFFC8E6C9),
            telefono = "555-000-0000",
            fecha = "02/06/2023",
            imagenId = R.drawable.img_perfil_carlos
        )
    }
}

@Composable
fun ClienteCardItem(
    nombre: String,
    estado: String,
    estadoColor: Color,
    telefono: String,
    fecha: String,
    imagenId: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imagenId),
                contentDescription = nombre,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(nombre, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(estadoColor)
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(estado, fontSize = 12.sp, color = Color.Black)
                }
                Text(telefono, fontSize = 14.sp)
                Text("Registrado: $fecha", fontSize = 12.sp, color = Color.Gray)
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row {
                    IconButton(onClick = { /* Acción llamada */ }) {
                        Icon(Icons.Default.Call, contentDescription = "Llamar")
                    }
                    IconButton(onClick = { /* Acción calendario */ }) {
                        Icon(Icons.Default.DateRange, contentDescription = "Calendario")
                    }
                }
                Button(
                    onClick = { /* Acción ver detalles */ },
                    modifier = Modifier.height(32.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEEEEEE))
                ) {
                    Text("Ver detalles", fontSize = 12.sp, color = Color.Black)
                }
            }
        }
    }
}

@Composable
fun TabItemClientes(titulo: String, activo: Boolean) {
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
fun ClientesAdminPreview() {
    JuaniTheme {
        ClientesAdminScreen()
    }
}


