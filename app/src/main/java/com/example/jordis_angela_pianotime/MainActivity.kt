package com.example.jordis_angela_pianotime

import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private lateinit var soundPool: SoundPool
    // Guardem els IDs dels sons per cada nota
    private val soundMap = mutableMapOf<String, Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar SoundPool per a sons de baixa latència
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        soundPool = SoundPool.Builder()
            .setMaxStreams(10)
            .setAudioAttributes(audioAttributes)
            .build()

        // Carregar les notes a la carpeta res/raw
        soundMap["C2"] = soundPool.load(this, R.raw.key_c2, 1)
        soundMap["CS2"] = soundPool.load(this, R.raw.key_cs2, 1)
        soundMap["D2"] = soundPool.load(this, R.raw.key_d2, 1)
        // ... continua amb la resta de notes fins a C4 ...

        // Vincular els ImageButton definits al layout
        val keyC2 = findViewById<ImageButton>(R.id.key_C2)
        val keyCs2 = findViewById<ImageButton>(R.id.key_CS2)
        val keyD2 = findViewById<ImageButton>(R.id.key_D2)
        // ... fes-ho amb totes les tecles ...

        // Assignar el listener per reproduir la nota quan es prem la tecla
        keyC2.setOnTouchListener { _, event ->
            if (event.actionMasked == MotionEvent.ACTION_DOWN ||
                event.actionMasked == MotionEvent.ACTION_POINTER_DOWN) {
                playNote("C2")
                true
            } else {
                false
            }
        }

        keyCs2.setOnTouchListener { _, event ->
            if (event.actionMasked == MotionEvent.ACTION_DOWN ||
                event.actionMasked == MotionEvent.ACTION_POINTER_DOWN) {
                playNote("CS2")
                true
            } else {
                false
            }
        }

        keyD2.setOnTouchListener { _, event ->
            if (event.actionMasked == MotionEvent.ACTION_DOWN ||
                event.actionMasked == MotionEvent.ACTION_POINTER_DOWN) {
                playNote("D2")
                true
            } else {
                false
            }
        }

        // Repeteix aquest patró per a totes les tecles fins a C4
    }

    /**
     * Reprodueix la nota corresponent.
     */
    private fun playNote(note: String) {
        val soundId = soundMap[note] ?: return
        // Reproduïm la nota sense loop: la mostra es reprodueix fins al final i s'allibera sola
        soundPool.play(soundId, 1f, 1f, 1, 0, 1f)
    }

    /**
     * Alliberar recursos quan l'activitat es destrueix.
     */
    override fun onDestroy() {
        super.onDestroy()
        soundPool.release()
    }
}
