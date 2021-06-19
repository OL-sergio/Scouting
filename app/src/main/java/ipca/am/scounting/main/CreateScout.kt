package ipca.am.scounting.main

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import ipca.am.scounting.R
import java.time.LocalDateTime
import ipca.am.scounting.helpers.VolleyHelper
import kotlinx.android.synthetic.main.activity_create_activities.*
import kotlinx.android.synthetic.main.activity_scouts_row.*
import kotlinx.android.synthetic.main.activity_create_scout.*

class CreateScout : AppCompatActivity() {
    var idScout : Int? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_scout)



    val bundle = intent.extras
    bundle?.let {

        idScout = it.getInt("idSCOUT")

    }



        btn_CreateScout.setOnClickListener {

        if (edtTex_RegisterName.text.toString() == "" || edtTex_RegisterUsername.text.toString() == ""
            || edtTex_RegisterBirthdate.text.toString() == "" || edtTex_RegisterEmail.text.toString() == ""
            || edtTex_RegisterPhone.text.toString() == "" || edtTex_RegisterPhone.text.toString() == ""
            || edtTex_RegisterCountry.text.toString() == "") {

            Toast.makeText(applicationContext,"Preencher todos campos", Toast.LENGTH_SHORT).show()
        }

        else {

            val intentResult = Intent()

            val scoutName      = findViewById<EditText>(R.id.edtTex_addActivitiesName)
            val scoutUserName = findViewById<EditText>(R.id.edtTex_addActivitiesStartDate)
            val scoutBirthdate = findViewById<EditText>(R.id.edtTex_addActivitiesAddress)
            val scoutEmail = findViewById<EditText>(R.id.edtTex_addActivitiesCountry)
            val scoutPhone = findViewById<EditText>(R.id.edtTex_addActivitiesEmail)
            val scoutCountry = findViewById<EditText>(R.id.edtTex_addActivitiesPhone)
            val scoutCreationDate = LocalDateTime.now()


            VolleyHelper.instance.createNewScout (

                this@CreateScout,
                idScout!!.plus(1),
                scoutName.text.toString(),
                scoutUserName.text.toString(),
                scoutBirthdate.text.toString(),
                scoutEmail.text.toString(),
                scoutPhone.text.toString(),
                scoutCountry.text.toString(),
                scoutCreationDate) { response ->

                if (response) {

                    Toast.makeText(applicationContext,"Scout criado", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, ActivityDetailScout::class.java)
                    intent.putExtra("Scout ID", idScout!!.toInt())

                    startActivity(intent)
                }

                else {

                    Toast.makeText(applicationContext,"Erro ao criar Scout", Toast.LENGTH_SHORT).show()
                }

                setResult(Activity.RESULT_OK, intentResult)
                finish()
            }
        }
    }
}




}