package com.example.lovecalculator.presenter

import android.os.Bundle
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.view.FirstView

class FirstPresenter(private val view:FirstView.View):FirstView.Presenter {

    private lateinit var loveModel: LoveModel
    override fun onViewCreated(argument: Bundle?) {
        loveModel = argument?.getSerializable("love") as LoveModel
        view.displayLoveModel(loveModel)
    }

    override fun onTryButtonClick() {
        view.navigateToMainFragment()
    }
}