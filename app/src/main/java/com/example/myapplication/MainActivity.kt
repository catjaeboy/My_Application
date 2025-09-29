package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(){

    private lateinit var etCity: EditText
    private lateinit var btnSearch: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var rvWeather: RecyclerView
    private lateinit var tvError: TextView

    private val weatherList = mutableListOf<ClimaResp>()
    private lateinit var adapter: WeatherAdapter
    private lateinit var api: ClimaAPI
    private val API_KEY = "d185d0fbcecfb65e6b00fac6ebdc7218"

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etCity = findViewById(R.id.cidadeBusc)
        btnSearch = findViewById(R.id.btnBuscar)
        progressBar = findViewById(R.id.progressBar)
        rvWeather = findViewById(R.id.rvWeather)
        tvError = findViewById(R.id.tvError)

        rvWeather.layoutManager = LinearLayoutManager(this)
        adapter = WeatherAdapter(weatherList, this)
        rvWeather.adapter = adapter

        api = RetrofitClient.getRetrofitInstance().create(ClimaAPI::class.java)

        btnSearch.setOnClickListener{
            val city = etCity.text.toString().trim()
            if(city.isNotEmpty()){
                fetchWeather("$city")
            }else{
                Toast.makeText(this, "Digite uma cidade", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun fetchWeather(city: String){
        progressBar.visibility = View.VISIBLE
        tvError.visibility = View.GONE

        val call = api.getWeather(city, API_KEY, "metric", "pt_br")
        call.enqueue(object : Callback<ClimaResp>{
            override fun onResponse(call: Call<ClimaResp>, response: Response<ClimaResp>){
                progressBar.visibility = View.GONE
                if(response.isSuccessful && response.body() != null){
                    weatherList.clear()
                    weatherList.add(response.body()!!)
                    adapter.notifyDataSetChanged()
                }else{
                    tvError.text = "Cidade não encontrada"
                    tvError.visibility = View.VISIBLE
                }
            }

            override fun onFailure(call: Call<ClimaResp>, t: Throwable){
                progressBar.visibility = View.GONE
                tvError.text = "Erro: ${t.message}"
                tvError.visibility = View.VISIBLE
            }
        })
    }
}
