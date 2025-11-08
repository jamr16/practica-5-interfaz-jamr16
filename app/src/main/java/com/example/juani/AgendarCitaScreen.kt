package com.example.juani

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
fun AgendarCitaScreen(modifier: Modifier = Modifier) {
    var horarioSeleccionado by remember { mutableStateOf("11:00 AM") }

    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(top = 8.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconoNavInferior(R.drawable.ic_inicio, "Inicio", isSelected = false)
                IconoNavInferior(R.drawable.ic_calendario_r, "Calendario", isSelected = true)
                IconoNavInferior(R.drawable.ic_megaphone, "Servicios", isSelected = false)
                IconoNavInferior(R.drawable.ic_bell, "Notificaciones", isSelected = false)
                IconoNavInferior(R.drawable.ic_user, "Perfil", isSelected = false)
            }
        }
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color.White)
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text("Agendar cita", fontSize = 22.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(16.dp))

            Text("Tipo de Servicio", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFF0F0F0))
                    .padding(12.dp)
            ) {
                Text("Paquete Relajación Total", fontSize = 14.sp, color = Color.DarkGray)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text("Selecciona Día y Fecha", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = R.drawable.calendario_octubre_2025),
                contentDescription = "Calendario Octubre 2025",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text("Horarios", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                listOf("9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM").forEach { hora ->
                    HorarioItem(
                        hora = hora,
                        seleccionado = horarioSeleccionado,
                        onSelect = { horarioSeleccionado = hora },
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text("Dirección", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Calle Serenidad 128, Col. Jardines del Lago.\nAlcaldía Miguel Hidalgo",
                fontSize = 14.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { /* Acción para continuar */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text("Continuar", fontSize = 16.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun HorarioItem(
    hora: String,
    seleccionado: String,
    onSelect: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val isSelected = hora == seleccionado
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(
                if (isSelected) Color(0xFFB0B0B0)
                else Color(0xFF81C784)
            )
            .clickable { onSelect(hora) }
            .padding(vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            hora,
            fontSize = 14.sp,
            color = if (isSelected) Color.White else Color.Black
        )
    }
}

@Composable
fun IconoNavInferior(
    iconId: Int,
    contentDescription: String,
    isSelected: Boolean
) {
    Icon(
        painter = painterResource(id = iconId),
        contentDescription = contentDescription,
        modifier = Modifier.size(26.dp),
        tint = if (isSelected) Color.Black else Color(0xFFB0B0B0)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AgendarCitaPreview() {
    JuaniTheme {
        AgendarCitaScreen()
    }
}