package ipca.am.scouting.main

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import ipca.am.scouting.R
import ipca.am.scouting.helpers.VolleyHelper
import kotlinx.android.synthetic.main.activity_activities_row.*
import kotlinx.android.synthetic.main.activity_create_activities.*
import java.util.*


class CreateActivitiesActivity : AppCompatActivity() {



    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_activities)

        btn_BackDetailActivities.setOnClickListener{
            val intent = Intent(this, ActivitiesDetailActivity::class.java)
            startActivity(intent)
        }

        btn_CreateNewActivities.setOnClickListener {

            if (edtTex_addActivitiesName.text.toString() == "" || edtTex_addActivitiesStartDate.text.toString() == ""
                || edtTex_addActivitiesAddress.text.toString() == "" || edtTex_addActivitiesCity.text.toString() == ""
                || edtTex_addActivitiesCountry.text.toString() == "" || edtTex_addActivitiesEmail.text.toString() == ""
                || edtTex_addActivitiesPhone.text.toString() == "") {

                Toast.makeText(applicationContext,getString(R.string.missing_information), Toast.LENGTH_SHORT).show()
            }

            else {

                val intentResult = Intent()

                val activitiesName      = findViewById<EditText>(R.id.edtTex_addActivitiesName)
                val activitiesStartDate = findViewById<EditText>(R.id.edtTex_addActivitiesStartDate)
                val activitiesAddress = findViewById<EditText>(R.id.edtTex_addActivitiesAddress)
                val activitiesCity = findViewById<EditText>(R.id.edtTex_addActivitiesCity)
                val activitiesCountry = findViewById<EditText>(R.id.edtTex_addActivitiesCountry)
                val activitiesEmail = findViewById<EditText>(R.id.edtTex_addActivitiesEmail)
                val activitiesPhone = findViewById<EditText>(R.id.edtTex_addActivitiesPhone)
                val activitiesCreationDate = Date()



                VolleyHelper.instance.createNewActivities (

                    this@CreateActivitiesActivity,

                    activitiesName.text.toString(),
                    activitiesStartDate.text.toString(),
                    activitiesAddress.text.toString(),
                    activitiesCity.text.toString(),
                    activitiesCountry.text.toString(),
                    activitiesEmail.text.toString(),
                    activitiesPhone.text.toString(),
                    activitiesCreationDate ) { response ->

                    if (response) {

                        Toast.makeText(applicationContext,getString(R.string.activities_created), Toast.LENGTH_SHORT).show()

                        val intent = Intent(this, ActivitiesDetailActivity::class.java)

                        startActivity(intent)
                    }

                    else {

                        Toast.makeText(applicationContext,getString(R.string.failed_to_create_activities), Toast.LENGTH_SHORT).show()
                }

                setResult(Activity.RESULT_OK, intentResult)
                finish()

                }
            }
        }
    }
}
