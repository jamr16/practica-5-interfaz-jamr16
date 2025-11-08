package com.example.juani

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text("Perfil", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconoNavPerfil(R.drawable.ic_inicio, "Inicio", isSelected = false)
                IconoNavPerfil(R.drawable.ic_calendario, "Calendario", isSelected = false)
                IconoNavPerfil(R.drawable.ic_megaphone, "Servicios", isSelected = false)
                IconoNavPerfil(R.drawable.ic_bell, "Notificaciones", isSelected = false)
                IconoNavPerfil(R.drawable.ic_user_red, "Perfil", isSelected = true)
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
                Spacer(modifier = Modifier.height(48.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img_perfil_usuario),
                        contentDescription = "Foto de perfil",
                        modifier = Modifier
                            .size(160.dp)
                            .clip(CircleShape)
                    )
                }
            }

            item {
                Text("Nombre:", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text("Selina Salvador Moreno", fontSize = 16.sp)
            }

            item {
                Text("Correo Electrónico:", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text("selindj2819@gmail.com", fontSize = 16.sp)
            }

            item {
                Text("Membresía:", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text("Nivel actual: Oro", fontSize = 16.sp)
                Text("Puntos acumulados: 850", fontSize = 16.sp)
            }

            item {
                PerfilSeccionItem("Historial de servicios")
            }

            item {
                PerfilSeccionItem("Paquete Belleza Natural")
            }

            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFE0E0E0))
                        .padding(12.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_configuracion),
                        contentDescription = "Configuración",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Configuración de la cuenta", fontSize = 16.sp)
                }
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun IconoNavPerfil(iconoId: Int, descripcion: String, isSelected: Boolean) {
    Icon(
        painter = painterResource(id = iconoId),
        contentDescription = descripcion,
        modifier = Modifier.size(28.dp),
        tint = if (isSelected) Color.Black else Color(0xFFB0B0B0)
    )
}

@Composable
fun PerfilSeccionItem(titulo: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF0F0F0))
            .padding(16.dp)
    ) {
        Text(titulo, fontSize = 16.sp, fontWeight = FontWeight.Medium)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PerfilPreview() {
    JuaniTheme {
        PerfilScreen()
    }
}