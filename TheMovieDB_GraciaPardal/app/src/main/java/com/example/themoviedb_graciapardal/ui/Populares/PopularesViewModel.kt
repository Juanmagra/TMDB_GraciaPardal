package com.example.themoviedb_graciapardal.ui.Populares

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.themoviedb_graciapardal.poko.People
import com.example.themoviedb_graciapardal.poko.ResponsePopular
import com.example.themoviedb_graciapardal.retrofit.TMDBService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PopularesViewModel : ViewModel() {

    private val _people = MutableLiveData<List<People>>()
    private val baseUrl = "https://api.themoviedb.org/3/person/"
    private lateinit var service: TMDBService

    val people: LiveData<List<People>>
        get() = _people

    init {
        _people.value = listOf()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(TMDBService::class.java)
        getPopularList()
    }

    fun getPopularList() {
        service.getPeoplePopular("0","100").enqueue(object: Callback<ResponsePopular> {
            override fun onResponse(
                call: Call<ResponsePopular>,
                response: Response<ResponsePopular>
            ) {
                if(response.code() == 200) {
                    _people.value = response.body()?.results
                }
            }

            override fun onFailure(call: Call<ResponsePopular>, t: Throwable) {
                // Entra cuando falla la comunicación con el servidor
            }
        })
    }

}