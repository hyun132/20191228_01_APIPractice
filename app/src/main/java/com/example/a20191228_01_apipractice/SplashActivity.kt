package com.example.a20191228_01_apipractice

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.a20191228_01_apipractice.utils.ContextUtil

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        setValues()
        setupEvents()
    }


    override fun setupEvents() {

    }

    override fun setValues() {
        openProperActivity()


    }

    fun openProperActivity() {
        Handler().postDelayed(Runnable {
            if (ContextUtil.getUserToken(mContext) == "") {
//            로그인 토큰이 저장되지 않았다 => 새로 로그인 할 필요가 있다.

                val intent = Intent(mContext, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
//            로그인 토큰이 빈칸이 아니다 => 저장된 토큰이 있다.
//            로그인 화면이 아니라, 메인화면으로 보내주자

                val intent = Intent(mContext, MyProfileActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 1500)
    }

}
