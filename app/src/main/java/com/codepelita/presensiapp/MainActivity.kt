package com.codepelita.presensiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<ResultPresensi>()
    private lateinit var responText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvData = findViewById<RecyclerView>(R.id.listDataAPI)
        responText = findViewById(R.id.txtRespon)
        rvData.setHasFixedSize(true)
        rvData.layoutManager = LinearLayoutManager(this)

        PresensiClient.instance.getDatapresensi().enqueue(object :
             Callback<ArrayList<ResultPresensi>> {
            override fun onResponse(
                call: Call<ArrayList<ResultPresensi>>,
                response: Response<ArrayList<ResultPresensi>>
            ) {
                val responeCode = response.code().toString()
                responText.text = responeCode
                rvData.adapter = response.body()?.let { PresensiAdapter(it) }
            }

            override fun onFailure(call: Call<ArrayList<ResultPresensi>>, t: Throwable) {
                Log.e("MainActivity", "Error ${t.message}")
            }

        })
    }
}