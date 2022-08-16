package com.codepelita.presensiapp

import retrofit2.Call
import retrofit2.http.GET

interface API {

    @GET("get-data.php")
    fun getDatapresensi() : Call<ArrayList<ResultPresensi>>

}