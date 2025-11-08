package com.example.juani

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
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
fun ServiciosAdminScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(5.dp))

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text("JUANI", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TabItemServicios("Inicio", false)
            TabItemServicios("Citas", false)
            TabItemServicios("Clientes", false)
            TabItemServicios("Servicios", true)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ResumenColumnaEstilizada("Servicios activos", "8")
                ResumenColumnaEstilizada("Promedio de precio", "$480 MXN")
                ResumenColumnaEstilizada("Más solicitado", "Relajación Total")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

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
                text = "Buscar servicio",
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            )
            Button(
                onClick = { /* Acción agregar servicio */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = RoundedCornerShape(0.dp),
                modifier = Modifier
                    .height(56.dp)
                    .clip(RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp))
            ) {
                Text("Agregar", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        ServicioCard("Faciales", "60 min", "Limpieza facial profunda con exfoliación", "$350 MXN", R.drawable.img_spa_relajacion)
        ServicioCard("Masajes", "60 min", "Masaje corporal completo con aceites", "$450 MXN", R.drawable.ic_masaje)
        ServicioCard("Manicura Clásica", "60 min", "Limpieza, limado, y esmaltado de uñas", "$250 MXN", R.drawable.ic_manicure)
        ServicioCard("Pedicura Clásica", "60 min", "Limpieza, limado, y esmaltado de uñas", "$300 MXN", R.drawable.ic_pedicure)
        ServicioCard("Masaje Terapéutico", "60 min", "Masaje profundo con enfoque en músculos tensos", "$999 MXN", R.drawable.img_masaje_terapeutico)
    }
}

@Composable
fun ServicioCard(nombre: String, duracion: String, descripcion: String, precio: String, imagenId: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 4.dp, end = 4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = { /* Acción editar servicio */ }) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Editar servicio",
                        tint = Color.Gray
                    )
                }
                Text(
                    text = precio,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(90.dp)
                        .clip(RoundedCornerShape(4.dp))
                ) {
                    Image(
                        painter = painterResource(id = imagenId),
                        contentDescription = nombre,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.width(20.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(nombre, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(duracion, fontSize = 14.sp, color = Color.Gray)
                    Text(descripcion, fontSize = 13.sp, color = Color.Gray)
                }
            }
        }
    }
}

@Composable
fun TabItemServicios(titulo: String, activo: Boolean) {
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
fun ResumenColumnaEstilizada(titulo: String, valor: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.width(100.dp)
    ) {
        Text(
            text = titulo,
            fontSize = 13.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = valor,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ServiciosAdminPreview() {
    JuaniTheme {
        ServiciosAdminScreen()
    }
}