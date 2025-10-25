package net.iessochoa.sergiocontreras.jcretrofit.retrofit

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
class RemoteDatabase {

    fun login(
        user: UserInfo,
        onLogin: () -> Unit,
        onError: (String) -> Unit
    ) {

        val retrofit = Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        if(user.email.contains("@")) {
            onLogin()
        } else {
            onError(":(")
        }
    }
}