package com.example.lovecalculator.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentFirstBinding
import com.example.lovecalculator.model.LoveModel

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var loveModel: LoveModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    private fun setData() {
        val bunle = arguments
        if (bunle != null) {
            binding.tvProcent.text = bunle.getString("key_result")
            binding.tvMe.text = bunle.getString("key_me")
            binding.tvYoy.text = bunle.getString("key_you")

            loveModel = this.arguments?.getSerializable("love") as LoveModel
            binding.tvMe.text = loveModel.firstname
            binding.tvYoy.text = loveModel.secondName
            binding.tvProcent.text = loveModel.percentage + "%"
            binding.text.text = loveModel.result
        }
        binding.btnTry.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }
    }

}