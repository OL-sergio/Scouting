package ipca.am.scounting.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import ipca.am.scounting.R
import ipca.am.scounting.helpers.VolleyHelper
import ipca.am.scounting.models.StaffModel
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
    }


    inner class StaffAdapter : BaseAdapter() {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val rowStaffDetail = layoutInflater.inflate(R.layout.activity_staff_row, parent, false)


            val staffName      = rowStaffDetail.findViewById<TextView>(R.id.txtView_StaffName)
            val staffBirthdate      = rowStaffDetail.findViewById<TextView>(R.id.txtView_StaffBirthdate)
            val staffPhone = rowStaffDetail.findViewById<TextView>(R.id.txtView_StaffPhone)
            val staffEmail   = rowStaffDetail.findViewById<TextView>(R.id.txtView_StaffEmail)
            val staffCountry   = rowStaffDetail.findViewById<TextView>(R.id.txtView_StaffCountry)
            val staffCreationDate   = rowStaffDetail.findViewById<TextView>(R.id.txtView_StaffCreationDate)


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