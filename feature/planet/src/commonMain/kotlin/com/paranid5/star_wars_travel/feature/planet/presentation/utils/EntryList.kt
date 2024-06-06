package com.paranid5.star_wars_travel.feature.planet.presentation.utils

import androidx.compose.runtime.Composable
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.atmosphere
import com.paranid5.star_wars_travel.core.resources.climate
import com.paranid5.star_wars_travel.core.resources.diameter
import com.paranid5.star_wars_travel.core.resources.fauna
import com.paranid5.star_wars_travel.core.resources.flora
import com.paranid5.star_wars_travel.core.resources.government
import com.paranid5.star_wars_travel.core.resources.gravity
import com.paranid5.star_wars_travel.core.resources.languages
import com.paranid5.star_wars_travel.core.resources.major_cities
import com.paranid5.star_wars_travel.core.resources.moons
import com.paranid5.star_wars_travel.core.resources.native_spec
import com.paranid5.star_wars_travel.core.resources.orbital_period
import com.paranid5.star_wars_travel.core.resources.other_spec
import com.paranid5.star_wars_travel.core.resources.planet_class
import com.paranid5.star_wars_travel.core.resources.population
import com.paranid5.star_wars_travel.core.resources.region
import com.paranid5.star_wars_travel.core.resources.rotation_period
import com.paranid5.star_wars_travel.core.resources.sector
import com.paranid5.star_wars_travel.core.resources.surface_water
import com.paranid5.star_wars_travel.core.resources.system
import com.paranid5.star_wars_travel.core.resources.terrain
import com.paranid5.star_wars_travel.core.resources.trade_routes
import com.paranid5.star_wars_travel.domain.use_case.prettifyNumber
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.AstroInfoUiState
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.PhysInfoUiState
import com.paranid5.star_wars_travel.feature.planet.presentation.ui_state.SocInfoUiState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun AstroInfoUiState.toEntryList() =
    persistentListOf(
        stringResource(Res.string.region) to region.toImmutableList(),
        sector?.let { stringResource(Res.string.sector) to persistentListOf(it) },
        system?.let { stringResource(Res.string.system) to persistentListOf(it) },
        moons.takeIf { it > 0 }?.let {
            stringResource(Res.string.moons) to persistentListOf(it.toString())
        },
        stringResource(Res.string.rotation_period) to persistentListOf(rotationPeriod.toString()),
        stringResource(Res.string.orbital_period) to persistentListOf(orbitalPeriod.toString()),
        stringResource(Res.string.trade_routes) to tradeRoutes.toImmutableList()
    ).filterNotNullOrEmpty()

@Composable
internal fun PhysInfoUiState.toEntryList() =
    persistentListOf(
        planetClass?.let { stringResource(Res.string.planet_class) to persistentListOf(it) },
        stringResource(Res.string.climate) to persistentListOf(climate),
        diameter.takeIf { it > 0 }?.let {
            stringResource(Res.string.diameter) to persistentListOf(prettifyNumber(it.toString()))
        },
        stringResource(Res.string.gravity) to persistentListOf(gravity),
        atmosphere?.let { stringResource(Res.string.atmosphere) to persistentListOf(it) },
        stringResource(Res.string.terrain) to persistentListOf(terrain),
        stringResource(Res.string.surface_water) to persistentListOf(surfaceWater.toString()),
        stringResource(Res.string.flora) to flora.toImmutableList(),
        stringResource(Res.string.fauna) to fauna.toImmutableList()
    ).filterNotNullOrEmpty()

@Composable
internal fun SocInfoUiState.toEntryList() =
    persistentListOf(
        population.takeIf { it > 0 }?.let {
            stringResource(Res.string.population) to persistentListOf(prettifyNumber(it.toString()))
        },
        stringResource(Res.string.native_spec) to nativeSpecies.toImmutableList(),
        stringResource(Res.string.other_spec) to otherSpecies.toImmutableList(),
        stringResource(Res.string.languages) to primaryLanguages.toImmutableList(),
        government?.let { stringResource(Res.string.government) to persistentListOf(it) },
        stringResource(Res.string.major_cities) to majorCities.toImmutableList()
    ).filterNotNullOrEmpty()

private fun ImmutableList<Pair<String, ImmutableList<String>>?>.filterNotNullOrEmpty() =
    filterNotNull().filter { it.second.isNotEmpty() }.toImmutableList()