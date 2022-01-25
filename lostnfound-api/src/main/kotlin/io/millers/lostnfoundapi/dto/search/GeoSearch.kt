package io.millers.lostnfoundapi.dto.search

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

data class GeoSearch(val lat: Double, val lon: Double, val range: Double) {

    companion object {
        private const val Separator: String = ";"

        fun of(searchStr: String?): GeoSearch? {
            searchStr ?: return null
            try {
                val split = searchStr.split(Separator).map(String::toDouble)
                return split.takeIf { split.size == 3 }?.let { GeoSearch(it[0], it[1], it[2]) }
            } catch (e: Exception) {
                throw InvalidGeoSearchException(searchStr)
            }
        }
    }
}

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Search string has the form lat,lon,range")
class InvalidGeoSearchException(searchStr: String) :
    RuntimeException("Could not parse geo search string: $searchStr")
