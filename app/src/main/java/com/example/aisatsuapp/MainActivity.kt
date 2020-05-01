package com.example.aisatsuapp

import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() , View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener (this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button1) {
       showTimePickerDialog()
    }
    }

    private fun showTimePickerDialog(){
            val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener{ view, hour, minute ->
                    Log.d("UI_PARTS", "$hour:$minute")
                    when (hour){
                    in 2..9 -> {textView.text = "おはよう" }
                    in 10..17 -> {textView.text = "こんにちは" }
                    in 18..23,0,1 -> {textView.text = "こんばんは" }
                }
                },
                13, 0, true)
            timePickerDialog.show()

    }
}



//ボタンが押されたら、TimePickerDialogを表示する。
//TimePickerDialogでOK押されたタイミングでwhen式をしようして表示内容を判定する。
//判定内容をTextView.textで設定し画面に表示する。