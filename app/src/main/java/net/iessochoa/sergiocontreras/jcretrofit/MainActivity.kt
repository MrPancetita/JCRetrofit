package net.iessochoa.sergiocontreras.jcretrofit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.iessochoa.sergiocontreras.jcretrofit.retrofit.RemoteDatabase
import net.iessochoa.sergiocontreras.jcretrofit.ui.theme.JCRetrofitTheme

class MainActivity : ComponentActivity() {

    private val db: RemoteDatabase by lazy { RemoteDatabase(lifecycleScope, this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JCRetrofitTheme {

                val snackBarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()

                var inProgress by remember { mutableStateOf(false)}

                val showMsg = {msg: String ->
                    scope.launch {
                        inProgress = false
                        snackBarHostState.showSnackbar(message = msg)
                }

                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackBarHostState) }
                ) { innerPadding ->
                   MainView(Modifier.padding(
                       paddingValues = innerPadding),
                       inProgres = inProgress,
                       onGoUsers = { launchUsers() },
                       onClick = { user, isLogin ->
                           inProgress = true
                           if (isLogin) {
                               db.login(user,
                                   onLogin = {
                                       launchProfile(); inProgress = false
                                   },
                                   onError = { error ->
                                       //Log.e("SERGIO", "onCreate: $error")
                                       showMsg(error) }
                               )
                           } else {
                               db.register(user,
                                   onRegister = { showMsg(it) },
                                   onError = { showMsg(it) })
                           }
                       }
                   )
                }
            }
        }
    }

    private fun launchProfile() {
        startActivity(Intent(this, ProfileActivity::class.java))
    }

    private fun launchUsers() {
        startActivity(Intent(this, UsersActivity::class.java))
    }


}



@Preview(showBackground = true)
@Composable
private fun LocalMainPreview() {
    JCRetrofitTheme {
        MainPreview()
    }
}