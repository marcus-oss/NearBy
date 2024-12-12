package com.nwl.nearby

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.nwl.nearby.data.model.Market
import com.nwl.nearby.ui.Screen.HomeScreen
import com.nwl.nearby.ui.Screen.MarketDetailScreen
import com.nwl.nearby.ui.Screen.Route.Home
import com.nwl.nearby.ui.Screen.Route.Splash
import com.nwl.nearby.ui.Screen.Route.Welcome
import com.nwl.nearby.ui.Screen.SplashScreen
import com.nwl.nearby.ui.Screen.WelcomeScreen
import com.nwl.nearby.ui.theme.NearbyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NearbyTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Splash
                ) {
                    composable<Splash> {
                        SplashScreen(
                            onNavigationToWelcome = {
                                navController.navigate(Welcome)
                            }
                        )
                    }
                    composable<Welcome> {
                        WelcomeScreen(onNavigateToHome = {
                            navController.navigate(Home)
                        })

                        composable<Home> {
                            HomeScreen(onNavigateToMarketToDetails = { selectedMarket ->
                                navController.navigate(it)
                            })
                        }

                        composable<Market> {
                            val selectedMarket = it.toRoute<Market>()

                            MarketDetailScreen(market = selectedMarket, onNavigationBack = {
                                navController.popBackStack()
                            })
                        }
                    }

                }
            }

        }
    }
}



