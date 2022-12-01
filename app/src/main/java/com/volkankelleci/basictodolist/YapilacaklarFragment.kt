package com.volkankelleci.basictodolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_ana_sayfa.*
import kotlinx.android.synthetic.main.fragment_yapilacaklar.*

class YapilacaklarFragment : Fragment() {
    private var yollanacakDeger:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yapilacaklar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            val yollanacakDeger=YapilacaklarFragmentArgs.fromBundle(it).yapilacaklar
            yapilacaklarText.text=yollanacakDeger
        }
        super.onViewCreated(view, savedInstanceState)
    }
}