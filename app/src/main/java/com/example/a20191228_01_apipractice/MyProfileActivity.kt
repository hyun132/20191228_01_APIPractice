package com.example.a20191228_01_apipractice

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.a20191228_01_apipractice.datas.User
import com.example.a20191228_01_apipractice.utils.ConnectServer
import com.example.a20191228_01_apipractice.utils.ContextUtil
import kotlinx.android.synthetic.main.activity_myprofile.*
import org.json.JSONObject

class MyProfileActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myprofile)

        setValues()
        setupEvents()
    }

    override fun setupEvents() {
        logoutBtn.setOnClickListener {
            val alert = AlertDialog.Builder(mContext)

            alert.setTitle("로그아웃 확인")
            alert.setMessage("정말 로그아웃 하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(mContext,"로그아웃",Toast.LENGTH_SHORT).show()

                ContextUtil.setUserToken(mContext,"")
                var intent = Intent(mContext,LoginActivity::class.java)
                startActivity(intent)

                finish()
            })
            alert.setNegativeButton("취소", null)
            alert.show()
        }
    }

    override fun setValues() {

        ConnectServer.getRequestMyInfo(mContext,object :ConnectServer.JsonResponseHandler{
            override fun onResponse(json: JSONObject) {
                Log.d("내정보 서버 응답",json.toString())

                val code = json.getInt("code")

                runOnUiThread {
                    if (code ==200){
                        val data = json.getJSONObject("data")
                        val user = data.getJSONObject("user")

//                        val userName = user.getString("name")
//                        val userPhoneNum = user.getString("phone")

                        val loginUser = User.getUserFromJson(user)

                        nameTxt.text = loginUser.name
                        phoneTxt.text = loginUser.phoneNum
                        loginIdTxt.text = loginUser.loginId

                    }else{
                        Toast.makeText(mContext,"서버에 문제가 있습니다.",Toast.LENGTH_SHORT).show()
                    }
                }
            }

        })

    }

    }
