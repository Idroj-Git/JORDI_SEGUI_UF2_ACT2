package com.example.jordis_angela_pianotime

import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private lateinit var soundPool: SoundPool
    // Lista con todos los audios y un ID
    private val soundMap = mutableMapOf<String, Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        soundPool = SoundPool.Builder()
            .setMaxStreams(10)
            .build()

        // Cargar todos los audios en la funcion
        loadAudios()

        // Vincular els ImageButton definits al layout
        bindKeys()

        val keyC2 = findViewById<ImageButton>(R.id.keyC2)
        val keyCS2 = findViewById<ImageButton>(R.id.keyCS2)
        val keyD2 = findViewById<ImageButton>(R.id.keyD2)
        val keyDS2 = findViewById<ImageButton>(R.id.keyDS2)
        val keyE2 = findViewById<ImageButton>(R.id.keyE2)
        val keyF2 = findViewById<ImageButton>(R.id.keyF2)
        val keyFS2 = findViewById<ImageButton>(R.id.keyFS2)
        val keyG2 = findViewById<ImageButton>(R.id.keyG2)
        val keyGS2 = findViewById<ImageButton>(R.id.keyGS2)
        val keyA2 = findViewById<ImageButton>(R.id.keyA2)
        val keyAS2 = findViewById<ImageButton>(R.id.keyAS2)
        val keyB2 = findViewById<ImageButton>(R.id.keyB2)
        val keyC3 = findViewById<ImageButton>(R.id.keyC3)
        val keyCS3 = findViewById<ImageButton>(R.id.keyCS3)
        val keyD3 = findViewById<ImageButton>(R.id.keyD3)
        val keyDS3 = findViewById<ImageButton>(R.id.keyDS3)
        val keyE3 = findViewById<ImageButton>(R.id.keyE3)
        val keyF3 = findViewById<ImageButton>(R.id.keyF3)
        val keyFS3 = findViewById<ImageButton>(R.id.keyFS3)
        val keyG3 = findViewById<ImageButton>(R.id.keyG3)
        val keyGS3 = findViewById<ImageButton>(R.id.keyGS3)
        val keyA3 = findViewById<ImageButton>(R.id.keyA3)
        val keyAS3 = findViewById<ImageButton>(R.id.keyAS3)
        val keyB3 = findViewById<ImageButton>(R.id.keyB3)
        val keyC4 = findViewById<ImageButton>(R.id.keyC4)
        // ... fes-ho amb totes les tecles ...

        // Touch listeners CON funcion
        keyC2.setOnTouchListener { _, event ->
            performClick("C2", event)
        }

        keyCS2.setOnTouchListener { _, event ->
            performClick("CS2", event)
        }

        keyD2.setOnTouchListener { _, event ->
            performClick("D2", event)
        }
        keyDS2.setOnTouchListener { _, event ->
            performClick("DS2", event)
        }

        keyE2.setOnTouchListener { _, event ->
            performClick("E2", event)
        }

        keyF2.setOnTouchListener { _, event ->
            performClick("F2", event)
        }

        keyFS2.setOnTouchListener { _, event ->
            performClick("FS2", event)
        }

        keyG2.setOnTouchListener { _, event ->
            performClick("G2", event)
        }

        keyGS2.setOnTouchListener { _, event ->
            performClick("GS2", event)
        }

        keyA2.setOnTouchListener { _, event ->
            performClick("A2", event)
        }

        keyAS2.setOnTouchListener { _, event ->
            performClick("AS2", event)
        }

        keyB2.setOnTouchListener { _, event ->
            performClick("B2", event)
        }

        keyC3.setOnTouchListener { _, event ->
            performClick("C3", event)
        }

        keyCS3.setOnTouchListener { _, event ->
            performClick("CS3", event)
        }

        keyD3.setOnTouchListener { _, event ->
            performClick("D3", event)
        }

        keyDS3.setOnTouchListener { _, event ->
            performClick("DS3", event)
        }

        keyE3.setOnTouchListener { _, event ->
            performClick("E3", event)
        }

        keyF3.setOnTouchListener { _, event ->
            performClick("F3", event)
        }

        keyFS3.setOnTouchListener { _, event ->
            performClick("FS3", event)
        }

        keyG3.setOnTouchListener { _, event ->
            performClick("G3", event)
        }

        keyGS3.setOnTouchListener { _, event ->
            performClick("GS3", event)
        }

        keyA3.setOnTouchListener { _, event ->
            performClick("A3", event)
        }

        keyAS3.setOnTouchListener { _, event ->
            performClick("AS3", event)
        }

        keyB3.setOnTouchListener { _, event ->
            performClick("B3", event)
        }

        keyC4.setOnTouchListener { _, event ->
            performClick("C4", event)
        }
    }

    private fun performClick(note: String, event: MotionEvent) : Boolean {
        if (event.actionMasked == MotionEvent.ACTION_DOWN ||
            event.actionMasked == MotionEvent.ACTION_POINTER_DOWN) {
            playNote(note)
        }
        return false
    }

    private fun loadAudios(){
        soundMap["C2"] = soundPool.load(this, R.raw.key_c2, 1)
        soundMap["CS2"] = soundPool.load(this, R.raw.key_cs2, 1)
        soundMap["D2"] = soundPool.load(this, R.raw.key_d2, 1)
        soundMap["DS2"] = soundPool.load(this, R.raw.key_ds2, 1)
        soundMap["E2"] = soundPool.load(this, R.raw.key_e2, 1)
        soundMap["F2"] = soundPool.load(this, R.raw.key_f2, 1)
        soundMap["FS2"] = soundPool.load(this, R.raw.key_fs2, 1)
        soundMap["G2"] = soundPool.load(this, R.raw.key_g2, 1)
        soundMap["GS2"] = soundPool.load(this, R.raw.key_gs2, 1)
        soundMap["A2"] = soundPool.load(this, R.raw.key_a2, 1)
        soundMap["AS2"] = soundPool.load(this, R.raw.key_as2, 1)
        soundMap["B2"] = soundPool.load(this, R.raw.key_b2, 1)

        soundMap["C3"] = soundPool.load(this, R.raw.key_c3, 1)
        soundMap["CS3"] = soundPool.load(this, R.raw.key_cs3, 1)
        soundMap["D3"] = soundPool.load(this, R.raw.key_d3, 1)
        soundMap["DS3"] = soundPool.load(this, R.raw.key_ds3, 1)
        soundMap["E3"] = soundPool.load(this, R.raw.key_e3, 1)
        soundMap["F3"] = soundPool.load(this, R.raw.key_f3, 1)
        soundMap["FS3"] = soundPool.load(this, R.raw.key_fs3, 1)
        soundMap["G3"] = soundPool.load(this, R.raw.key_g3, 1)
        soundMap["GS3"] = soundPool.load(this, R.raw.key_gs3, 1)
        soundMap["A3"] = soundPool.load(this, R.raw.key_a3, 1)
        soundMap["AS3"] = soundPool.load(this, R.raw.key_as3, 1)
        soundMap["B3"] = soundPool.load(this, R.raw.key_b3, 1)

        soundMap["C4"] = soundPool.load(this, R.raw.key_c4, 1)
    }

    private fun bindKeys(){

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
