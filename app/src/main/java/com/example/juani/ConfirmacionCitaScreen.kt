package com.example.juani

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
fun ConfirmacionCitaScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconoNavConfirmacion(R.drawable.ic_inicio, "Inicio", isSelected = false)
                IconoNavConfirmacion(R.drawable.ic_calendario_r, "Calendario", isSelected = true)
                IconoNavConfirmacion(R.drawable.ic_megaphone, "Servicios", isSelected = false)
                IconoNavConfirmacion(R.drawable.ic_bell, "Notificaciones", isSelected = false)
                IconoNavConfirmacion(R.drawable.ic_user, "Perfil", isSelected = false)
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text("¡Confirma tu cita!", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }

            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_calendario),
                        contentDescription = "Icono calendario",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text("Fecha", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                        Text("24/10/2025", fontSize = 14.sp, color = Color.DarkGray)
                    }
                }
            }

            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_hora),
                        contentDescription = "Icono hora",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text("Hora", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                        Text("10:00 AM", fontSize = 14.sp, color = Color.DarkGray)
                    }
                }
            }

            item {
                Text("Tipo de Servicio", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                Text("Paquete Relajación Total", fontSize = 14.sp, color = Color.DarkGray)
            }

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFF0F0F0))
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_spa_relajacion),
                            contentDescription = "Imagen del paquete de relajación",
                            modifier = Modifier
                                .size(120.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )

                        Column(modifier = Modifier.weight(1f)) {
                            Text("Descripción", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text("- Masaje relajante con aceites esenciales", fontSize = 14.sp)
                            Text("- Terapia con piedras calientes", fontSize = 14.sp)
                            Text("- Aromaterapia personalizada infusión relajante al finalizar", fontSize = 14.sp)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text("Puntos otorgados: 50", fontSize = 12.sp, color = Color.Gray)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text("Precio: $1,600 mxn", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_ubicacion),
                        contentDescription = "Icono ubicación",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text("Dirección", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                        Text(
                            "Calle Serenidad 128, Col. Jardines del Lago.\nAlcaldía Miguel Hidalgo",
                            fontSize = 14.sp,
                            color = Color.DarkGray
                        )
                    }
                }
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { /* Acción para reagendar */ },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9CAC7D))
                    ) {
                        Text("Reagendar", fontSize = 16.sp, color = Color.White)
                    }
                    Button(
                        onClick = { /* Acción para confirmar */ },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                    ) {
                        Text("Confirmar", fontSize = 16.sp, color = Color.White)
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun IconoNavConfirmacion(iconoId: Int, descripcion: String, isSelected: Boolean) {
    Icon(
        painter = painterResource(id = iconoId),
        contentDescription = descripcion,
        modifier = Modifier.size(26.dp),
        tint = if (isSelected) Color.Black else Color(0xFFB0B0B0)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ConfirmacionCitaPreview() {
    JuaniTheme {
        ConfirmacionCitaScreen()
    }
}