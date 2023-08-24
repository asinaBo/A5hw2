package com.example.lovecalculator.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentMainBinding
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var bundle: Bundle

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        binding.btnCalculator.setOnClickListener {
            val firstEdText = binding.firstEd.text.toString()
            val secondEdText = binding.secondEd.text.toString()

            RetrofitService().api.calculateMatching(firstEdText, secondEdText)
                .enqueue(object : Callback<LoveModel> {
                    override fun onResponse(
                        call: Call<LoveModel>,
                        response: Response<LoveModel>
                    ) {
                        Log.e("ololo", "${response.body()}")
                        val loveModel = response.body()
                        val bundle = bundleOf(
                            "key_result" to loveModel?.toString(),
                            "key_you" to firstEdText,
                            "key_me" to secondEdText
                        )
                        findNavController().navigate(R.id.firstFragment, bundle)
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo", "onFailure:${t.message}")
                    }
                })
        }
    }
}
