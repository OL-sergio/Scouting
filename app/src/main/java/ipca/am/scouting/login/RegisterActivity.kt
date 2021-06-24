package ipca.am.scouting.login

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import ipca.am.scouting.R
import ipca.am.scouting.R.string.registry_confirmed
import ipca.am.scouting.helpers.VolleyHelper
import kotlinx.android.synthetic.main.activity_register.*
import java.time.LocalDate

class RegisterActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        findViewById<Button>(R.id.btn_RegisterCreateUser).setOnClickListener {
            registerUer()

        }

        findViewById<TextView>(R.id.txtView_GoToLogin).setOnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.txtView_GoToLoginUser).setOnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun registerUer() {

        val username : String = edtTex_RegisterUsername.text.toString()
        val email : String = edtTex_RegisterEmail.text.toString()
        val password : String = edtTex_RegisterPassword.text.toString()
        val birthdate : String = edtTex_RegisterBirthdate.text.toString()
        val nationality : String = edtTex_RegisterNationality.text.toString()
        val creationDate = LocalDate.now()


        if (username == ""){
            Toast.makeText(this@RegisterActivity, "Please write username.", Toast.LENGTH_SHORT).show()
        }
        else if (email == ""){
            Toast.makeText(this@RegisterActivity, "Please write email.", Toast.LENGTH_SHORT).show()
        }
        else if (password == ""){
            Toast.makeText(this@RegisterActivity, "Please write password.", Toast.LENGTH_SHORT).show()
        }
        else if (birthdate == ""){
            Toast.makeText(this@RegisterActivity, "Please write birthdate.", Toast.LENGTH_SHORT).show()
        }
        else if (nationality == ""){
            Toast.makeText(this@RegisterActivity, "Please write nationality.", Toast.LENGTH_SHORT).show()
        }
        else{

            VolleyHelper.instance.createNewUser (

                this@RegisterActivity,
                username, password,
                email, birthdate,
                nationality, creationDate   ) {

                if (it) {

                    val intent = Intent(this, LoginActivity::class.java)
                    Toast.makeText(applicationContext, getString(registry_confirmed), Toast.LENGTH_LONG).show()
                    startActivity(intent)
                }
                else {

                    Toast.makeText(applicationContext,getString(R.string.failed_registration),
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
