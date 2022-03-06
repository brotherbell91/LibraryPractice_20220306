package com.hyeongjong.librarypractice_20220306

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    fun setupEvents() {
        
        btnCall.setOnClickListener { 
            
//            임시 : CALL 기능 실제 활용 => 앱이 죽을 예정

            val myUri = Uri.parse("tel:010-5555-5555")
            val myIntent = Intent( Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
            
        }

        imgProfile.setOnClickListener {

//            사진 크게 보는 화면으로 넘어가자.

            val myIntent = Intent(this, ViewPhotoActivity::class.java)
            startActivity(myIntent)

        }

    }

    fun setValues() {


    }
}