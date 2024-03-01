package com.example.fragment_daelyn_pedroza_tommy_dumouchel



import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.androidplot.xy.SimpleXYSeries
import com.androidplot.xy.XYPlot
import com.androidplot.xy.XYSeries
import java.util.Arrays


class MainActivity : AppCompatActivity() {
    private lateinit var plot: XYPlot
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val barFragment = BarFragment() // create a barFragment object to use for the container
        val lineFragment = LineFragment() //create a lineFragment object to use for calling container

        supportFragmentManager.beginTransaction().apply { // dynamically changes the container view to line fragment
            replace(R.id.fContainer, lineFragment)
            commit()
        }
        findViewById<Button>(R.id.bBar).setOnClickListener { // dynamically changes container view to bar fragment when the Bar button is pressed
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fContainer, barFragment)
                commit()
            }

        }
        findViewById<Button>(R.id.bLine).setOnClickListener {// dynamically changes container view to line fragment when the Line button is pressed
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fContainer, lineFragment)
                commit()
            }
        }
    }
}