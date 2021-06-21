package ipca.am.scounting.models

import org.json.JSONObject

class ActivitiesModelV2 {


    var idActivities : Int? = null
    var activitiesName: String? = null
    var activitiesStartDate: String? = null
    var activitiesAddress: String? = null
    var activitiesCity: String? = null
    var activitiesCountry: String? = null
    var activitiesEmail: String? = null
    var activitiesPhone: String? = null

    constructor( idActivities: Int?, activitiesName: String?, activitiesStartDate: String?, activitiesAddress: String?,
                 activitiesCity: String?, activitiesCountry: String?, activitiesEmail: String?, activitiesPhone: String?  ) {
        this.idActivities       = idActivities
        this.activitiesName     = activitiesName
        this.activitiesStartDate = activitiesStartDate
        this.activitiesAddress  = activitiesAddress
        this.activitiesCity     = activitiesCity
        this.activitiesCountry  = activitiesCountry
        this.activitiesEmail    = activitiesEmail
        this.activitiesPhone    = activitiesPhone
    }

    constructor() {

    }

    fun toJson() : JSONObject {
        val jsonObject = JSONObject()

        jsonObject.put("idACTIVITIES", idActivities)
        jsonObject.put("NAME", activitiesName)
        jsonObject.put("START_DATE", activitiesStartDate)
        jsonObject.put("ADDRESS", activitiesAddress)
        jsonObject.put("CITY", activitiesCity)
        jsonObject.put("COUNTRY", activitiesCountry)
        jsonObject.put("EMAIL", activitiesEmail)
        jsonObject.put("PHONE", activitiesPhone)

        return jsonObject
    }

    companion object {

        fun fromJson(jsonObject: JSONObject) : ActivitiesModelV2 {
            val model = ActivitiesModelV2()
            model.idActivities = jsonObject.getInt("idACTIVITIES")
            model.activitiesName = jsonObject.getString("NAME")
            model.activitiesStartDate = jsonObject.getString("START_DATE")
            model.activitiesAddress = jsonObject.getString("ADDRESS")
            model.activitiesCity = jsonObject.getString("CITY")
            model.activitiesCountry = jsonObject.getString("COUNTRY")
            model.activitiesEmail = jsonObject.getString("EMAIL")
            model.activitiesPhone = jsonObject.getString("PHONE")


            return model
        }


    }


}