package com.example.lovecalculator.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentFirstBinding
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.view.FirstView
import com.example.lovecalculator.view.MainView

class FirstFragment : Fragment(), FirstView {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var loveModel: LoveModel
    private lateinit var presenter: MainView.Presenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loveModel = this.arguments?.getSerializable("love") as LoveModel // получаем данные
        binding.tvMe.text = loveModel.firstname
        binding.tvYoy.text = loveModel.secondName                   // присваиваем к TextView
        binding.tvProcent.text = loveModel.percentage + "%"
        binding.text.text = loveModel.result
        binding.btnTry.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)         // навигация при клике
        }
    }
}