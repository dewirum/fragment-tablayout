package com.example.aplication.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.aplication.R
import com.example.aplication.adapter.PostitemAdapter
import com.example.aplication.rest.ApiClient
import com.example.aplication.rest.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_first.*


/**
 * A simple [Fragment] subclass.
 *
 *
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_first, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.rv__list_posts)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val service: ApiService = ApiClient.client()
        service.getAllPosts().subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                recyclerView.adapter = PostitemAdapter(it, activity)
            }







        return view
    }


}
