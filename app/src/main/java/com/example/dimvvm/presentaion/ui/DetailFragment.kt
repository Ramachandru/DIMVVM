package com.example.dimvvm.presentaion.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.dimvvm.base.BaseFragment
import com.example.dimvvm.SavedDataForDetails
import com.example.dimvvm.databinding.PlayerDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment() {
    private val playerArgs: DetailFragmentArgs by navArgs()
    lateinit var playerDetailsBinding: PlayerDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setPageTitle("Player Details")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        playerDetailsBinding = PlayerDetailsBinding.inflate(inflater, container, false)
        return playerDetailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val player = SavedDataForDetails.getPlayerListForDatails().get(playerArgs.position)
        playerDetailsBinding.player = player
        playerDetailsBinding.executePendingBindings()
    }
}