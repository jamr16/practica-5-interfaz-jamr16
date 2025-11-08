package com.example.juani

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.juani.ui.theme.JuaniTheme

@Composable
fun InicioScreen(modifier: Modifier = Modifier) {
    Scaffold(
        bottomBar = { BottomNavigationBar() },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color.White)
                .padding(16.dp)
        ) {
            var searchQuery by remember { mutableStateOf("") }

            Spacer(modifier = Modifier.height(16.dp))

            // 🔍 Buscador
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFF0F0F0))
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                BasicTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    singleLine = true,
                    textStyle = TextStyle(fontSize = 16.sp),
                    modifier = Modifier.fillMaxWidth()
                )
                if (searchQuery.isEmpty()) {
                    Text("Buscar", color = Color.Gray)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 🖼️ Imagen promocional
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
                    .clip(RoundedCornerShape(12.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.limpieza_facial),
                    contentDescription = "Promoción limpieza facial",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "JUANI SPA",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            // 🧖 Servicios
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ServicioItem("Temazcal", R.drawable.temazcal, Modifier.weight(1f))
                ServicioItem("Jacuzzi", R.drawable.jacuzzi, Modifier.weight(1f))
                ServicioItem("Sauna", R.drawable.sauna, Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Paquetes",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            // 🎁 Paquetes
            val paquetes = listOf(
                Paquete(R.drawable.relajacion_total_card, "Relajación Total"),
                Paquete(R.drawable.belleza_natural_card, "Belleza Natural"),
                Paquete(R.drawable.spa_facial_card, "Spa Facial")
            )

            LazyRow(contentPadding = PaddingValues(end = 16.dp)) {
                items(paquetes) { paquete ->
                    PaqueteCard(paquete)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun ServicioItem(nombre: String, imagenId: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imagenId),
            contentDescription = nombre,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(72.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(nombre, fontSize = 14.sp, color = Color.Black)
    }
}

data class Paquete(
    val imagenId: Int,
    val contentDescription: String
)

@Composable
fun PaqueteCard(paquete: Paquete) {
    Card(
        modifier = Modifier
            .width(220.dp)
            .padding(end = 20.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Image(
            painter = painterResource(id = paquete.imagenId),
            contentDescription = paquete.contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(12.dp))
        )
    }
}

@Composable
fun BottomNavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(top = 8.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_home),
            contentDescription = "Inicio",
            modifier = Modifier.size(26.dp),
            tint = Color.Black // ✅ Ícono activo
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_calendar),
            contentDescription = "Agenda",
            modifier = Modifier.size(26.dp),
            tint = Color(0xFFB0B0B0)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_megaphone),
            contentDescription = "Promos",
            modifier = Modifier.size(26.dp),
            tint = Color(0xFFB0B0B0)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Notificaciones",
            modifier = Modifier.size(26.dp),
            tint = Color(0xFFB0B0B0)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_user),
            contentDescription = "Perfil",
            modifier = Modifier.size(26.dp),
            tint = Color(0xFFB0B0B0)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InicioScreenPreview() {
    JuaniTheme {
        InicioScreen()
    }
}