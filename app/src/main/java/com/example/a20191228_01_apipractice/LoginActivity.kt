package com.example.a20191228_01_apipractice

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.a20191228_01_apipractice.utils.ConnectServer
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {

//        로그인 버튼이 눌리면
//         1. ID 입력이 빈칸이면 "ID"를 입력해주세요 토스트 출력
//        2. pw 입력이 8글자 미만이라면 "비번이 너무 짧습니다" 토스트 출력.
//        3. 둘다 괜찮다면 별개로 분기만 준비.

        loginBtn.setOnClickListener {
            var inputId = idEdt.text.toString()
            var inputPw = pwEdt.text.toString()
            if (inputId == "") {
                Toast.makeText(mContext, "ID를 입력해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (inputPw.length < 8) {
                Toast.makeText(mContext, "비번이 너무 짧습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
//            Toast.makeText(mContext,"정상 입력이라 로그인 시도해야함",Toast.LENGTH_SHORT).show()

            ConnectServer.postRequestLogin(
                mContext,
                inputId,
                inputPw,
                object : ConnectServer.JsonResponseHandler {

                    override fun onResponse(json: JSONObject) {
                        Log.d("서버응답json", json.toString())

//                    서버에서 돌려주는 code가 몇인지 Int 값 확인

                        val code = json.getInt("code")

                        runOnUiThread {
                            //               code : 200 이면 로그인 성공 토스트, code : 200이 아니면 로그인 실패 토스트
                            if (code == 200) {
                                Toast.makeText(mContext, "로그인 성공", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(mContext, "로그인 실패", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                })
        }

    }

    override fun setValues() {

    }

}
