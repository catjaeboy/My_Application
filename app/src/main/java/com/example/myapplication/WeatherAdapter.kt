package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class WeatherAdapter(
    private val weatherList: List<ClimaResp>,
    private val context: Context
) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder{
        val view = LayoutInflater.from(context).inflate(R.layout.item_weather, parent, false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int){
        val item = weatherList[position]
        holder.tvCity.text = item.name
        holder.tvTemp.text = "${item.main.temp}°C"

        val iconUrl = "https://openweathermap.org/img/wn/${item.weather[0].icon}@2x.png"
        Picasso.get().load(iconUrl).into(holder.ivIcon)

        holder.itemView.setOnClickListener{
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("weather", item)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = weatherList.size

    class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvCity: TextView = itemView.findViewById(R.id.tvCity)
        val tvTemp: TextView = itemView.findViewById(R.id.tvTemp)
        val ivIcon: ImageView = itemView.findViewById(R.id.imagemIcon)
    }
}
