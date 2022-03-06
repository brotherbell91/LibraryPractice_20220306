package com.hyeongjong.librarypractice_20220306

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
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

//            권한이 있는지 확인하고 진행.
//            확인 ==> 획특 / 거부인지 상황에 따라 다른 행동.
            
//            PermissionListener를 pl에 넣을 수 없기 때문에 object에 넣어서 담음 class 같은 개념
//            인터페이스는 변수에 넣을 수 없다
            val pl = object : PermissionListener {
//                alt + enter 로 오버라이드 불러옴
                override fun onPermissionGranted() {
//                    권한이 획득 되었을 때 할 행동 적는 함수
                    Toast.makeText(this@MainActivity, "권한이 승인되었습니다.", Toast.LENGTH_SHORT).show()
//                    임시 : CALL 기능 실제 활용 => 앱이 죽을 예정

                    val myUri = Uri.parse("tel:010-5555-5555")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
//                    최종 권한 거부 되었을 떄 할 행동
                    Toast.makeText(this@MainActivity, "권한이 거부되어 전화 연결이 불가능합니다.", Toast.LENGTH_SHORT).show()
                }

            }

//          setPermissions(Manifest.permission.권한이름) Manifest는 반드시 android에서 오는 클래스로 작성
            TedPermission.create()
                .setPermissionListener(pl)
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()

        }

        imgProfile.setOnClickListener {

//            사진 크게 보는 화면으로 넘어가자.

            val myIntent = Intent(this, ViewPhotoActivity::class.java)
            startActivity(myIntent)

        }

    }

    fun setValues() {

//        인터넷상의 이미지를 곧바로 이미지뷰에 반영.


    }
}