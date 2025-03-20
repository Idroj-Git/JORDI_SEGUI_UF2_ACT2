package com.example.jordis_angela_pianotime

import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    private lateinit var soundPool : SoundPool
    private var soundId : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        soundPool = SoundPool.Builder()
            .setMaxStreams(5)
            .build()


        soundId = soundPool.load(this, R.raw.key_cs_2, 1)

        val key : ImageButton = findViewById(R.id.playButton_cs2)
        key.setOnTouchListener { v, event->
            when (event.action){
                MotionEvent.ACTION_DOWN -> {
                    val streamId = soundPool.play(soundId, 1f, 1f, 0, 0, 1f)
                    v.tag = streamId
                }

                MotionEvent.ACTION_UP ->{
                    val streamId = v.tag as? Int ?: return@setOnTouchListener false
                    soundPool.stop(streamId)
                }
            }
            false
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        soundPool.release()
    }
}