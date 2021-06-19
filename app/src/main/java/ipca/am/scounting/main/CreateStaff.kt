package ipca.am.scounting.main

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import ipca.am.scounting.R
import ipca.am.scounting.helpers.VolleyHelper
import kotlinx.android.synthetic.main.activity_create_staff.*
import java.time.LocalDateTime

class CreateStaff : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_staff)


        btn_CreateStaff.setOnClickListener {

            if (edtTex_RegisterName.text.toString() == "" || edtTex_RegisterBirthdate.text.toString() == ""
                || edtTex_RegisterEmail.text.toString() == "" || edtTex_RegisterPhone.text.toString() == ""
                || edtTex_RegisterPhone.text.toString() == "" || edtTex_RegisterCountry.text.toString() == "") {

                Toast.makeText(applicationContext,"Preencher todos campos", Toast.LENGTH_SHORT).show()
            }

            else {

                val intentResult = Intent()

                val staffName = findViewById<EditText>(R.id.txtView_StaffName)
                val staffBirthdate = findViewById<EditText>(R.id.txtView_StaffBirthdate)
                val staffEmail = findViewById<EditText>(R.id.txtView_StaffCountry)
                val staffPhone = findViewById<EditText>(R.id.txtView_StaffEmail)
                val staffCountry = findViewById<EditText>(R.id.txtView_StaffPhone)
                val staffCreationDate = LocalDateTime.now()


                VolleyHelper.instance.createNewStaff (

                    this@CreateStaff,
                    idStaff!!.plus(1),
                    staffName.text.toString(),
                    staffBirthdate.text.toString(),
                    staffEmail.text.toString(),
                    staffPhone.text.toString(),
                    staffCountry.text.toString(),
                    staffCreationDate) { response ->

                    if (response) {

                        Toast.makeText(applicationContext,"Scout criado", Toast.LENGTH_SHORT).show()

                        val intent = Intent(this, ActivityDetailScout::class.java)
                        intent.putExtra("Scout ID", idStaff!!.toInt())

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