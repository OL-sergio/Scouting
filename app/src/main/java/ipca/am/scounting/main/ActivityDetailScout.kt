package ipca.am.scounting.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import ipca.am.scounting.R
import ipca.am.scounting.helpers.VolleyHelper
import ipca.am.scounting.models.ScoutModel
import kotlinx.android.synthetic.main.activity_scout_detail.*
import org.json.JSONObject

class ActivityDetailScout : AppCompatActivity()  {

        var scouts : MutableList<ScoutModel> = ArrayList()
        var scoutAdapter : ScoutAdapter? = null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_scout_detail)


            scoutAdapter = ScoutAdapter()
            listView_ActivityDetailScout.adapter = scoutAdapter


            VolleyHelper.instance.getScouts (this){ response ->

                response?.let {

                    for(index in 0 until it.length()){

                        val activitiesJSON : JSONObject = it[index] as JSONObject
                        scouts.add(ScoutModel.parseJson(activitiesJSON))

                    }
                    scoutAdapter?.notifyDataSetChanged()
                }
            }
        }


        inner class ScoutAdapter : BaseAdapter() {

            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

                val rowActivitiesDetail = layoutInflater.inflate(R.layout.activity_activities_row, parent, false)

                val activitiesName      = rowActivitiesDetail.findViewById<TextView>(R.id.txtView_ActivitiesName)
                val activitiesStartDate = rowActivitiesDetail.findViewById<TextView>(R.id.txtView_ActivitiesDate)
                val activitiesAddress   = rowActivitiesDetail.findViewById<TextView>(R.id.txtView_ActivitiesAddress)
                val activitiesCity      = rowActivitiesDetail.findViewById<TextView>(R.id.txtView_ActivitiesCity)
                val activitiesCountry   = rowActivitiesDetail.findViewById<TextView>(R.id.txtView_ActivitiesCountry)


                activitiesName.text         = scouts[position].activitiesName
                activitiesStartDate.text    = scouts[position].activitiesStartDate.toString()
                activitiesAddress.text      = scouts[position].activitiesAddress
                activitiesCity.text         = scouts[position].activitiesCity
                activitiesCountry.text      = scouts[position].activitiesCountry

                return rowActivitiesDetail
            }


            override fun getItem(position: Int): Any {

                return scouts[position]
            }


            override fun getItemId(position: Int): Long {

                return 0
            }


            override fun getCount(): Int {

                return scouts.size
            }
        }

}