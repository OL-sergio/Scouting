package ipca.am.scounting.models

import org.json.JSONObject

class ScoutModel {


    var idScout : Int? = null
    var name: String? = null
    var birthdate : String? = null
    var country : String? = null
    var email : String? = null
    var phone : Int? = null
    var creationDate : String? = null


    companion object {

        fun parseJson (jsonArticle : JSONObject): ScoutModel {

            val Scout = ScoutModel()

            Scout.idScout = jsonArticle.getInt("idSCOUT")
            Scout.name = jsonArticle.getString("NAME")
            Scout.birthdate = jsonArticle.getString("BIRTHDATE")
            Scout.country = jsonArticle.getString("COUNTRY")
            Scout.email = jsonArticle.getString("EMAIL")
            Scout.phone = jsonArticle.getInt("PHONE")
            Scout.creationDate = jsonArticle.getString("CREATION_DATE")

            return Scout
        }

    }
}