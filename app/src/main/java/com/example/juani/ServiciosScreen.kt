package com.example.juani

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.juani.ui.theme.JuaniTheme

@Composable
fun ServiciosScreen(modifier: Modifier = Modifier) {
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
                IconoNavServicios(R.drawable.ic_inicio, "Inicio", isSelected = false)
                IconoNavServicios(R.drawable.ic_calendario, "Calendario", isSelected = false)
                IconoNavServicios(R.drawable.ic_spa_r, "Servicios", isSelected = true)
                IconoNavServicios(R.drawable.ic_bell, "Notificaciones", isSelected = false)
                IconoNavServicios(R.drawable.ic_user, "Perfil", isSelected = false)
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
                Spacer(modifier = Modifier.height(8.dp)) // Ajustado para que se vea más arriba
                Text("Servicios", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }

            item {
                var searchText by remember { mutableStateOf(TextFieldValue("")) }
                OutlinedTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    placeholder = { Text("Buscar") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CategoriaCircular(R.drawable.ic_masaje, "Masajes")
                    CategoriaCircular(R.drawable.img_spa_relajacion, "Faciales")
                    CategoriaCircular(R.drawable.ic_manicure, "Manicure")
                    CategoriaCircular(R.drawable.ic_pedicure, "Pedicure")
                }
            }

            item {
                Text("¡Elige el ideal para tu bienestar!", fontSize = 18.sp, fontWeight = FontWeight.Medium)
            }

            item {
                Text("Masaje Juani Holístico", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                ServicioCardConImagen(
                    imagenId = R.drawable.img_masaje_holistico,
                    individual = "60 min / $999 mxn",
                    pareja = "60 min / $1,899 mxn",
                    onAgendar = { /* Acción */ }
                )
            }

            item {
                Text("Masaje Juani Terapéutico", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                ServicioCardConImagen(
                    imagenId = R.drawable.img_masaje_terapeutico,
                    individual = "60 min / $999 mxn",
                    pareja = "60 min / $1,899 mxn",
                    onAgendar = { /* Acción */ }
                )
            }

            item {
                Spacer(modifier = Modifier.height(8.dp)) // Espacio final ajustado
            }
        }
    }
}

@Composable
fun IconoNavServicios(iconoId: Int, descripcion: String, isSelected: Boolean) {
    Icon(
        painter = painterResource(id = iconoId),
        contentDescription = descripcion,
        modifier = Modifier.size(26.dp),
        tint = if (isSelected) Color.Black else Color(0xFFB0B0B0)
    )
}

@Composable
fun CategoriaCircular(iconoId: Int, texto: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(Color(0xFFE0E0E0)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = iconoId),
                contentDescription = texto,
                modifier = Modifier.size(100.dp)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(texto, fontSize = 12.sp)
    }
}

@Composable
fun ServicioCardConImagen(
    imagenId: Int,
    individual: String,
    pareja: String,
    onAgendar: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFF0F0F0))
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(id = imagenId),
                contentDescription = null,
                modifier = Modifier
                    .size(140.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Column(modifier = Modifier.weight(1f)) {
                Text("Individual: $individual", fontSize = 14.sp)
                Text("En pareja: $pareja", fontSize = 14.sp)
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = onAgendar,
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF81C784))
                ) {
                    Text("Agendar", fontSize = 16.sp, color = Color.White)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ServiciosPreview() {
    JuaniTheme {
        ServiciosScreen()
    }
}