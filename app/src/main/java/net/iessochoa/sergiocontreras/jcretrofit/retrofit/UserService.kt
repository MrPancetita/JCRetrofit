package net.iessochoa.sergiocontreras.jcretrofit.retrofit

import net.iessochoa.sergiocontreras.jcretrofit.entities.SingleUserResponse
import net.iessochoa.sergiocontreras.jcretrofit.entities.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface UserService {

    @Headers("x-api-key: reqres-free-v1")
    @GET(Constants.API_PATH + Constants.USERS_PATH + Constants.ID_PATH)
    suspend fun getSingleUser(): SingleUserResponse

    @Headers("x-api-key: reqres-free-v1")
    @GET(Constants.API_PATH + Constants.USERS_PATH + Constants.PAGE_TWO_PATH)
    suspend fun getListUsers(): UsersResponse

}