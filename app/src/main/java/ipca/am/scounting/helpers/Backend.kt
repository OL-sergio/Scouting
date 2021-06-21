package ipca.am.scounting.helpers

import android.graphics.BitmapFactory
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import androidx.navigation.Navigation.findNavController
import ipca.am.scounting.R
import ipca.am.scounting.models.ActivitiesModelV2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.*

class Backend {

/*
    lateinit var  editText   : EditText
    val BASE_AIP = "http://192.168.1.86:3000"

    fun getAllActivities(endpoint : String, callback: ((JSONObject)->Unit)?) {
        GlobalScope.launch(Dispatchers.IO) {
            val client = OkHttpClient()
            val activities = ActivitiesModelV2(
                editText.text.toString(),
                editText.text.toString(),
                editText.text.toString(),
                editText.text.toString(),
                editText.text.toString(),
                editText.text.toString(),
                editText.text.toString(),
                editText.text.toString()
            )

            val requestBody = RequestBody.create(
                "application/json".toMediaTypeOrNull(),
                activities.toJson().toString()
            )
            Log.d("scounting", activities.toJson().toString())
            val request = Request.Builder()
                .url(BASE_AIP + "/api/cavalos")
                .post(requestBody)
                .build()
            client.newCall(request).execute().use { response ->
                Log.d("scounting", response.message)
                GlobalScope.launch(Dispatchers.Main) {
                    if (response.message == "OK") {
                        findNavController().popBackStack()
                    }
                }
            }
        }
/*
    fun getImageFromUrl( url:String , imageView: ImageView) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val input = URL(url).openStream()
                val bitmap = BitmapFactory.decodeStream(input)
                GlobalScope.launch(Dispatchers.Main) {
                    imageView.setImageBitmap(bitmap)
                }
            }catch (e: Exception) {
                println(e.localizedMessage)
                GlobalScope.launch(Dispatchers.Main) {
                    imageView.setImageResource(R.mipmap.icon_article)
                }
            }

        }
    }*/

    }*/
}