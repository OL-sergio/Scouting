package ipca.am.scounting.models

import org.json.JSONObject

class StaffModel {

    var idStaff : Int? = null
    var name: String? = null
    var birthdate : String? = null
    var country : String? = null
    var email : String? = null
    var phone : Int? = null
    var creationDate : String? = null

    companion object {

        fun parseJson (jsonArticle : JSONObject): StaffModel {

            val Staff = StaffModel()

            Staff.idStaff = jsonArticle.getInt("idSTAFF")
            Staff.name = jsonArticle.getString("NAME")
            Staff.birthdate = jsonArticle.getString("BIRTHDATE")
            Staff.country = jsonArticle.getString("COUNTRY")
            Staff.email = jsonArticle.getString("EMAIL")
            Staff.phone = jsonArticle.getInt("PHONE")
            Staff.creationDate = jsonArticle.getString("CREATION_DATE")

            return Staff
        }

    }
}