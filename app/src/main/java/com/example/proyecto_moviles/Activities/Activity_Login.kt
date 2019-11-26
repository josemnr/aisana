package com.example.proyecto_moviles.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import com.parse.ParseUser
import android.content.Context
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.proyecto_moviles.R
import com.iteso.mx.proyecto_moviles.SESSION_ID_KEY
import com.iteso.mx.proyecto_moviles.SHARED_PREFERENCES

class ActivityLogin : AppCompatActivity() {

    private lateinit var mLogin: Button
    private lateinit var mUserName: EditText
    private lateinit var mPassword: EditText
    private lateinit var mRegisterAlt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mLogin = find(R.id.login_sign_in_button)
        mUserName = find(R.id.login_userName_et)
        mPassword = find(R.id.login_password_et)
        mRegisterAlt = find(R.id.login_bottom_caption)

        mLogin.setOnClickListener {

            ParseUser
                .logInInBackground(
                    mUserName.text.toString(),
                    mPassword.text.toString()
                ) { parseUser, error ->
                    if (error == null) {
                        saveSessionToken(parseUser.sessionToken)

                        //check if admin to change activity
                        startActivity<ActivityMain>()
                        //if normal user
                        //startActivity<ActivityProfile>()
                    } else {
                        Toast.makeText(this, "Login error", Toast.LENGTH_LONG).show()
                    }
                }
        }

        mRegisterAlt.setOnClickListener{
            startActivity<ActivityRegister>()
        }

        /*find<TextView>(R.id.activity_login_tv_forgot_action).setOnClickListener {
            startActivity<ActivityRestorePassword>()
        }*/ //////POSSIBLE FUNCTION TO IMPLEMENT IN THE FUTURE
    }

    fun saveSessionToken(sessionToken: String) {
        val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(SESSION_ID_KEY, sessionToken)
        editor.apply()
    }
}