package net.iessochoa.sergiocontreras.jcretrofit.retrofit

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.iessochoa.sergiocontreras.jcretrofit.entities.UserInfo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Project: JC Retrofit
 * From: net.iessochoa.sergiocontreras.jcretrofit.retrofit
 * Created by: Contr
 * On: 25/10/2025 at 22:51
 * Creado en Settings -> Editor -> File and Code Templates
 */
class RemoteDatabase(private val scope: CoroutineScope) {

    fun login(
        user: UserInfo,
        onLogin: () -> Unit,
        onError: (String) -> Unit
    ) {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(LoginService::class.java)

        scope.launch(Dispatchers.IO) {
            val result = service.loginUser(user)
            Log.i("SERGIO", "login: ${result.token}")
            if (result.token.isNotEmpty()) onLogin() //Si hemos logeado bien
        }

        /* ESTO ERA TEMPORAL
        if(user.email.contains("@")) {
            onLogin()
        } else {
            onError(":(")
        }*/
    }
}

/* DATOS DEL ENDPOINT FOR TEST
{
    "email": "eve.holt@reqres.in",
    "password": "cityslicka"
}
 */