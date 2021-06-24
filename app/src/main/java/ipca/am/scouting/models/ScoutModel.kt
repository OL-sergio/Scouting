package ipca.am.scouting.models

import org.json.JSONObject

class ScoutModel {


    var name: String? = null
    var birthdate : String? = null
    var country : String? = null
    var email : String? = null
    var phone : Int? = null
    var creationDate : String? = null


    companion object {

        fun parseJson (jsonArticle : JSONObject): ScoutModel {

            val scout = ScoutModel()


            scout.name = jsonArticle.getString("NAME")
            scout.birthdate = jsonArticle.getString("BIRTHDATE")
            scout.country = jsonArticle.getString("COUNTRY")
            scout.email = jsonArticle.getString("EMAIL")
            scout.phone = jsonArticle.getInt("PHONE")
            scout.creationDate = jsonArticle.getString("CREATION_DATE")

            return scout
        }

    }
}