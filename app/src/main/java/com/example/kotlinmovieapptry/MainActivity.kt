package com.example.kotlinmovieapptry

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmovieapptry.adapters.MovieAdapter
import com.example.kotlinmovieapptry.api.APIClient
import com.example.kotlinmovieapptry.api.ApiInterface
import com.example.kotlinmovieapptry.model.DataItem
import com.example.kotlinmovieapptry.model.ResponseMovieList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: MovieAdapter
    private var prodlist: ArrayList<DataItem?>? = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvMovies)
        recyclerAdapter = MovieAdapter(this, prodlist )
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter



        getQuotes();
    }

    private fun getQuotes() {
        val client = APIClient().getRetrofitClient().create(ApiInterface::class.java)
        client.getQuotes().enqueue(
            object: Callback<ResponseMovieList> {
                override fun onResponse(
                    call: Call<ResponseMovieList>,
                    response: Response<ResponseMovieList>
                ) {

                    if(response.isSuccessful){
                        prodlist?.clear()
                        response.body()?.data?.let { prodlist?.addAll(it) }
                        recyclerAdapter.notifyDataSetChanged()

                    }
                }

                override fun onFailure(call: Call<ResponseMovieList>, t: Throwable) {
                    Log.d("ee",t.message.toString())
                }

            })
    }

}
