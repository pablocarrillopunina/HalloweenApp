package com.pablocarrillo.halloweenapp.views.juego

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pablocarrillo.halloweenapp.R
import kotlin.random.Random

@Composable
fun JuegoView() {

    val context = LocalContext.current

    // IMÁGENES
    val buenas = listOf(R.drawable.calabaza, R.drawable.muerte)
    val malas = listOf(R.drawable.sexy, R.drawable.spider)

    var score by remember { mutableStateOf(0) }
    var gameOver by remember { mutableStateOf(false) }

    // NUEVA RONDA DE IMÁGENES ALEATORIAS
    var imagenes by remember {
        mutableStateOf(generateRandomImages(buenas, malas))
    }

    // Fondo Halloween
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF2C003E),
                        Color(0xFF0D0D0D)
                    )
                )
            )
            .padding(20.dp)
    ) {

        if (!gameOver) {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Puntos: $score",
                    color = Color.White,
                    fontSize = 30.sp
                )

                // Grid 2x2
                Column {
                    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
                        JuegoItem(imagenes[0], onGood = {
                            score++
                            imagenes = generateRandomImages(buenas, malas)
                        }, onBad = {
                            // 📌 Aquí ponemos el enlace de YouTube:
                            val url = "https://www.youtube.com/shorts/D1CdFZDhFII"
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                            context.startActivity(intent)

                            gameOver = true
                        })
                        JuegoItem(imagenes[1], onGood = {
                            score++
                            imagenes = generateRandomImages(buenas, malas)
                        }, onBad = {
                            val url = "https://www.youtube.com/shorts/D1CdFZDhFII"
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                            context.startActivity(intent)

                            gameOver = true
                        })
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
                        JuegoItem(imagenes[2], onGood = {
                            score++
                            imagenes = generateRandomImages(buenas, malas)
                        }, onBad = {
                            val url = "https://www.youtube.com/shorts/D1CdFZDhFII"
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                            context.startActivity(intent)

                            gameOver = true
                        })
                        JuegoItem(imagenes[3], onGood = {
                            score++
                            imagenes = generateRandomImages(buenas, malas)
                        }, onBad = {
                            val url = "https://www.youtube.com/shorts/D1CdFZDhFII"
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                            context.startActivity(intent)

                            gameOver = true
                        })
                    }
                }

            }

        } else {

            // GAME OVER 🎃
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text("💀 GAME OVER 💀", fontSize = 40.sp, color = Color.Red)
                Spacer(modifier = Modifier.height(20.dp))
                Text("Puntuación: $score", fontSize = 26.sp, color = Color.White)
                Spacer(modifier = Modifier.height(30.dp))

                Button(onClick = {
                    score = 0
                    gameOver = false
                    imagenes = generateRandomImages(buenas, malas)
                }) {
                    Text("Reintentar")
                }
            }
        }
    }
}

// GENERAR LISTA ALEATORIA DE IMÁGENES
fun generateRandomImages(good: List<Int>, bad: List<Int>): List<Pair<Int, Boolean>> {
    val result = mutableListOf<Pair<Int, Boolean>>()

    // 2 buenas
    good.shuffled().take(2).forEach { result.add(it to true) }

    // 2 malas
    bad.shuffled().take(2).forEach { result.add(it to false) }

    return result.shuffled()
}

@Composable
fun JuegoItem(image: Pair<Int, Boolean>, onGood: () -> Unit, onBad: () -> Unit) {

    var alphaAnim by remember { mutableStateOf(1f) }

    val fade by animateFloatAsState(
        targetValue = alphaAnim,
        animationSpec = tween(350),
        label = ""   // 👈 obligatorio en Compose actual
    )


    Image(
        painter = painterResource(id = image.first),
        contentDescription = "",
        modifier = Modifier
            .size(150.dp)
            .alpha(fade)
            .clickable {
                alphaAnim = 0.5f

                if (image.second) onGood()
                else onBad()

                alphaAnim = 1f
            }
    )
}
