package com.example.lovecalculator.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentMainBinding
import com.example.lovecalculator.presenter.MainPresenter
import com.example.lovecalculator.view.MainView

class MainFragment : Fragment(), MainView.View {
    private lateinit var binding: FragmentMainBinding
    private lateinit var presenter: MainView.Presenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        presenter = MainPresenter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    override fun initClicker() {
        binding.btnCalculator.setOnClickListener {
            presenter.calculateMatching(
                binding.firstEd.text.toString(),
                binding.secondEd.text.toString()
            )
        }
    }

    override fun showResult(loveModel: LoveModel?) {
        findNavController().navigate(R.id.firstFragment, bundleOf("love" to loveModel))
    }

    override fun showError(message: String) {
        Log.e("ololo", "Error:$message")
    }
}
