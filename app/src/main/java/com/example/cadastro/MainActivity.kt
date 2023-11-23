package com.example.cadastro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cadastro.ui.theme.CadastroTheme
import com.example.cadastro.view.Home
import com.example.helloworld.view.CadastroLoja
import com.example.helloworld.view.ListaLoja

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CadastroTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "homeLoja") {
                    composable(route = "homeLoja") {
                        Home(navController)
                    }

                    composable(route = "cadastroLoja") {
                        CadastroLoja(navController)
                    }

                    composable(route = "listaLoja") {
                        ListaLoja(navController)
                    }
                }
            }
        }
    }
}