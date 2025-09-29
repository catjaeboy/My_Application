package com.example.myapplication

import java.io.Serializable

data class ClimaResp(
    val weather: List<Weather>,
    val main: Main,
    val wind: Wind,
    val name: String
) : Serializable

data class Weather(val main: String, val description: String, val icon: String) : Serializable
data class Main(val temp: Double, val humidity: Int) : Serializable
data class Wind(val speed: Double) : Serializable
