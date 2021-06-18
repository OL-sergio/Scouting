package ipca.am.scounting.models

import android.location.Address
import org.json.JSONObject
import java.util.*

class ActivitiesModel {


    var idActivities : Int? = null
    var activitiesName: String? = null
    var activitiesStartDate: String? = null
    var activitiesAddress: String? = null
    var activitiesCity: String? = null
    var activitiesCountry: String? = null
    var activitiesEmail: String? = null
    var activitiesPhone: String? = null

    companion object {

        fun parseJSON (jsonArticle : JSONObject) : ActivitiesModel {

            val tournament = ActivitiesModel()

            tournament.idActivities      = jsonArticle.getInt("idACTIVITIES")
            tournament.activitiesName    = jsonArticle.getString("NAME")
            tournament.activitiesStartDate = jsonArticle.getString("START_DATE")
            tournament.activitiesAddress = jsonArticle.getString("ADDRESS")
            tournament.activitiesCity    = jsonArticle.getString("CITY")
            tournament.activitiesCountry = jsonArticle.getString("COUNTRY")
            tournament.activitiesEmail   = jsonArticle.getString("EMAIL")
            tournament.activitiesPhone   = jsonArticle.getString("PHONE")

            return tournament
        }
    }
}