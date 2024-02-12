package com.acad.acadtask1

import android.content.ClipData
import android.content.ClipboardManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //declared edittext, 2 buttons and textview from layout
        val editText = findViewById<EditText>(R.id.wETCpy)
        //declared edittext, 2 buttons and textview from layout
        val edtTxt = findViewById<EditText>(R.id.wETCpy)
        val cpBtn = findViewById<Button>(R.id.wBtnCpy)
        val pasteBtn = findViewById<Button>(R.id.wBtnPaste)
        val txtView = findViewById<TextView>(R.id.wTxtView)

        //define ClipBoard Manager and clipData, where data stored
        val clipBoardMan = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        var clipData : ClipData

        //define copy to clipboard when copy button click

        cpBtn.setOnClickListener {
            if(edtTxt.text.isNullOrBlank() )
                makeToast("Please type something")
            else {
                clipData = ClipData.newPlainText("text",edtTxt.text.toString())
                clipBoardMan.setPrimaryClip(clipData)
                makeToast("new clipboard data stored!")
            }
        }

        pasteBtn.setOnClickListener {
            val clipData = clipBoardMan.primaryClip
            val item = clipData?.getItemAt(0)
            txtView.text=item?.text.toString()
        }


    }
    fun makeToast(msg: String){
        Toast.makeText(applicationContext,msg,Toast.LENGTH_LONG).show()
    }
}