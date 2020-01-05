package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.myapplication.model.Data
import com.example.myapplication.model.Reqres
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val dataList: MutableList<Data> = mutableListOf()
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myAdapter = MyAdapter(dataList)

        //Setup recyclerView
        my_recycler_view.layoutManager = LinearLayoutManager(this)
        my_recycler_view.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))
        my_recycler_view.adapter = myAdapter

        // setup Android Networking
        AndroidNetworking.initialize(this)

        AndroidNetworking.get("https://newsapi.org/v2/top-headlines?sources=google-news-fr&apiKey=d334f5bb09cc49e68d872a4ad0c94177")
            .build()
            .getAsObject(Reqres::class.java, object : ParsedRequestListener<Reqres>{
                override fun onResponse(response: Reqres) {
                    dataList.addAll(response.articles)
                    myAdapter.notifyDataSetChanged()
                }
                override fun onError(anError: ANError?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
    }
}
