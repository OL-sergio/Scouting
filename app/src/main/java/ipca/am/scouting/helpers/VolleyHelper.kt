package ipca.am.scouting.helpers

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
import java.time.LocalDate
import java.util.*

class VolleyHelper {

    private var  queue : RequestQueue? = null


    //------------------ Users -----------------------

    fun createNewUser (
        context: Context, username: String, password: String, email: String,
        birthdate: String, nationality: String, creationDate: LocalDate, createUserEvent: ((Boolean) -> Unit)) {

        GlobalScope.launch(Dispatchers.IO) {

            queue = Volley.newRequestQueue(context)

            val jsonObject = JSONObject()

            jsonObject.put("USERNAME", username)
            jsonObject.put("PASSWORD", password)
            jsonObject.put("EMAIL", email)
            jsonObject.put("BIRTHDATE", birthdate)
            jsonObject.put("NATIONALITY", nationality)
            jsonObject.put("CREATION_DATE", creationDate)

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

        GlobalScope.launch(Dispatchers.IO) {

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

    //------------------ Activities -----------------------

    fun getActivities (context: Context, ActivitiesEvent : ((JSONArray?) -> Unit)) {

        GlobalScope.launch(Dispatchers.IO) {

            queue = Volley.newRequestQueue(context)

            val stringRequest = object : StringRequest(

                Method.GET,
                BASE_API + GET_ACTIVITIES,
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


    fun getActivitiesByID (context: Context, ActivitiesID : Int, ActivitiesEvent: ((JSONArray?) -> Unit)) {

        GlobalScope.launch(Dispatchers.IO) {

            queue = Volley.newRequestQueue(context)

            val stringRequest = object : StringRequest(

                Method.GET,
                BASE_API + GET_ACTIVITIES_ID + "/" + ActivitiesID,
                Response.Listener {

                    ActivitiesEvent.invoke(JSONArray(it))
                },
                Response.ErrorListener {

                    Log.d("Volley Helper", it.toString())
                    ActivitiesEvent.invoke(null)
                }
            ) {

                override fun getHeaders(): MutableMap<String, String> {

                    val map : MutableMap<String, String> = mutableMapOf()
                    map.put("Content-Type", "application/json")
                    return map
                }
            }

            queue?.add(stringRequest)
        }
    }

    fun createNewActivities (
        context: Context, activitiesName: String,
        activitiesStartDate: String, activitiesAddress: String, activitiesCity: String,
        activitiesCountry: String, activitiesEmail: String, activitiesPhone: String,
        creationDate: Date, ActivitiesEvent: ((Boolean) -> Unit)) {

        GlobalScope.launch(Dispatchers.Default) {

            queue = Volley.newRequestQueue(context)

            val jsonObject = JSONObject()

            jsonObject.put("NAME", activitiesName)
            jsonObject.put("START_DATE", activitiesStartDate)
            jsonObject.put("ADDRESS", activitiesAddress)
            jsonObject.put("CITY", activitiesCity)
            jsonObject.put("COUNTRY", activitiesCountry)
            jsonObject.put("EMAIL", activitiesEmail)
            jsonObject.put("PHONE", activitiesPhone)
            jsonObject.put("CREATION_DATE", creationDate)

            val jsonObjectRequest = object : JsonObjectRequest(

                Method.POST,
                BASE_API + POST_NEW_ACTIVITIES,
                jsonObject,
                Response.Listener {

                    ActivitiesEvent.invoke(true)
                    Log.d("VolleyHelper", it.toString())
                },
                Response.ErrorListener {
                    Log.d("VolleyHelper", it.toString())
                }
            ) {

                override fun getHeaders(): MutableMap<String, String> {

                    val map : MutableMap<String, String> = mutableMapOf()
                    map.put("Content-Type", "application/json")
                    return map
                }
            }

            queue!!.add(jsonObjectRequest)
        }
    }

    // GET SCOUTS----------------------------------------------------
    fun getScouts(context: Context, ScoutsEvent : ((JSONArray?) -> Unit)) {

        GlobalScope.launch(Dispatchers.IO) {

            queue = Volley.newRequestQueue(context)

            val stringRequest = object : StringRequest(

                Method.GET,
                BASE_API + GET_SCOUTS,
                Response.Listener {

                    ScoutsEvent.invoke(JSONArray(it))
                },
                Response.ErrorListener {

                    Log.d("VolleyHelper", it.toString())
                    ScoutsEvent.invoke(null)
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

    // GET STAFF -----------------------------------------------------------
    fun getStaff(context: Context, StaffEvent : ((JSONArray?) -> Unit)) {

        GlobalScope.launch(Dispatchers.IO) {

            queue = Volley.newRequestQueue(context)

            val stringRequest = object : StringRequest(

                Method.GET,
                BASE_API + GET_STAFF,
                Response.Listener {

                    StaffEvent.invoke(JSONArray(it))
                },
                Response.ErrorListener {

                    Log.d("VolleyHelper", it.toString())
                    StaffEvent.invoke(null)
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
    // GET SCOUTS ID -------------------------------------------------------
    fun getScoutByID (context: Context,
                      ScoutsId : Int,
                      ScoutsEvent: ((JSONArray?) -> Unit)) {

        GlobalScope.launch(Dispatchers.IO) {

            queue = Volley.newRequestQueue(context)

            val stringRequest = object : StringRequest(

                Method.GET,
                BASE_API + GET_SCOUTS_ID + "/" + ScoutsId,
                Response.Listener {

                    ScoutsEvent.invoke(JSONArray(it))
                },
                Response.ErrorListener {

                    Log.d("Volley Helper", it.toString())
                    ScoutsEvent.invoke(null)
                }
            ) {

                override fun getHeaders(): MutableMap<String, String> {

                    val map : MutableMap<String, String> = mutableMapOf()
                    map.put("Content-Type", "application/json")
                    return map
                }
            }

            queue?.add(stringRequest)
        }
    }

//add scout ----------------------------------------------------------------------

    internal fun createNewScout (
        context: Context,
        scoutName: String,
        scoutBirthdate: String,
        scoutEmail: String,
        scoutPhone: String,
        scoutCountry: String,
        scoutCreationDate: Date,
        createScoutEvent: ((Boolean) -> Unit)
    ) {

        GlobalScope.launch(Dispatchers.Default) {

            queue = Volley.newRequestQueue(context)

            val jsonObject = JSONObject()

            jsonObject.put("NAME", scoutName)
            jsonObject.put("BIRTHDATE", scoutBirthdate)
            jsonObject.put("EMAIL", scoutEmail)
            jsonObject.put("PHONE", scoutPhone)
            jsonObject.put("COUNTRY", scoutCountry)
            jsonObject.put("CREATION_DATE", scoutCreationDate)

            val jsonObjectRequest = object : JsonObjectRequest(

                Method.POST,
                BASE_API + POST_SCOUT,
                jsonObject,
                Response.Listener {

                    createScoutEvent.invoke(true)
                    Log.d("VolleyHelper", it.toString())
                },
                Response.ErrorListener {

                    Log.d("VolleyHelper", it.toString())

                    createScoutEvent.invoke(false)

                }
            ) {

                override fun getHeaders(): MutableMap<String, String> {

                    val map : MutableMap<String, String> = mutableMapOf()
                    map.put("Content-Type", "application/json")
                    return map
                }
            }

            queue!!.add(jsonObjectRequest)
        }
    }

    //add staff ----------------------------------------------------------------------
    internal fun createNewStaff (
        context: Context, staffName: String,
        staffBirthdate: String, staffEmail: String, staffPhone: String,
        staffCountry: String, staffCreationDate: Date, createStaffEvent: ((Boolean) -> Unit)
    ) {

        GlobalScope.launch(Dispatchers.Default) {

            queue = Volley.newRequestQueue(context)

            val jsonObject = JSONObject()

            jsonObject.put("NAME", staffName)
            jsonObject.put("BIRTHDATE", staffBirthdate)
            jsonObject.put("COUNTRY", staffCountry)
            jsonObject.put("EMAIL", staffEmail)
            jsonObject.put("PHONE", staffPhone)
            jsonObject.put("CREATION_DATE", staffCreationDate)

            val jsonObjectRequest = object : JsonObjectRequest(

                Method.POST,
                BASE_API + POST_STAFF,
                jsonObject,
                Response.Listener {
                    createStaffEvent.invoke(true)
                    Log.d("VolleyHelper", it.toString())
                },
                Response.ErrorListener {

                    Log.d("VolleyHelper", it.toString())
                    createStaffEvent.invoke(false)

                }
            ) {

                override fun getHeaders(): MutableMap<String, String> {

                    val map : MutableMap<String, String> = mutableMapOf()
                    map.put("Content-Type", "application/json")
                    return map
                }
            }

            queue!!.add(jsonObjectRequest)
        }
    }


    companion object{

        const val  BASE_API = "http://192.168.1.86:3000"

        const val REGISTER = "/user/register"
        const val LOGIN = "/user/login"
        const val GET_ACTIVITIES = "/api/viewActivities"
        const val GET_ACTIVITIES_ID = "/api/viewActivities:id"
        const val POST_NEW_ACTIVITIES = "/api/createActivities"

        const val GET_SCOUTS_ID = "/api/GetScoutID"
        const val GET_SCOUTS = "/api/GetScout"
        const val POST_SCOUT = "/api/PostScout"
        const val POST_STAFF = "/api/PostStaff"
        const val GET_STAFF = "/api/GetStaff"



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