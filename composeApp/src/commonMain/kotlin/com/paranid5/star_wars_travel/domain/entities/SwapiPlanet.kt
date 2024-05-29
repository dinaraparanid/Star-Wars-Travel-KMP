package com.paranid5.star_wars_travel.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SwapiPlanet(
    @SerialName("name") val name: String,
    @SerialName("rotation_period") val rotationPeriod: String,
    @SerialName("orbital_period") val orbitalPeriod: String,
    @SerialName("diameter") val diameter: String,
    @SerialName("climate") val climate: String,
    @SerialName("gravity") val gravity: String,
    @SerialName("terrain") val terrain: String,
    @SerialName("surface_water") val surfaceWater: String,
    @SerialName("population") val population: String,
    @SerialName("edited") val edited: String
)