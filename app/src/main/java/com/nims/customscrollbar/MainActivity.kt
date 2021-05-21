package com.nims.customscrollbar

import android.os.Bundle
import android.widget.HorizontalScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val scr = findViewById<HorizontalScrollView>(R.id.scr)

        scr.setOnScrollChangeListener { view, scrollX, scrollY, oldScrollX, oldScrollY ->
            val horizontalScrollableWidth = scr.getChildAt(0).measuredWidth - scr.measuredWidth
            val horizontalPercentage = scrollX.toFloat() / horizontalScrollableWidth

            val cl = findViewById<ConstraintLayout>(R.id.c)
            val cs = ConstraintSet()
            cs.clone(cl)
            cs.setHorizontalBias(R.id.thumb, horizontalPercentage)
            cs.applyTo(cl)
        }
    }

}