package com.pablocarrillo.halloweenapp.views.menu

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pablocarrillo.halloweenapp.R
import kotlinx.coroutines.launch

@Composable
fun MenuView(navController: NavController) {

    // Fondo degradado igual que antes
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF1A001F),
                        Color(0xFF090909),
                        Color(0xFF000000)
                    )
                )
            )
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Título original
            Text(
                text = "Noche de Terror 👹",
                fontSize = 36.sp,
                fontWeight = FontWeight.ExtraBold,
                style = androidx.compose.ui.text.TextStyle(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFFF3D00),
                            Color(0xFFFF9100),
                            Color(0xFFFF3D00)
                        )
                    )
                ),
                modifier = Modifier.padding(top = 40.dp, bottom = 10.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // MENÚ ORIGINAL 2x2
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Fila 1
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    MenuCard(
                        image = R.drawable.monster,
                        label = "Tareas"
                    ) { navController.navigate("tareas") }

                    MenuCard(
                        image = R.drawable.escenas,
                        label = "Galería"
                    ) { navController.navigate("galeria") }
                }

                // Fila 2
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    MenuCard(
                        image = R.drawable.jackson,
                        label = "Vídeos"
                    ) { navController.navigate("michael") }

                    MenuCard(
                        image = R.drawable.terror,
                        label = "Juego"
                    ) { navController.navigate("juego") }
                }
            }
        }
    }
}

@Composable
fun MenuCard(image: Int, label: String, onClick: () -> Unit) {

    val scale = remember { Animatable(1f) }
    val scope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .shadow(20.dp, RoundedCornerShape(20.dp))
            .background(Color(0x22000000), RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp))
            .clickable {
                scope.launch {
                    scale.animateTo(0.90f, tween(100, easing = FastOutSlowInEasing))
                    scale.animateTo(1f, tween(150, easing = FastOutSlowInEasing))
                }
                onClick()
            }
            .padding(12.dp)
            .scale(scale.value)
    ) {

        // Imagen con bordes redondeados + sombra
        Image(
            painter = painterResource(id = image),
            contentDescription = label,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(140.dp)                 // tu tamaño original
                .clip(RoundedCornerShape(16.dp))
                .shadow(12.dp, RoundedCornerShape(16.dp))
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Texto
        Text(
            text = label,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
