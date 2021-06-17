package ipca.am.scounting.models

import org.json.JSONObject

class UsersModel {

    var username : String? = null
    var password: String? = null
    var email : String? = null
    var birthdate : String? = null
    var nationality : String? = null


    companion object {

        fun parseJson (jsonArticle : JSONObject): UsersModel {

            val user = UsersModel()

            user.username = jsonArticle.getString("USERNAME")
            user.password = jsonArticle.getString("PASSWORD")
            user.email = jsonArticle.getString("EMAIL")
            user.birthdate = jsonArticle.getString("BIRTHDATE")
            user.nationality = jsonArticle.getString("NATIONALITY")

           return user
        }

    }
}