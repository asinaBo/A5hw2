package com.example.lovecalculator.presenter

import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.remote.RetrofitService
import com.example.lovecalculator.view.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(private val view: MainView.View) : MainView.Presenter { // MainPresenter
    override fun calculateMatching(first: String, second: String) {
        RetrofitService().api.calculateMatching(first, second).enqueue(object :
            Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                view.showResult(response.body())
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                view.showError(t.message ?: "Error")
            }
        })
    }
}



