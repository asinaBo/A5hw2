package com.example.lovecalculator.view

import android.os.Bundle
import com.example.lovecalculator.model.LoveModel

interface FirstView {
    interface View {
        fun displayLoveModel(loveModel: LoveModel)
        fun navigateToMainFragment()
    }

    interface Presenter {
        fun onViewCreated(argument: Bundle?)
        fun onTryButtonClick()
    }
}
