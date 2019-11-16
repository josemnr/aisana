package com.example.proyecto_moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import android.widget.EditText
import android.widget.Toast
import com.parse.ParseException
import com.parse.ParseUser
import com.parse.SignUpCallback
import org.jetbrains.anko.getStackTraceString


class ActivityRegister : AppCompatActivity(){

    private lateinit var mRegister: Button
    private lateinit var mUserName: EditText
    private lateinit var mPassword: EditText
    private lateinit var mPasswordConfirm: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mRegister = find(R.id.register_sign_in_button)
        mUserName = find(R.id.register_userName_et)
        mPassword = find(R.id.register_password_et)
        mPasswordConfirm = find(R.id.register_confirm_password_et)

        mRegister.setOnClickListener {

            if(mPassword.text.toString() != mPasswordConfirm.text.toString()){
                mPasswordConfirm.text.replace(0,0,"Error, passwords not equal")
                return@setOnClickListener
            }

            val user = ParseUser()

            user.username = mUserName.text.toString()
            user.setPassword(mPassword.text.toString())

            user.signUpInBackground{e ->
                if (e != null) {
                    startActivity<ActivityMain>()
                } else {
                    ParseUser.logOut()
                    Toast.makeText(this, "User Register Error", Toast.LENGTH_LONG).show()
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