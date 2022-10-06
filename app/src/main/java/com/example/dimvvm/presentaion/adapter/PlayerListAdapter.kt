package com.example.dimvvm.presentaion.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dimvvm.OnDataListener
import com.example.dimvvm.databinding.PlayerListAdapterBinding
import com.example.dimvvm.model.PlayersList

class PlayerListAdapter(context: Context) :
    RecyclerView.Adapter<PlayerListAdapter.PlayerViewHolder>() {
    var playersData: List<PlayersList>? = null
    var dataListener: OnDataListener? = null
    var mContext = context;
    fun setUpData(playersData: List<PlayersList>?) {
        this.playersData = playersData
    }

    init {
        dataListener = mContext as OnDataListener
    }

    private lateinit var playerListAdapterBinding: PlayerListAdapterBinding

    class PlayerViewHolder(itemView: PlayerListAdapterBinding, context: Context) :
        RecyclerView.ViewHolder(itemView.root) {
        var binding = itemView
        var ctx = context
        fun executeDatas(data: PlayersList, position: Int) {
            binding.player = data;
            binding.playerPosition = position
            binding.playerDetail = PlayerListAdapter(ctx)
            binding.executePendingBindings()
        }
    }

    fun OnClickedList(Itemposition: Int) {
        dataListener!!.onData(Itemposition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        playerListAdapterBinding = PlayerListAdapterBinding.inflate(
            inflater, parent, false
        )
        return PlayerViewHolder(playerListAdapterBinding, mContext)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        var player = playersData!!.get(position)
        holder.executeDatas(player, position)
    }

    override fun getItemCount(): Int {
        return playersData!!.size
    }
}

