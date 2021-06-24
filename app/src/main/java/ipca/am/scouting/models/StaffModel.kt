package ipca.am.scouting.models

import org.json.JSONObject

class StaffModel {


    var name: String? = null
    var birthdate : String? = null
    var country : String? = null
    var email : String? = null
    var phone : Int? = null
    var creationDate : String? = null

    companion object {

        fun parseJson (jsonArticle : JSONObject): StaffModel {

            val staff = StaffModel()


            staff.name = jsonArticle.getString("NAME")
            staff.birthdate = jsonArticle.getString("BIRTHDATE")
            staff.country = jsonArticle.getString("COUNTRY")
            staff.email = jsonArticle.getString("EMAIL")
            staff.phone = jsonArticle.getInt("PHONE")
            staff.creationDate = jsonArticle.getString("CREATION_DATE")

            return staff
        }

    }
}