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
import ipca.am.scouting.models.ScoutModel
import kotlinx.android.synthetic.main.activity_scout_detail.*
import org.json.JSONObject

class DetailScout : AppCompatActivity()  {

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

            findViewById<TextView>(R.id.txtView_GoToCreateScout).setOnClickListener {

                val intent = Intent(this, CreateScout::class.java)
                startActivity(intent)
            }

            findViewById<TextView>(R.id.txtView_GoToAtividades).setOnClickListener {

                val intent = Intent(this, ActivitiesDetailActivity::class.java)
                startActivity(intent)
            }

            findViewById<TextView>(R.id.txtView_GoToStaff).setOnClickListener {

                val intent = Intent(this, DetailStaff::class.java)
                startActivity(intent)

            }
        }


        inner class ScoutAdapter : BaseAdapter() {

            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

                val rowScoutDetail = layoutInflater.inflate(R.layout.activity_scouts_row, parent, false)

                val scoutName      = rowScoutDetail.findViewById<TextView>(R.id.textViewScoutName)
                val scoutBirthdate      = rowScoutDetail.findViewById<TextView>(R.id.textViewScoutBirthdate)
                val scoutPhone = rowScoutDetail.findViewById<TextView>(R.id.textViewScoutPhone)
                val scoutEmail   = rowScoutDetail.findViewById<TextView>(R.id.textViewScoutEmail)
                val scoutCountry   = rowScoutDetail.findViewById<TextView>(R.id.textViewScoutCountry)
                val scoutCreationDate   = rowScoutDetail.findViewById<TextView>(R.id.textViewScoutCreationDate)


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