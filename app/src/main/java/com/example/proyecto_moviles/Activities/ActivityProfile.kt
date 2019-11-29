package com.example.proyecto_moviles.Activities

import android.Manifest
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_moviles.R
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import java.nio.file.Files.find
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.parse.ParseUser
import org.jetbrains.anko.toast
import javax.xml.transform.OutputKeys.VERSION

class ActivityProfile: AppCompatActivity() {
    private lateinit var btnAgendar: Button
    private lateinit var btnLogOut: Button
    private lateinit var ivProfilePic : ImageView
    private lateinit var userNametv : TextView

    @RequiresApi(Build.VERSION_CODES.M)
    @TargetApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val curr_user = ParseUser.getCurrentUser()

        btnAgendar = find(R.id.profile_agenda_btn)
        btnLogOut = find(R.id.profile_change_user_btn)
        ivProfilePic = find(R.id.profile_user_pic)
        userNametv = find(R.id.profile_user_name)

        userNametv.setText(curr_user.username.toString())

        btnAgendar.setOnClickListener {
            Toast.makeText(this, "Selecciona los datos que se piden", Toast.LENGTH_LONG).show()
            startActivity<ActivityAgendar>()
        }

        btnLogOut.setOnClickListener {
            startActivity<ActivityLogin>()
            ParseUser.logOut()
            Toast.makeText(this, "Se ha cerrado tu sesiòn", Toast.LENGTH_LONG).show()
        }

        ivProfilePic.setOnClickListener{
            //Checar permisos
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED){
                    //Denegao, Sí
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                    //PupUp Para el permiso
                    requestPermissions(permissions, PERMISSION_CODE)
                }
                else{
                    //Permiso Concedido
                    pickImageFromGallery()
                }
            }
            else{
                //SO < Marshmallow
                pickImageFromGallery()
            }
        }
    }


    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000
        //Permission code
        private val PERMISSION_CODE = 1001
    }




    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE ->{
                if(grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    pickImageFromGallery()
                }else{
                    Toast.makeText(this, "Permiso denegado", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            Toast.makeText(this, "Tu foto de perfíl ha actualizado", Toast.LENGTH_SHORT).show()
            ivProfilePic.setImageURI(data?.data)
        }
    }



}


