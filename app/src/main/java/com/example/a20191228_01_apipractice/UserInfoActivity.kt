package com.example.a20191228_01_apipractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a20191228_01_apipractice.datas.User
import kotlinx.android.synthetic.main.activity_user_info.*

class UserInfoActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        setValues()
        setupEvents()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
        var data = intent.getSerializableExtra("data") as User

        idTxt.text = data.loginId
        phoneTxt.text = data.phoneNum
        nameTxt.text = data.name
        memoTxt.text = data.memo
    }
}
