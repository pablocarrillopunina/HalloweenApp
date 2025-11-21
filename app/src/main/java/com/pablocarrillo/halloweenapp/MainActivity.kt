package com.pablocarrillo.halloweenapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.pablocarrillo.halloweenapp.navigation.NavManager
import com.pablocarrillo.halloweenapp.ui.theme.HalloweenAppTheme

/**
 * La actividad principal de la aplicación.
 *
 * Esta actividad es el punto de entrada de la aplicación y se encarga de configurar
 * la vista principal, que en este caso es el gestor de navegación [NavManager].
 */
class MainActivity : ComponentActivity() {
    /**
     * Se llama cuando se crea la actividad.
     *
     * Aquí es donde se debe realizar la inicialización de la interfaz de usuario.
     * Se configura el tema de la aplicación y se inicializa el [NavManager]
     * para gestionar la navegación entre las diferentes pantallas.
     *
     * @param savedInstanceState Si la actividad se reinicia después de haber sido
     * cerrada por el sistema, este Bundle contiene los datos que la actividad
     * proporcionó más recientemente en [onSaveInstanceState]. De lo contrario, es nulo.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HalloweenAppTheme {
                val navController = rememberNavController()
                NavManager(navController)
            }
        }
    }
}
