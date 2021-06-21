package ipca.am.scounting.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import ipca.am.scounting.R
import ipca.am.scounting.helpers.VolleyHelper
import ipca.am.scounting.models.ActivitiesModel
import kotlinx.android.synthetic.main.activity_activities_detail.*
import org.json.JSONObject

class ActivitiesDetailActivity : AppCompatActivity() {


//
//    var activities : MutableList<ActivitiesModel> = ArrayList()
//    private var activitiesAdapter : ActivitiesAdapter? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_activities_detail)
//
//
//
//        activitiesAdapter = ActivitiesAdapter()
//        listView_ActivitiesDetailActivity.adapter = activitiesAdapter
//
//        //var activitiesName : String? = null
//
//
//
//        VolleyHelper.instance.getActivities (this){ response ->
//
//            response?.let {
//
//                for(index in 0 until it.length()){
//
//                    val activitiesJSON : JSONObject = it[index] as JSONObject
//                    activities.add(ActivitiesModel.parseJSON(activitiesJSON))
//                    //
//                }
//                activitiesAdapter?.notifyDataSetChanged()
//            }
//        }
//    }
//
//
//    inner class ActivitiesAdapter : BaseAdapter() {
//
//        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//
//            val rowActivitiesDetail = layoutInflater.inflate(R.layout.activity_activities_row, parent, false)
//
//            val activitiesName      = rowActivitiesDetail.findViewById<TextView>(R.id.txtView_ActivitiesName)
//            val activitiesStartDate = rowActivitiesDetail.findViewById<TextView>(R.id.txtView_ActivitiesDate)
//            val activitiesAddress   = rowActivitiesDetail.findViewById<TextView>(R.id.txtView_ActivitiesAddress)
//            val activitiesCity      = rowActivitiesDetail.findViewById<TextView>(R.id.txtView_ActivitiesCity)
//            val activitiesCountry   = rowActivitiesDetail.findViewById<TextView>(R.id.txtView_ActivitiesCountry)
//
//
//            activitiesName.text         = activities[position].activitiesName
//            activitiesStartDate.text    = activities[position].activitiesStartDate.toString()
//            activitiesAddress.text      = activities[position].activitiesAddress
//            activitiesCity.text         = activities[position].activitiesCity
//            activitiesCountry.text      = activities[position].activitiesCountry
//
//            return rowActivitiesDetail
//        }
//
//        override fun getItem(position: Int): Any {
//
//            return activities[position]
//        }
//
//        override fun getItemId(position: Int): Long {
//
//            return 0
//        }
//
//        override fun getCount(): Int {
//
//            return activities.size
//        }
//    }
}