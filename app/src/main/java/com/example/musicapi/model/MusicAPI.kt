package com.example.musicapi.model

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicAPI {

    companion object {
        fun initRetrofit(genre: String): MusicAPI{

            val retrofit = Retrofit.Builder()
                .baseUrl("https://itunes.apple.com/search?term=$genre&amp;amp;media=music&amp;amp;entity=song&amp;amp;limit=50")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val api = retrofit.create(MusicAPI::class.java)
            return api
        }
    }
//
//    private fun addOkHttpClient(): OkHttpClient {
//        return OkHttpClient.Builder()
//            .addInterceptor(addLoggingInterceptor())
//            .build()
//    }
//
//    private fun addLoggingInterceptor(): Interceptor {
//        val logger = HttpLoggingInterceptor()
//        logger.level = HttpLoggingInterceptor.Level.BASIC
//        return logger
//    }
}

//interface API {
//    // https://itunes.apple.com/
//    // search
//    // ?term=classick&amp;amp;media=music&amp;amp;entity=song&amp;amp;limit=50
//    @GET("search")
//    fun getBooks(
//        @Query("term") query: String,
//        @Query("media") media: String = "music",
//        @Query("entity") entity: String = "song",
//        @Query("limit") maxResults: Int = 50
//    ): Call<MusicResponse>
//}
