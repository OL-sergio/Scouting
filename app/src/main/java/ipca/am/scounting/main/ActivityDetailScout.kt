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

                val rowScoutDetail = layoutInflater.inflate(R.layout.activity_scouts_row, parent, false)

                val scoutName      = rowScoutDetail.findViewById<TextView>(R.id.txtView_ScoutName)
                val scoutBirthdate      = rowScoutDetail.findViewById<TextView>(R.id.txtView_ScoutBirthdate)
                val scoutPhone = rowScoutDetail.findViewById<TextView>(R.id.txtView_ScoutPhone)
                val scoutEmail   = rowScoutDetail.findViewById<TextView>(R.id.txtView_ScoutEmail)
                val scoutCountry   = rowScoutDetail.findViewById<TextView>(R.id.txtView_ScoutCountry)
                val scoutCreationDate   = rowScoutDetail.findViewById<TextView>(R.id.txtView_ScoutCreationDate)


                scoutName.text         = scouts[position].name
                scoutBirthdate.text         = scouts[position].birthdate.toString()
                scoutPhone.text    = scouts[position].phone.toString()
                scoutEmail.text      = scouts[position].email
                scoutCountry.text      = scouts[position].country
                scoutCreationDate.text      = scouts[position].creationDate.toString()

                return rowScoutDetail
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