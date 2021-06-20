package ipca.am.scounting.models

import android.location.Address
import org.json.JSONObject
import java.util.*

class ActivitiesModel {



    var activitiesName: String? = null
    var activitiesStartDate: String? = null
    var activitiesAddress: String? = null
    var activitiesCity: String? = null
    var activitiesCountry: String? = null
    var activitiesEmail: String? = null
    var activitiesPhone: String? = null

    companion object {

        fun parseJSON (jsonArticle : JSONObject) : ActivitiesModel {

            val activities = ActivitiesModel()


            activities.activitiesName    = jsonArticle.getString("NAME")
            activities.activitiesStartDate = jsonArticle.getString("START_DATE")
            activities.activitiesAddress = jsonArticle.getString("ADDRESS")
            activities.activitiesCity    = jsonArticle.getString("CITY")
            activities.activitiesCountry = jsonArticle.getString("COUNTRY")
            activities.activitiesEmail   = jsonArticle.getString("EMAIL")
            activities.activitiesPhone   = jsonArticle.getString("PHONE")

            return activities
        }
    }
}