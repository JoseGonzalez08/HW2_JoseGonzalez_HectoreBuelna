package com.example.hw2_josegonzalez_hectorbuelna

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.androidplot.xy.*
import java.text.FieldPosition
import java.text.Format
import java.text.ParsePosition
import java.util.*
import kotlin.math.roundToInt


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LineFragment : Fragment(R.layout.fragment_line) {
    // TODO: Rename and change types of parameters
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_line, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val plot = view.findViewById<XYPlot>(R.id.barPlot)
        val domainLabels = arrayOf(1, 2, 3, 4)
        val nums1 = arrayOf(4.3, 2.5, 3.5, 4.5)
        val nums2 = arrayOf(2.4, 4.4, 1.8, 2.8)
        val nums3 = arrayOf(2, 2, 3, 5)

        val Num1 : XYSeries = SimpleXYSeries(
            listOf(*nums1), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,"A")
        val Num2 : XYSeries = SimpleXYSeries(
            listOf(*nums2), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,"B")
        val Num3 : XYSeries = SimpleXYSeries(
            listOf(*nums3), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,"C")

        val numsFormat = LineAndPointFormatter(Color.BLUE, Color.BLUE,null,null)
        val numsFormat2 = LineAndPointFormatter(Color.GREEN, Color.GREEN, null, null)
        val numsFormat3 = LineAndPointFormatter(Color.RED, Color.RED, null, null)

        plot.addSeries(Num1, numsFormat)
        plot.addSeries(Num2, numsFormat2)
        plot.addSeries(Num3, numsFormat3)


        plot.graph.getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).format = object : Format() {
            override fun format(
                obj: Any,
                toAppendTo: StringBuffer,
                pos: FieldPosition
            ): StringBuffer {
                val i = (obj as Number).toFloat().roundToInt()
                return toAppendTo.append(domainLabels[i])
            }

            override fun parseObject(source: String, pos: ParsePosition): Any? {
                return null
            }
        }
    }
}