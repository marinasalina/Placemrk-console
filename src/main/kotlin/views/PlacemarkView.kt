package org.setu.placemark.console.views

import org.setu.placemark.console.models.PlacemarkStore
import org.setu.placemark.console.models.PlacemarkModel
import org.setu.placemark.console.models.PlacemarkJSONStore

class PlacemarkView {

    fun menu() : Int {

        val option : Int
        val input: String?

        println("MAIN MENU")
        println(" 1. Add Placemark")
        println(" 2. Update Placemark")
        println(" 3. List All Placemarks")
        println(" 4. Search Placemarks")
        println(" 5. Delete Placemark")
        println("-1. Exit")
        println()
        print("Enter Option : ")
        input = readln()
        option = if (input.toIntOrNull() != null && input.isNotEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listPlacemarks(placemarks : PlacemarkJSONStore) {
        println("List All Placemarks")
        println()
        placemarks.logAll()
        println()
    }


    fun showPlacemark(placemark : PlacemarkModel) {
        if(placemark != null)
            println("Placemark Details [ $placemark ]")
        else
            println("Placemark Not Found...")
    }

    fun addPlacemarkData(placemark : PlacemarkModel) : Boolean {

        println()
        print("Enter a Title : ")
        placemark.title = readln()
        print("Enter a Description : ")
        placemark.description = readln()

        return placemark.title.isNotEmpty() && placemark.description.isNotEmpty()
    }

    fun updatePlacemarkData(placemark : PlacemarkModel) : Boolean {

        val tempTitle: String?
        val tempDescription: String?

        if (placemark != null) {
            print("Enter a new Title for [ " + placemark.title + " ] : ")
            tempTitle = readln()
            print("Enter a new Description for [ " + placemark.description + " ] : ")
            tempDescription = readln()

            if (tempTitle.isNotEmpty() && tempDescription.isNotEmpty()) {
                placemark.title = tempTitle
                placemark.description = tempDescription
                return true
            }
        }
        return false
    }

    fun getId() : Long {
        var strId : String? // String to hold user input
        var searchId : Long // Long to hold converted id
        print("Enter id to Search/Update : ")
        strId = readln()
        searchId = if (strId.toLongOrNull() != null && strId.isNotEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }
}
