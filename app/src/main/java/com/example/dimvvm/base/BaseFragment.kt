package com.example.dimvvm.base

import androidx.fragment.app.Fragment
import com.example.dimvvm.presentaion.ui.MainActivity

open class BaseFragment : Fragment() {
    fun setPageTitle(screen: String) {
        (activity as MainActivity).supportActionBar?.title = screen
    }
}