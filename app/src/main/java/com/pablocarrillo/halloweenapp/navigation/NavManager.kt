package com.pablocarrillo.halloweenapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pablocarrillo.halloweenapp.views.menu.MenuView
import com.pablocarrillo.halloweenapp.views.tareas.TareasView
import com.pablocarrillo.halloweenapp.views.galeria.GaleriaView
import com.pablocarrillo.halloweenapp.views.videos.MichaelView
import com.pablocarrillo.halloweenapp.views.juego.JuegoView

/**
 * Gestiona la navegación de la aplicación.
 *
 * Este Composable se encarga de configurar el grafo de navegación utilizando [NavHost].
 * Define todas las rutas (pantallas) de la aplicación y el Composable que se debe
 * mostrar para cada una.
 *
 * @param navController El controlador de navegación que gestiona el estado de la pila de
 * navegación. Se utiliza para navegar entre las diferentes pantallas.
 */
@Composable
fun NavManager(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "menu") {

        composable("menu") { MenuView(navController) }
        composable("tareas") { TareasView() }
        composable("galeria") { GaleriaView() }
        composable("michael") { MichaelView() }
        composable("juego") { JuegoView() }
    }
}
