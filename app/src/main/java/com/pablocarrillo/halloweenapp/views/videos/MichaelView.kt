package com.pablocarrillo.halloweenapp.views.videos

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MichaelView() {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF2C003E), Color(0xFF0D0D0D))
                )
            )
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Text(
            text = "Videos de Michael Jackson 🕺",
            fontSize = 28.sp,
            color = Color(0xFFFF6F00),
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
        )

        VideoButton("Thriller 🧟‍♂️") {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/shorts/J1xXAUckZP0")))
        }

        VideoButton("Ghosts 👻") {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/shorts/W7_XjANFtFQ")))
        }

        VideoButton("Beat It ⚡") {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/shorts/x3_yspxeSTI")))
        }

        VideoButton("Smooth Criminal 🕶") {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/shorts/1MR78_inW3I")))
        }
    }
}

@Composable
fun VideoButton(texto: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8B0000))
    ) {
        Text(text = texto, color = Color.White, fontSize = 18.sp)
    }
}
