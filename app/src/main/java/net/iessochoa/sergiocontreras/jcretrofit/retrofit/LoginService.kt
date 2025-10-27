package net.iessochoa.sergiocontreras.jcretrofit.retrofit

import net.iessochoa.sergiocontreras.jcretrofit.entities.LoginResponse
import net.iessochoa.sergiocontreras.jcretrofit.entities.UserInfo
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * Project: JC Retrofit
 * From: net.iessochoa.sergiocontreras.jcretrofit.retrofit
 * Created by: Contr
 * On: 27/10/2025 at 10:42
 * Creado en Settings -> Editor -> File and Code Templates
 */
interface LoginService {
    @Headers("x-api-key: reqres-free-v1")
    @POST(Constants.API_PATH + Constants.LOGIN_PATH)
    suspend fun loginUser(@Body user: UserInfo): LoginResponse
}