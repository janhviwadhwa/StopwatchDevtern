package com.abc.stopwatchdevtern


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var countDownTimer: CountDownTimer
    private lateinit var textView: TextView
    private var START_TIME_IN_MILLIS: Long =120000 //2 minute
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textview2)
        countDownTimer = object : CountDownTimer(START_TIME_IN_MILLIS, 1){
            override fun onTick(millisUntilFinished: Long) {
                val minutes =TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                val seconds =TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(minutes)
                val milliseconds = millisUntilFinished % 1000 / 10
                val timeRemaining = String.format("%02d:%02d:%02d",minutes,seconds,milliseconds)
                textView.text = timeRemaining
            }

            override fun onFinish() {
                textView.text = "TIMES UP"
            }
        }
        val startButton = findViewById<Button>(R.id.startCountdown)
        startButton.setOnClickListener{
            countDownTimer.start()
        }
        val stopButton = findViewById<Button>(R.id.stopCountdown)
        stopButton.setOnClickListener{
            countDownTimer.cancel()
        }
    }
}


