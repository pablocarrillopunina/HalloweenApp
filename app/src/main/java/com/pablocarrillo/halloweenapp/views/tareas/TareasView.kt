package com.pablocarrillo.halloweenapp.views.tareas

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pablocarrillo.halloweenapp.R

@Composable
fun TareasView() {

    var listaTareas by remember {
        mutableStateOf(
            listOf(
                "Apaga todas las luces y mira por la ventana durante 10 segundos 👁",
                "Di 'Bloody Mary' tres veces frente al espejo 🪞",
                "Escucha un sonido de terror sin taparte los oídos 🎧",
                "Camina a oscuras por tu pasillo sin usar linterna 🌑",
                "Observa un rincón oscuro durante 15 segundos sin parpadear 👀",
                "Ve un clip de Thriller sin bajar el volumen 🕺🧟"
            )
        )
    }

    var nuevaTarea by remember { mutableStateOf("") }
    var modoExtremo by remember { mutableStateOf(false) }

    val misionesExtremas = listOf(
        "Quédate en silencio absoluto durante 1 minuto sin moverte 🕯",
        "Mira debajo de tu cama sin encender la luz 🔦",
        "Susurra tu nombre frente al espejo con la luz apagada 🪞👤",
        "Ve solo a una habitación oscura y di 'Estás aquí?' 👻",
        "Permanece 30 segundos inmóvil y de espaldas a una puerta entreabierta 🚪",
        "Haz un recorrido por tu casa a oscuras a las 3:00 AM 🕒"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF2C003E), Color(0xFF0D0D0D))
                )
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Misiones de Supervivencia 🩸",
            fontSize = 28.sp,
            color = Color(0xFFFF6F00),
            modifier = Modifier.padding(10.dp)
        )

        OutlinedTextField(
            value = nuevaTarea,
            onValueChange = { nuevaTarea = it },
            label = { Text("Añade tu misión") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Button(
                onClick = {
                    if (nuevaTarea.isNotBlank()) {
                        listaTareas = listaTareas + nuevaTarea
                        nuevaTarea = ""
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6F00))
            ) {
                Text("Agregar", color = Color.Black)
            }

            Button(
                onClick = {
                    if (!modoExtremo) {
                        listaTareas = misionesExtremas + listaTareas
                        modoExtremo = true
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8B0000))
            ) {
                Text("Modo Extremo 💀", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)  // Permite scroll
        ) {
            items(listaTareas) { tarea ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .animateContentSize(animationSpec = tween(durationMillis = 500)),
                    colors = CardDefaults.cardColors(containerColor = if (tarea in misionesExtremas) Color(0xFF660000) else Color(0xFF4A148C))
                ) {

                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.calabaza),
                                contentDescription = "icono",
                                modifier = Modifier.size(28.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(tarea, color = Color.White)
                        }

                        TextButton(onClick = {
                            listaTareas = listaTareas - tarea
                        }) {
                            Text("Eliminar", color = Color(0xFFFF6F00))
                        }
                    }
                }
            }
        }
    }
}
