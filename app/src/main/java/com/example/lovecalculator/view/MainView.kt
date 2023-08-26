package com.example.lovecalculator.view

import com.example.lovecalculator.model.LoveModel


interface MainView {
    interface View {
        fun initClicker()
        fun showResult(loveModel: LoveModel?)
        fun showError(message: String)
    }

    interface Presenter {
        fun calculateMatching(first: String, second: String)

    }
}

