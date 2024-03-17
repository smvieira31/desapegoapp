package br.com.fiap.desapego

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
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController

import br.com.fiap.desapego.screens.DadosScreen
import br.com.fiap.desapego.screens.DoacoesScreen
//import br.com.fiap.desapego.screens.dadosViewModel
import br.com.fiap.desapego.ui.theme.DesapegoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DesapegoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "dados"
                    ) {
                        composable(route = "dados"){
                            DadosScreen(navController)
                        //, dadosViewModel())
                        }
                        composable(route = "doacoes/{cidade}"){
                            val cidade = it.arguments?.getString("cidade")
                            DoacoesScreen(navController, cidade!!)
                        }

                    }
                }
            }
        }
    }
}



//@Composable
//fun Greeting() {
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//
//}

