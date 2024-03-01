package com.example.fragment_daelyn_pedroza_tommy_dumouchel

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.androidplot.xy.BarFormatter
import com.androidplot.xy.BarRenderer
import com.androidplot.xy.BoundaryMode
import com.androidplot.xy.LineAndPointFormatter
import com.androidplot.xy.PointLabelFormatter
import com.androidplot.xy.SimpleXYSeries
import com.androidplot.xy.StepMode
import com.androidplot.xy.XYPlot
import com.androidplot.xy.XYSeries
import java.util.Arrays


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LineFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_line, container, false) // store the inflater to return the view at the end of this block
        val plot = rootView.findViewById<XYPlot>(R.id.plot) //store the plot from our xml file to be modified and displayed

        // Initialize the plot
        plot.setTitle("My Line Graph") // sets the graph title
        plot.setRangeLabel("Values")  // sets the y axis label



        val group1Data = arrayOf<Number>(0.0, (4.3),(2.5),3.5,4.5) // create an array that holds the values of series a, (0.0 is for formatting purposes)

        val group2Data = arrayOf<Number>(0.0, (2.4), // create an array that holds the values of series b, (0.0 is for formatting purposes)
            (4.4),
            (1.8),
            (2.8))


        val group3Data = arrayOf<Number>(0.0,(2), // create an array that holds the values of series a, (0.0 is for formatting purposes)
            (2),
            (3),
            (5))

        val group1Series: XYSeries = SimpleXYSeries(    //create a series that will be displayed on the graph using the a array we created as data points
            listOf(* group1Data),SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,"a"
        )

        val group2Series: XYSeries = SimpleXYSeries(    //create a series that will be displayed on the graph using the b array we created as data points
            listOf(* group2Data),SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,"b"
        )
        val group3Series: XYSeries = SimpleXYSeries(    //create a series that will be displayed on the graph using the c array we created as data points
            listOf(* group3Data),SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,"c"
        )

        val group1Formatter = LineAndPointFormatter(Color.BLUE, Color.WHITE, null, null) //create a formatter that determines the formatting of a series. This one is for series a
        val group2Formatter = LineAndPointFormatter(Color.RED, Color.WHITE, null, null) //create a formatter that determines the formatting of a series. This one is for series b
        val group3Formatter = LineAndPointFormatter(Color.GREEN, Color.WHITE, null, null) //create a formatter that determines the formatting of a series. This one is for series c


        plot.addSeries(group1Series, group1Formatter) //now that we have our series created using our data points in the arrays we made we can use our formatters to add the series to our plot. this line plots series a
        plot.addSeries(group2Series, group2Formatter) //this line plots series b
        plot.addSeries(group3Series, group3Formatter) //this line plots series c

        plot.setDomainStep(StepMode.INCREMENT_BY_VAL, 1.0) //sets the labels of the domain to increment by values of 1
        plot.setDomainBoundaries(1,4, BoundaryMode.FIXED) //sets the lower boundary/origin to be 1, and the upper boundary of the graph to 4
        plot.setRangeBoundaries(0,6, BoundaryMode.FIXED) //sets the rangees boundary to be between 0 and 6
        return rootView //returns the view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LineFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LineFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}