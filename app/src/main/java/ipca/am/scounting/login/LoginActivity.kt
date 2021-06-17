package ipca.am.scounting.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import ipca.am.scounting.R
import ipca.am.scounting.helpers.VolleyHelper
import ipca.am.scounting.main.ActivitiesActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.edtTex_LoginUsername)
        val password = findViewById<EditText>(R.id.edtTex_LoginPassword)

        btn_loginUser.setOnClickListener {

            VolleyHelper.instance.userLogin(

                this@LoginActivity,
                username.text.toString(),
                password.text.toString()) {

                if (it) {

                    val intent = Intent(this, ActivitiesActivity::class.java)
                    intent.putExtra("Username", username.text.toString())
                    startActivity(intent)
                }
                else {

                    Toast.makeText(applicationContext,getString(R.string.incorrect_login), Toast.LENGTH_SHORT).show()
                }
            }
        }

      txtView_GoToCreateNewUser.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        txtView_NewUser.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
                /*
               recoverPasswordClickableTextView.setOnClickListener {

                   val intent = Intent(this, RecoverPasswordActivity::class.java)
                   startActivity(intent)
               }*/
    }
}

