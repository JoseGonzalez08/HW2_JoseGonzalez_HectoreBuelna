package com.example.hw2_josegonzalez_hectorbuelna

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.androidplot.util.PixelUtils
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
 * Use the [BarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BarFragment : Fragment(R.layout.fragment_bar) {
    // TODO: Rename and change types of parameters
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val plot = view.findViewById<XYPlot>(R.id.barPlot)
        val domainLabels = arrayOf(1, 2, 3, 4)

        val barRenderer = plot.getRenderer(BarRenderer::class.java)


        val nums1: XYSeries = SimpleXYSeries(
            SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,
            "A",
            4.3, 2.5, 3.5, 4.5
        )
        val nums2: XYSeries = SimpleXYSeries(
            SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,
            "B",
            2.4, 4.4, 1.8, 2.8
        )
        val nums3: XYSeries = SimpleXYSeries(
            SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,
            "C",
            2, 2, 3, 5
        )

        val num1bf = BarFormatter(Color.GREEN, Color.WHITE)
        val num2bf = BarFormatter(Color.RED, Color.WHITE)
        val num3bf = BarFormatter(Color.BLUE, Color.WHITE)

        plot.addSeries(nums1, num1bf)
        plot.addSeries(nums2, num2bf)
        plot.addSeries(nums3, num3bf)

        val renderer = plot.getRenderer(BarRenderer::class.java)
        renderer.setBarOrientation(BarRenderer.BarOrientation.SIDE_BY_SIDE)
        renderer.setBarGroupWidth(BarRenderer.BarGroupWidthMode.FIXED_GAP, 30f)


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
