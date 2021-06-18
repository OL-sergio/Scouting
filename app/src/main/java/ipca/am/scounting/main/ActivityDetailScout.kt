package ipca.am.scounting.main

class ActivityDetailScout {
       var activitiesID : Int? = null
        var activitiesName : String? = null
        var activitiesCity : String? = null

        var scouts : MutableList<ActivitiesModel> = ArrayList()
        var activitiesAdapter : ActivitiesAdapter? = null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_activities_detail)

            val bundle = intent.extras
            bundle?.let {

                activitiesID = it.getInt("Activities Id")
                activitiesName = it.getString("Activities Name")
                activitiesCity = it.getString("Activiteis City")
            }

            activitiesAdapter = ActivitiesAdapter()
            listView_ActivitiesDetailActivity.adapter = activitiesAdapter

            var activitiesName : String? = null

            VolleyHelper.instance.getActivitiesByID(this, activitiesID!!.toInt()) { response ->

                response?.let {

                    for(index in 0 until it.length()){

                        val activitiesJSON : JSONObject = it[index] as JSONObject
                        scouts.add(ActivitiesModel.parseJSON(activitiesJSON))
                        activitiesName = scouts[index].activitiesName
                    }
                    activitiesAdapter?.notifyDataSetChanged()
                }
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