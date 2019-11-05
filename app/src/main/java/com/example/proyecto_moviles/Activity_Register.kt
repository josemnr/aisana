package com.example.proyecto_moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import com.parse.ParseUser
import android.content.Context
import android.widget.EditText
import android.widget.Toast

class Activity_Register : AppCompatActivity() {

    private lateinit var mRegister: Button
    private lateinit var mUserName: EditText
    private lateinit var mPassword: EditText
    private lateinit var mPassword_Confirm: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mRegister = find(R.id.register_sign_in_button)
        mUserName = find(R.id.register_userName_et)
        mPassword = find(R.id.register_password_et)
        mPassword_Confirm = find(R.id.register_confirm_password_et)

        mRegister.setOnClickListener {

            if(mPassword.text.toString() != mPassword_Confirm.text.toString()){
                mPassword_Confirm.text.replace(0,0,"Error, passwords not equal")
                return@setOnClickListener
            }

            ParseUser //REPLACE FOR REGISTER FUNCTION INSTEAD OF LOGIN
                .logInInBackground(
                    mUserName.text.toString(),
                    mPassword.text.toString()
                ) { parseUser, error ->
                    if (error == null) {
                        //saveSessionToken(parseUser.sessionToken)
                        startActivity<ActivityMain>()
                    } else {
                        Toast.makeText(this, "Login error", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }


    //////POSSIBLE FUNCTION TO IMPLEMENT IN THE FUTURE
    /*
    fun saveSessionToken(sessionToken: String) {
        val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(SESSION_ID_KEY, sessionToken)
        editor.apply()
    }*/
}