package com.example.a20191228_01_apipractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.a20191228_01_apipractice.R
import com.example.a20191228_01_apipractice.datas.User
import java.util.zip.Inflater

class UserAdapter(context: Context, resId: Int, list:ArrayList<User>):ArrayAdapter<User>(context,resId,list) {

    var mContext = context

//    실수했던부분 ** list 는 어답터의 파라미터로 가져온 것을 넣어줘야 함.
    var mList = list
    var inf = LayoutInflater.from(mContext)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {




        var tempRow = convertView

        tempRow?.let {

        }.let {
            tempRow = inf.inflate(R.layout.user_list_item,null)
        }

        var row = tempRow!!


//         실수했던 부분 ** 리스트에서 값 가져올때 get으로 가져옴
        var data = mList.get(position)

        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val phoneNumTxt = row.findViewById<TextView>(R.id.phoneNumTxt)

        nameTxt.text = data.name
        phoneNumTxt.text="(${data.phoneNum})"

        return row
    }

}