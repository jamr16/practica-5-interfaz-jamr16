package com.example.juani

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun InicioAdminScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(12.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(15.dp))

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text("JUANI", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TabItem("Inicio", true)
                TabItem("Citas", false)
                TabItem("Clientes", false)
                TabItem("Servicios", false)
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MetricCard(
                    titulo = "Ganancias mes de Octubre",
                    valor = "$60,000",
                    cambio = "+20% más que el mes pasado"
                )
                MetricCard(
                    titulo = "Personas registradas",
                    valor = "2405",
                    cambio = "+15% más que el mes pasado"
                )
            }

            Spacer(modifier = Modifier.height(13.dp))

            Text("Ventas de los últimos días", fontSize = 18.sp, fontWeight = FontWeight.Medium)
            Image(
                painter = painterResource(id = R.drawable.img_grafico_ventas),
                contentDescription = "Gráfico de ventas",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )

            Text("Clientes frecuentes", fontSize = 18.sp, fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(13.dp))

            ClienteItem(
                nombre = "Selina Salvador",
                correo = "selindj2819@gmail.com",
                imagenId = R.drawable.img_perfil_selina
            )

            ClienteItem(
                nombre = "Daniel Sánchez",
                correo = "daniel04@gmail.com",
                imagenId = R.drawable.img_perfil_daniel
            )

            ClienteItem(
                nombre = "Carlo Emilion",
                correo = "emilcar67@gmail.com",
                imagenId = R.drawable.img_perfil_carlo
            )

            Spacer(modifier = Modifier.height(64.dp))
        }
    }
}

@Composable
fun TabItem(titulo: String, activo: Boolean) {
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
fun MetricCard(titulo: String, valor: String, cambio: String) {
    Column(
        modifier = Modifier
            .width(160.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF5F5F5))
            .padding(12.dp)
    ) {
        Text(titulo, fontSize = 14.sp, fontWeight = FontWeight.Medium)
        Text(valor, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(cambio, fontSize = 12.sp, color = Color.Gray)
    }
}

@Composable
fun ClienteItem(nombre: String, correo: String, imagenId: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imagenId),
            contentDescription = nombre,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(nombre, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Text(correo, fontSize = 12.sp, color = Color.Gray)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InicioAdminPreview() {
    JuaniTheme {
        InicioAdminScreen()
    }
}