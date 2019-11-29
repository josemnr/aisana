package com.example.proyecto_moviles.Activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import android.widget.EditText
import android.widget.Toast
import com.example.proyecto_moviles.R
import com.iteso.mx.proyecto_moviles.SESSION_ID_KEY
import com.iteso.mx.proyecto_moviles.SHARED_PREFERENCES
import com.parse.ParseUser
import org.jetbrains.anko.toast

class ActivityRegister : AppCompatActivity(){

    private lateinit var mRegister: Button
    private lateinit var mUserName: EditText
    private lateinit var mPassword: EditText
    private lateinit var mEmail: EditText
    private lateinit var mPasswordConfirm: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mRegister = find(R.id.register_sign_in_button)
        mUserName = find(R.id.register_userName_et)
        mPassword = find(R.id.register_password_et)
        mEmail = find(R.id.register_email_et)
        mPasswordConfirm = find(R.id.register_confirm_password_et)

        mRegister.setOnClickListener {

            if(mPassword.text.toString() != mPasswordConfirm.text.toString()){
                mPasswordConfirm.text.clear()
                toast("Error, passwords fields do not match")
                return@setOnClickListener
            }

            if(mUserName.text.isEmpty() || mEmail.text.isEmpty() || mPassword.text.isEmpty()){
                toast("Error, please fill all fields properly")
                return@setOnClickListener
            }

            val user = ParseUser()

            user.username = mUserName.text.toString()
            user.setPassword(mPassword.text.toString())

            user.signUpInBackground{e ->
                if (e != null) {
                    startActivity<ActivityLogin>()
                } else {
                    saveSessionToken(user.sessionToken)
                    ParseUser.logOut()
                    Toast.makeText(this, "User Register Error", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun saveSessionToken(sessionToken: String) {
        val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(SESSION_ID_KEY, sessionToken)
        editor.apply()
    }
}