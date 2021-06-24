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
import ipca.am.scouting.models.StaffModel
import kotlinx.android.synthetic.main.activity_staff_detail.*
import org.json.JSONObject

class DetailStaff : AppCompatActivity() {



    var staffs : MutableList<StaffModel> = ArrayList()
    private var staffAdapter : StaffAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_detail)



        staffAdapter = StaffAdapter()
        listView_ActivityDetailStaff.adapter = staffAdapter




        VolleyHelper.instance.getStaff (this){ response ->

            response?.let {

                for(index in 0 until it.length()){

                    val activitiesJSON : JSONObject = it[index] as JSONObject
                    staffs.add(StaffModel.parseJson(activitiesJSON))
                    //
                }
                staffAdapter?.notifyDataSetChanged()
            }
        }


        findViewById<TextView>(R.id.txtView_GoToCreateStaff).setOnClickListener {

            val intent = Intent(this, CreateStaff::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.txtView_GoToScounting).setOnClickListener {

            val intent = Intent(this, DetailScout::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.txtView_GoToAtividades).setOnClickListener {

            val intent = Intent(this, ActivitiesDetailActivity::class.java)
            startActivity(intent)

        }
    }

    inner class StaffAdapter : BaseAdapter() {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val rowStaffDetail = layoutInflater.inflate(R.layout.activity_staff_row, parent, false)


            val staffName      = rowStaffDetail.findViewById<TextView>(R.id.textViewStaffName)
            val staffBirthdate      = rowStaffDetail.findViewById<TextView>(R.id.textViewStaffBirthdate)
            val staffPhone = rowStaffDetail.findViewById<TextView>(R.id.textViewStaffPhone)
            val staffEmail   = rowStaffDetail.findViewById<TextView>(R.id.textViewStaffEmail)
            val staffCountry   = rowStaffDetail.findViewById<TextView>(R.id.textViewStaffCountry)
            val staffCreationDate   = rowStaffDetail.findViewById<TextView>(R.id.textViewStaffCreationDate)


            staffName.text         = staffs[position].name
            staffBirthdate.text         = staffs[position].birthdate.toString()
            staffPhone.text    = staffs[position].phone.toString()
            staffEmail.text      = staffs[position].email
            staffCountry.text      = staffs[position].country
            staffCreationDate.text      = staffs[position].creationDate.toString()

            return rowStaffDetail
        }

        override fun getItem(position: Int): Any {

            return staffs[position]
        }

        override fun getItemId(position: Int): Long {

            return 0
        }

        override fun getCount(): Int {

            return staffs.size
        }
    }

}