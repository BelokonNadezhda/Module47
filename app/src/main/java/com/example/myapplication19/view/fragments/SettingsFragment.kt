package com.example.myapplication19.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication19.R
import com.example.myapplication19.data.ApiConstants
import com.example.myapplication19.databinding.FragmentSettingsBinding
import com.example.myapplication19.utils.AnimationHelper
import com.example.myapplication19.viewmodel.SettingsFragmentViewModel

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(SettingsFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Подключаем анимации и передаем номер позиции у кнопки в нижнем меню
        AnimationHelper.performFragmentCircularRevealAnimation(binding.settingsFragmentRoot, requireActivity(), 5)
        //Слушаем, какой у нас сейчас выбран вариант в настройках
        viewModel.categoryPropertyLifeData.observe(viewLifecycleOwner, {
            //println("!!!it="+it)
            when(it) {
                ApiConstants.TOP_100 -> binding.radioGroup.check(R.id.radio_popular)
                ApiConstants.TOP_250 -> binding.radioGroup.check(R.id.radio_top_rated)
                ApiConstants.TOP_AWAIT -> binding.radioGroup.check(R.id.radio_upcoming)
            }

        })


        //Слушатель для отправки нового состояния в настройки
        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            //println("!!!checkedId"+checkedId)
            when(checkedId) {
                R.id.radio_popular -> viewModel.putCategoryProperty(ApiConstants.TOP_100)
                R.id.radio_top_rated -> viewModel.putCategoryProperty(ApiConstants.TOP_250)
                R.id.radio_upcoming -> viewModel.putCategoryProperty(ApiConstants.TOP_AWAIT)
           }
        }
    }

    /*companion object {
        private const val POPULAR_CATEGORY = "popular"
        private const val TOP_RATED_CATEGORY = "top_rated"
        private const val UPCOMING_CATEGORY = "upcoming"
    }*/
}