package com.example.dimvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dimvvm.model.PlayerResult
import com.example.dimvvm.network.PlayerDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayersDataViewModel @Inject constructor(
    private val playersRepository: PlayerDataRepository
) : ViewModel() {

    val _playersStateData: MutableStateFlow<PlayerResult> =
        MutableStateFlow(PlayerResult.Loading)

    var playersStateData = _playersStateData

    init {
        viewModelScope.launch {
            _playersStateData.value = PlayerResult.Loading
            playersRepository.getPlayersData()
                .map {
                    it.data.filter {
                        playersRepository.insertData(it)
                        true
                    }
                    it
                }
                .flowOn(Dispatchers.IO)
                .catch { exception ->
                    _playersStateData.value = PlayerResult.Error(exception.message!!)
                    viewModelScope.trigerDataFromLocalDB()
                }
                .collect {
                    _playersStateData.value = PlayerResult.Success(it.data)
                }
        }
    }

    fun CoroutineScope.trigerDataFromLocalDB() {
        this.launch {
            playersRepository.getPlayersList()
                .flowOn(Dispatchers.IO)
                .catch { ext ->
                    _playersStateData.value = PlayerResult.Error(ext.message!!)
                }.collect {
                    _playersStateData.value = PlayerResult.Success(it)
                }
        }
    }
}