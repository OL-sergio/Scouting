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
import kotlinx.android.synthetic.main.activity_create_scout.*
import kotlinx.android.synthetic.main.activity_create_staff.*
import kotlinx.android.synthetic.main.activity_create_staff.editTextRegisterBirthdate
import kotlinx.android.synthetic.main.activity_create_staff.editTextRegisterCountry
import kotlinx.android.synthetic.main.activity_create_staff.editTextRegisterEmail
import kotlinx.android.synthetic.main.activity_create_staff.editTextRegisterName
import kotlinx.android.synthetic.main.activity_create_staff.editTextRegisterPhone
import java.util.*

class CreateStaff : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_staff)


        btn_BackDetailStaff.setOnClickListener {
            val intent = Intent(this, DetailStaff::class.java)
            startActivity(intent)
        }

        btn_CreateStaff.setOnClickListener {

            if (editTextRegisterName.text.toString() == "" || editTextRegisterBirthdate.text.toString() == ""
                || editTextRegisterEmail.text.toString() == "" || editTextRegisterPhone.text.toString() == ""
                || editTextRegisterPhone.text.toString() == "" || editTextRegisterCountry.text.toString() == "") {

                Toast.makeText(applicationContext,"Preencher todos campos", Toast.LENGTH_SHORT).show()
            }

            else {

                val intentResult = Intent()

                val staffName = findViewById<EditText>(R.id.editTextRegisterName)
                val staffBirthdate = findViewById<EditText>(R.id.editTextRegisterBirthdate)
                val staffEmail = findViewById<EditText>(R.id.editTextRegisterEmail)
                val staffPhone = findViewById<EditText>(R.id.editTextRegisterPhone)
                val staffCountry = findViewById<EditText>(R.id.editTextRegisterCountry)
                val staffCreationDate = Date()


                VolleyHelper.instance.createNewStaff (

                    this@CreateStaff,

                    staffName.text.toString(),
                    staffBirthdate.text.toString(),
                    staffEmail.text.toString(),
                    staffPhone.text.toString(),
                    staffCountry.text.toString(),
                    staffCreationDate) { response ->

                    if (response) {

                        Toast.makeText(applicationContext,"Staff criado", Toast.LENGTH_SHORT).show()

                        val intent = Intent(this, DetailStaff::class.java)


                        startActivity(intent)
                    }

                    else {

                        Toast.makeText(applicationContext,"Erro ao criar Staff", Toast.LENGTH_SHORT).show()
                    }

                    setResult(Activity.RESULT_OK, intentResult)
                    finish()
                }
            }
        }
    }
}