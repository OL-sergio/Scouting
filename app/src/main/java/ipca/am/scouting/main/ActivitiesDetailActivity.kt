package ipca.am.scouting.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import ipca.am.scouting.R
import ipca.am.scouting.helpers.VolleyHelper
import ipca.am.scouting.login.LoginActivity
import ipca.am.scouting.models.ActivitiesModel
import kotlinx.android.synthetic.main.activity_activities_detail.*
import org.json.JSONObject

class ActivitiesDetailActivity : AppCompatActivity() {



    var activities : MutableList<ActivitiesModel> = ArrayList()
    private var activitiesAdapter : ActivitiesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activities_detail)



        activitiesAdapter = ActivitiesAdapter()
        listView_ActivitiesDetailActivity.adapter = activitiesAdapter





        VolleyHelper.instance.getActivities (this){ response ->

            response?.let {

                for(index in 0 until it.length()){

                    val activitiesJSON : JSONObject = it[index] as JSONObject
                    activities.add(ActivitiesModel.parseJSON(activitiesJSON))

                }
                activitiesAdapter?.notifyDataSetChanged()
            }
        }

        findViewById<TextView>(R.id.txtView_GoToCreateActivities).setOnClickListener {

            val intent = Intent(this, CreateActivitiesActivity::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.txtView_GoToScounting).setOnClickListener {

            val intent = Intent(this, DetailScout::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.txtView_GoToStaff).setOnClickListener {

            val intent = Intent(this, DetailStaff::class.java)
            startActivity(intent)

        }
    }


    inner class ActivitiesAdapter : BaseAdapter() {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val rowActivitiesDetail = layoutInflater.inflate(R.layout.activity_activities_row, parent, false)

            val activitiesName      = rowActivitiesDetail.findViewById<TextView>(R.id.txtView_ActivitiesName)
            val activitiesStartDate = rowActivitiesDetail.findViewById<TextView>(R.id.txtView_ActivitiesDate)
            val activitiesAddress   = rowActivitiesDetail.findViewById<TextView>(R.id.txtView_ActivitiesAddress)
            val activitiesCity      = rowActivitiesDetail.findViewById<TextView>(R.id.txtView_ActivitiesCity)
            val activitiesCountry   = rowActivitiesDetail.findViewById<TextView>(R.id.txtView_ActivitiesCountry)


            activitiesName.text         = activities[position].activitiesName
            activitiesStartDate.text    = activities[position].activitiesStartDate.toString()
            activitiesAddress.text      = activities[position].activitiesAddress
            activitiesCity.text         = activities[position].activitiesCity
            activitiesCountry.text      = activities[position].activitiesCountry

            return rowActivitiesDetail
        }

        override fun getItem(position: Int): Any {

            return activities[position]
        }

        override fun getItemId(position: Int): Long {

            return 0
        }

        override fun getCount(): Int {

            return activities.size
        }
    }
}