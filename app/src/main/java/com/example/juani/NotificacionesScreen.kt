package com.example.juani

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
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
fun NotificacionesScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 26.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconoNavNotificaciones(R.drawable.ic_inicio, "Inicio", isSelected = false)
                IconoNavNotificaciones(R.drawable.ic_calendario, "Calendario", isSelected = false)
                IconoNavNotificaciones(R.drawable.ic_megaphone, "Servicios", isSelected = false)
                IconoNavNotificaciones(R.drawable.ic_bell_red, "Notificaciones", isSelected = true)
                IconoNavNotificaciones(R.drawable.ic_user, "Perfil", isSelected = false)
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
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Notificaciones",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            item {
                NotificacionItem(
                    imagenDecorativaId = R.drawable.img_hoja_bienvenida,
                    imagenDerechaId = R.drawable.img_spa_relajacion,
                    titulo = "Relajación Total",
                    mensaje = "Has realizado una reservación.",
                    fecha = "Hace 1 día"
                )
            }

            item {
                NotificacionItem(
                    imagenDecorativaId = R.drawable.img_hoja_bienvenida,
                    imagenDerechaId = null,
                    titulo = "Juani",
                    mensaje = "Te damos la bienvenida a nuestro Spa. Esperamos que sea de tu agrado.\n¡Gracias por registrarte en Juani!",
                    fecha = "Hace 2 días"
                )
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun IconoNavNotificaciones(iconoId: Int, descripcion: String, isSelected: Boolean) {
    Icon(
        painter = painterResource(id = iconoId),
        contentDescription = descripcion,
        modifier = Modifier.size(28.dp),
        tint = if (isSelected) Color.Black else Color(0xFFB0B0B0)
    )
}

@Composable
fun NotificacionItem(
    imagenDecorativaId: Int,
    imagenDerechaId: Int?,
    titulo: String,
    mensaje: String,
    fecha: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF5F5F5))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imagenDecorativaId),
            contentDescription = "Decoración",
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(6.dp))
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(titulo, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(mensaje, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(fecha, fontSize = 12.sp, color = Color.Gray)
        }

        Spacer(modifier = Modifier.width(12.dp))

        if (imagenDerechaId != null) {
            Image(
                painter = painterResource(id = imagenDerechaId),
                contentDescription = titulo,
                modifier = Modifier
                    .size(75.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NotificacionesPreview() {
    JuaniTheme {
        NotificacionesScreen()
    }
}