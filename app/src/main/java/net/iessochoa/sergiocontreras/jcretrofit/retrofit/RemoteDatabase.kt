package net.iessochoa.sergiocontreras.jcretrofit.retrofit

import android.content.Context
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.iessochoa.sergiocontreras.jcretrofit.R
import net.iessochoa.sergiocontreras.jcretrofit.entities.UserInfo
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Project: JC Retrofit
 * From: net.iessochoa.sergiocontreras.jcretrofit.retrofit
 * Created by: Contr
 * On: 25/10/2025 at 22:51
 * Creado en Settings -> Editor -> File and Code Templates
 */
class RemoteDatabase(private val scope: CoroutineScope, private val context: Context) {

    private fun setupRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private fun getLoginService(): LoginService = setupRetrofit().create(LoginService::class.java)

    fun login(
        user: UserInfo,
        onLogin: () -> Unit,
        onError: (String) -> Unit
    ) {

        val service = getLoginService()


        scope.launch(Dispatchers.IO) {
            try {
                val result = service.loginUser(user)
                Log.i("SERGIO", "login: ${result.token}")
                if (result.token.isNotEmpty()) onLogin() //Si hemos logeado bien }
            } catch (e: Exception) {
                (e as? HttpException)?.let {
                    val error = checkError(e)
                    onError(error)
                }
            }
        }
    }

    fun register(
        user: UserInfo,
        onRegister: (String) -> Unit,
        onError: (String) -> Unit
    ) {


        val service = getLoginService()

        scope.launch(Dispatchers.IO) {
            try {
                val result = service.registerUser(user)
                Log.i("SERGIO", "register: ${result.id}")
                if (result.token.isNotEmpty()) onRegister("New id: ${result.id}") //Si hemos logeado bien }
            } catch (e: Exception) {
                (e as? HttpException)?.let {
                    val error = checkError(e)
                    onError(error)
                }
            }
        }
    }

    private fun checkError(e: HttpException): String = when(e.code()) {
        400 -> context.getString(R.string.main_error_server_400)
        401 -> context.getString(R.string.main_error_server_401)
        403 -> context.getString(R.string.main_error_server_403)
        else -> context.getString(R.string.main_error_default)
    }

}

