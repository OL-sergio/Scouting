package ipca.am.scounting.main

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import ipca.am.scounting.R
import ipca.am.scounting.helpers.VolleyHelper
import kotlinx.android.synthetic.main.activity_activities_row.*
import kotlinx.android.synthetic.main.activity_create_activities.*


class CreateActivitiesActivity : AppCompatActivity() {

    var idActivities : Int? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_activities)

        val bundle = intent.extras
        bundle?.let {

            idActivities = it.getInt("idACTIVITIES")

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



                VolleyHelper.instance.createNewActivities (

                    this@CreateActivitiesActivity,
                    idActivities!!.plus(1),
                    activitiesName.text.toString(),
                    activitiesStartDate.text.toString(),
                    activitiesAddress.text.toString(),
                    activitiesCity.text.toString(),
                    activitiesCountry.text.toString(),
                    activitiesEmail.text.toString(),
                    activitiesPhone.text.toString()) { response ->

                    if (response) {

                        Toast.makeText(applicationContext,getString(R.string.activities_created), Toast.LENGTH_SHORT).show()

                        val intent = Intent(this, ActivitiesDetailActivity::class.java)
                        intent.putExtra("Team ID", idActivities!!.toInt())

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