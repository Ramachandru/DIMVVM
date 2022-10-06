package com.example.dimvvm.presentaion.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dimvvm.R
import com.example.dimvvm.base.BaseFragment
import com.example.dimvvm.SavedDataForDetails
import com.example.dimvvm.model.PlayerResult
import com.example.dimvvm.presentaion.adapter.PlayerListAdapter
import com.example.dimvvm.viewmodel.PlayersDataViewModel
import com.google.android.material.progressindicator.CircularProgressIndicator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment() {
    val playersModel: PlayersDataViewModel by activityViewModels()

    @Inject
    lateinit var playerListAdapter: PlayerListAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var progressIndicator: CircularProgressIndicator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setPageTitle("Player List")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.player_list, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recylerview)
        progressIndicator = view.findViewById(R.id.progress_circular)
        initialSetupUi()
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                playersModel.playersStateData.collect { playesResult ->
                    when (playesResult) {
                        is PlayerResult.Success -> {
                            playerListAdapter.setUpData(playesResult.playesrData.data)
                            SavedDataForDetails.setUpData(playesResult.playesrData.data)
                            playerListAdapter.notifyDataSetChanged()
                            progressIndicator.visibility = View.GONE
                            recyclerView.visibility = View.VISIBLE
                        }
                        is PlayerResult.Error -> {
                            println("Error : ${playesResult.errorMsg}")
                            progressIndicator.visibility = View.GONE
                        }
                        is PlayerResult.Loading -> {
                            progressIndicator.visibility = View.VISIBLE
                            recyclerView.visibility = View.GONE
                        }
                    }
                }
            }
        }
    }

    fun initialSetupUi() {
        var linearLayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = linearLayoutManager
        playerListAdapter.setUpData(emptyList())
        recyclerView.adapter = playerListAdapter
    }
}