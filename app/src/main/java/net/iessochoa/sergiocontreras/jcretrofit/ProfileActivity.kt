package net.iessochoa.sergiocontreras.jcretrofit

import android.os.Bundle
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
import net.iessochoa.sergiocontreras.jcretrofit.entities.Data
import net.iessochoa.sergiocontreras.jcretrofit.entities.SingleUserResponse
import net.iessochoa.sergiocontreras.jcretrofit.entities.Support
import net.iessochoa.sergiocontreras.jcretrofit.ui.theme.JCRetrofitTheme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JCRetrofitTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileView(
                        modifier = Modifier.padding(innerPadding),
                        response = SingleUserResponse(null),
                        inProgress = false
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LocalProfilePreview() {
    JCRetrofitTheme {
        ProfilePreview()
    }
}