package ipca.am.scounting.helpers

import android.app.DownloadManager
import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject

class VolleyHelper {

    private var  queue : RequestQueue? = null


    //------------------ Users -----------------------

    fun createNewUser (context : Context, username : String, password : String, email : String,
                        birthdate : String, nationality : String, createUserEvent : ((Boolean) -> Unit)) {

        GlobalScope.launch(Dispatchers.Default) {

            queue = Volley.newRequestQueue(context)

            val jsonObject = JSONObject()

            jsonObject.put("USERNAME", username)
            jsonObject.put("PASSWORD", password)
            jsonObject.put("EMAIL", email)
            jsonObject.put("BIRTHDATE", birthdate)
            jsonObject.put("NATIONALITY", nationality)

            val jsonObjectRequest = object : JsonObjectRequest(

                Method.POST,
                BASE_API + REGISTER,
                jsonObject,
                Response.Listener {

                    createUserEvent.invoke(true)
                    Log.d("VolleyHelper", it.toString())
                },
                Response.ErrorListener {

                    Log.d("VolleyHelper", it.toString())
                }
            ) {

                override fun getHeaders() : MutableMap<String, String> {

                    val map : MutableMap<String, String> = mutableMapOf()

                    map.put("Content-Type", "application/json")

                    return map
                }
            }
            queue!!.add(jsonObjectRequest)
        }

    }


    fun userLogin (context : Context, username : String, password : String, loginEvent : ((Boolean) -> Unit)) {

        GlobalScope.launch(Dispatchers.Default) {

            queue = Volley.newRequestQueue(context)

            val jsonObject = JSONObject()
            jsonObject.put("USERNAME", username)
            jsonObject.put("PASSWORD", password)

            val jsonObjectRequest = JsonObjectRequest(

                Request.Method.POST,
                BASE_API + LOGIN,
                jsonObject,
                Response.Listener {

                    Log.d("VolleyHelper", it.toString())
                    if (it.getBoolean("auth") == true) {

                        token = it.getString("token")
                        loginEvent.invoke(true)
                    } else {

                        loginEvent.invoke(false)
                    }
                },
                Response.ErrorListener {
                    Log.d("VolleyHelper", it.toString())
                    loginEvent.invoke(false)
                }
            )
            queue!!.add(jsonObjectRequest)
        }
    }
// GET SCOUTS----------------------------------------------------
fun getScouts(context: Context, ActivitiesEvent : ((JSONArray?) -> Unit)) {

    GlobalScope.launch(Dispatchers.IO) {

        queue = Volley.newRequestQueue(context)

        val stringRequest = object : StringRequest(

            Method.GET,
            BASE_API + GET_Scouts,
            Response.Listener {

                ActivitiesEvent.invoke(JSONArray(it))
            },
            Response.ErrorListener {

                Log.d("VolleyHelper", it.toString())
                ActivitiesEvent.invoke(null)
            }
        ) {

            override fun getHeaders(): MutableMap<String, String> {

                val map : MutableMap<String, String> = mutableMapOf()
                map.put("Content-Type", "application/json")
                return map
            }
        }

        queue!!.add(stringRequest)
    }
}

//----------------------------------------------------------------------

    companion object{

        const val  BASE_API = "http://192.168.1.86:3000"

        const val REGISTER = "/user/register"
        const val LOGIN = "/user/login"
        const val GET_SCOUTS = "/api/GetScout"




        var token = ""

        private var nInstance : VolleyHelper? = VolleyHelper()
        val instance : VolleyHelper


            @Synchronized get() {

                if (null == nInstance){

                    nInstance = VolleyHelper()
                }
                return nInstance!!
            }
    }
}