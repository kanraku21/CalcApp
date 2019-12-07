package com.example.calcapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.content_main.*
import java.lang.Exception
import android.util.Log

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)


    }

    override fun onClick(v: View?) {

        if (v != null) {
            if (v.id == R.id.button1) {
                plusButton(v)
            } else if (v.id == R.id.button2) {
                minusButton(v)
            } else if (v.id == R.id.button3) {
                multiplyButton(v)
            } else {
                divisionButton(v)
            }


        }

    }


    fun plusButton(v: View) {
        try {
            val intent = Intent(this, SecondActivity::class.java)
            val result =
                editText1.text.toString().toDouble() + editText2.text.toString().toDouble()
            intent.putExtra("calculation", result)
            startActivity(intent)
        } catch (e: Exception) {
            Snackbar.make(v, "数字を入力してください", Snackbar.LENGTH_INDEFINITE)
                .setAction("分かりました") {
                    Log.d("UI_PARTS", "Snackbarをタップした")
                }.show()

        }


    }

    private fun minusButton(v: View) {
        try {
            val intent = Intent(this, SecondActivity::class.java)
            val result = editText1.text.toString().toDouble() - editText2.text.toString().toDouble()
            intent.putExtra("calculation", result)
            startActivity(intent)
        } catch (e: Exception) {

            Snackbar.make(v, "数字を入力してください", Snackbar.LENGTH_INDEFINITE)
                .setAction("分かりました") {
                    Log.d("UI_PARTS", "Snackbarをタップした")
                }.show()
        }
    }


    private fun multiplyButton(v: View) {
        try {
            val intent = Intent(this, SecondActivity::class.java)
            val result = editText1.text.toString().toDouble() * editText2.text.toString().toDouble()
            intent.putExtra("calculation", result)
            startActivity(intent)
        } catch (e: Exception) {

            Snackbar.make(v, "数字を入力してください", Snackbar.LENGTH_INDEFINITE)
                .setAction("分かりました") {
                    Log.d("UI_PARTS", "Snackbarをタップした")
                }.show()
        }
    }


    private fun divisionButton(v: View) = try {
        val intent = Intent(this, SecondActivity::class.java)
        val result = editText1.text.toString().toDouble() / editText2.text.toString().toDouble()

        if (editText2.text.toString().toDouble() == 0.0) {

            Snackbar.make(v, "0では割れません", Snackbar.LENGTH_INDEFINITE)
                .setAction("分かりました") {
                    Log.d("UI_PARTS", "Snackbarをタップした")
                }.show()
        } else {
            intent.putExtra("calculation", result)
            startActivity(intent)
        }
    } catch (e: Exception) {

        Snackbar.make(v, "数字を入力してください", Snackbar.LENGTH_INDEFINITE)
            .setAction("分かりました") {
                Log.d("UI_PARTS", "Snackbarをタップした")
            }.show()
    }

}











