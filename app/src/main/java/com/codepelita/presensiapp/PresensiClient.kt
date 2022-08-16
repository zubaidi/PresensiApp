package com.codepelita.presensiapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PresensiClient {

    private const val BASE_URL = "http://200.100.0.75/presensi/"

    val instance : API by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(API::class.java)
    }

}