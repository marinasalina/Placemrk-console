package org.setu.placemark.console.models

data class PlacemarkModel(
    var id: Long = 0,
    var title: String = "",
    var description: String = ""
)
interface PlacemarkStore {
    fun findAll(): List<PlacemarkModel>
    fun findOne(id: Long): PlacemarkModel?
    fun create(placemark: PlacemarkModel)
    fun update(placemark: PlacemarkModel)
    fun delete(placemark: PlacemarkModel)
}