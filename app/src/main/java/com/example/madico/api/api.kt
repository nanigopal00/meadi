package com.example.madico.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object api {
    val clintt = OkHttpClient.Builder().build()
    var instance = Retrofit.Builder().client(clintt).baseUrl(apibuilder.baseurl).addConverterFactory(GsonConverterFactory.create()).build().create(apibuilder::class.java)
}
