package com.example.lovecalculator.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
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
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        handleSuccessResponse(response.body(), firstEdText, secondEdText)
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        handleFailureResponse(t.message)
                    }
                })
        }
    }

    private fun handleSuccessResponse(loveModel: LoveModel?, youText: String, meText: String) {
        val bundle = bundleOf(
            "key_result" to loveModel?.toString(),
            "key_you" to youText,
            "key_me" to meText
        )

        val fragmentB = FirstFragment()
        fragmentB.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(R.id.mainFragment, fragmentB)
            .addToBackStack(null)
            .commit()
    }

    private fun handleFailureResponse(errorMessage: String?) {
        Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
        Log.e("ololo", "onFailure: $errorMessage")
    }
}