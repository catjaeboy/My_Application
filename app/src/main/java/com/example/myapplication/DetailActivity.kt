package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity(){

    private lateinit var tvCity: TextView
    private lateinit var tvTemp: TextView
    private lateinit var tvHumidity: TextView
    private lateinit var tvWind: TextView
    private lateinit var tvDesc: TextView
    private lateinit var ivIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tvCity = findViewById(R.id.tvCity)
        tvTemp = findViewById(R.id.tvTemp)
        tvHumidity = findViewById(R.id.tvHumidity)
        tvWind = findViewById(R.id.tvWind)
        tvDesc = findViewById(R.id.tvDesc)
        ivIcon = findViewById(R.id.imagemIcon)

        val weather = intent.getSerializableExtra("weather") as? ClimaResp
        weather?.let {
            tvCity.text = it.name
            tvTemp.text = "${it.main.temp}°C"
            tvHumidity.text = "Umidade: ${it.main.humidity}%"
            tvWind.text = "Vento: ${it.wind.speed} m/s"
            tvDesc.text = it.weather[0].description

            val iconUrl = "https://openweathermap.org/img/wn/${it.weather[0].icon}@2x.png"
            Picasso.get().load(iconUrl).into(ivIcon)
        }
    }
}
