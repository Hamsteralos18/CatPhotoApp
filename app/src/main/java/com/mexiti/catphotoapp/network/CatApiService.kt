package com.mexiti.catphotoapp.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.thecatapi.com/"

//Visita la pagina y la adecua para extraer la informacion y nos da el JISON
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

//Solo espero el puro JASON
interface CatApiService{
    @GET("v1/images/search?limit=10")
    suspend fun getPhotos():String
}

//Cada que haga una repeticion no se haga una instancia nueva. Video de Face un mas de un click no genera nuevo video
//::class.java es vas a ensamblar la cadena creada, no necesitas compilar varias veces
object CatApi{
    val retrofiService: CatApiService by lazy {
        retrofit.create(CatApiService::class.java)
    }
}