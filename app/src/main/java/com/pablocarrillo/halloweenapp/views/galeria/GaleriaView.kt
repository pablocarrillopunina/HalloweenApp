package com.pablocarrillo.halloweenapp.views.galeria

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pablocarrillo.halloweenapp.R

/**
 * Muestra una galería de imágenes con temática de Halloween.
 *
 * Este Composable presenta una lista de imágenes en una cuadrícula vertical ([LazyVerticalGrid]).
 * Las imágenes se cargan desde los recursos de la aplicación y se muestran con una
 * relación de aspecto de 1:1 para mantener la coherencia visual.
 * El fondo de la pantalla tiene un degradado vertical.
 */
@Composable
fun GaleriaView() {

    val imagenes = listOf(
        R.drawable.viernes,
        R.drawable.calab,
        R.drawable.mano,
        R.drawable.terror,
        R.drawable.cruz,
        R.drawable.girl,
        R.drawable.calabera,
        R.drawable.spider,
        R.drawable.sexy,
        R.drawable.tatuaje,
        R.drawable.maldad,

        R.drawable.muerte
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF200020), Color.Black)
                )
            )
            .padding(16.dp)
    ) {

        Text(
            "Galería 👁️",
            fontSize = 28.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {

            items(imagenes) { img ->

                Image(
                    painter = painterResource(id = img),
                    contentDescription = "Imagen Halloween",
                    contentScale = ContentScale.Crop,   // 🔥 importantes para que todas queden iguales
                    modifier = Modifier
                        .aspectRatio(1f)                // 🔥 cuadrado perfecto
                        .fillMaxWidth()
                )
            }
        }
    }
}
