package com.example.cronometro

import android.media.RingtoneManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var txtTiempo:EditText?=null
    private var tvCuentaAtras: TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTiempo= findViewById(R.id.txtTiempo)
        tvCuentaAtras= findViewById(R.id.tvCuentaAtras)

    }
    fun play(view: View){
        var tiempoSegundos= txtTiempo!!.text.toString().toLong()
        var milisegundos=tiempoSegundos * 1000

        object : CountDownTimer(milisegundos, 1000){
            override fun onTick(millisUntilFinished: Long) {

                val tiempoSegundos=(millisUntilFinished/1000).toInt()+1
                tvCuentaAtras!!.text=tiempoSegundos.toString().padStart(2, '0')

            }

            override fun onFinish() {
                val notificaciones= RingtoneManager.getDefaultUri (RingtoneManager.TYPE_RINGTONE)
                val tono= RingtoneManager.getRingtone(this@MainActivity,notificaciones)
                tono.play()
                this.cancel()
            }
        }.start()



    }
}