package com.example.proyecto_moviles.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.jetbrains.anko.find
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import com.example.proyecto_moviles.R
import org.jetbrains.anko.startActivity
import com.example.proyecto_moviles.utils.SESSION_ID_KEY
import com.example.proyecto_moviles.utils.SHARED_PREFERENCES
import com.parse.*



class ActivityLogin : AppCompatActivity() {

    private lateinit var mLogin: Button
    private lateinit var mUserName: EditText
    private lateinit var mPassword: EditText
    private lateinit var mParseTest: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mLogin = find(R.id.login_sign_in_button)
        mUserName = find(R.id.login_userName_et)
        mPassword = find(R.id.login_password_et)
        mParseTest = find(R.id.Parsetest)


        mLogin.setOnClickListener {
            startActivity<ActivityProfile>()
           /*//Prueba de conexión con Parse
            val query = ParseQuery<ParseObject>("Service")
            query.whereEqualTo("objectId", "9BW0ZDWZyx")
            query.addDescendingOrder("createdAt")
            query.getFirstInBackground { obj, e ->
                if (e == null){
                    startActivity<ActivityProfile>()
                    mParseTest.text = obj["objectId"] as String
                } else {
                    error { "Error $e" }  // Log.e using anko
                }
            }

            */


           /* //Login
            ParseUser.logInInBackground(mUserName.text.toString(), mPassword.text.toString()) { parseUser, error ->
                if (error == null) {
                    saveSessionToken(parseUser.sessionToken)
                    startActivity<ActivityProfile>()
                } else {
                    ParseUser.logOut()
                    Toast.makeText(this, "Login error", Toast.LENGTH_LONG).show()
                }
            }
            */
        }
    }

        //////POSSIBLE FUNCTION TO IMPLEMENT IN THE FUTURE

    fun saveSessionToken(sessionToken: String) {
        val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(SESSION_ID_KEY, sessionToken)
        editor.apply()
    }
}
