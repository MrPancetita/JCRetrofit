package net.iessochoa.sergiocontreras.jcretrofit

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.iessochoa.sergiocontreras.jcretrofit.retrofit.RemoteDatabase
import net.iessochoa.sergiocontreras.jcretrofit.ui.theme.JCRetrofitTheme

class MainActivity : ComponentActivity() {

    private val db: RemoteDatabase by lazy { RemoteDatabase(lifecycleScope) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JCRetrofitTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   MainView(Modifier.padding(
                       paddingValues = innerPadding),
                       inProgres = false,
                       onGoUsers = {},
                       onClick = { user ->
                            db.login(user,
                                onLogin = {
                                    launchProfile()
                                },
                                onError = { error ->
                                    Log.e("SERGIO", "onCreate: $error")
                                }
                            )
                       }
                   )
                }
            }
        }
    }

    private fun launchProfile() {
        lifecycleScope.launch(Dispatchers.Main) {
            Toast.makeText(this@MainActivity, "Entrando perfil del usuario...", Toast.LENGTH_SHORT).show()
        }
    }

}



@Preview(showBackground = true)
@Composable
private fun LocalMainPreview() {
    JCRetrofitTheme {
        MainPreview()
    }
}