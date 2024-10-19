package com.example.madico.api

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface apibuilder {
    @POST("/createuser")
    @FormUrlEncoded
    suspend fun createuser(
        @Field("name") name: String,
        @Field("password")password: String,
        @Field("email")email: String,
        @Field("phone")phone: String,
        @Field("pin")pin: String,
        @Field("address")address: String
    ): createuserresponce


    companion object {
        val baseurl = "https://nanigopaldey.pythonanywhere.com"
    }
}