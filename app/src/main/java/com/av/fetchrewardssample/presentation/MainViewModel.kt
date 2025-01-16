package com.av.fetchrewardssample.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.av.fetchrewardssample.domain.GetHiringData
import com.av.fetchrewardssample.domain.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getHiringData: GetHiringData
): ViewModel() {

    private val _uiState = MutableStateFlow<Map<Int, List<Item>>>(emptyMap())
    val uiState: StateFlow<Map<Int, List<Item>>> = _uiState

    init {
        loadData()
    }

    private fun loadData() {

        Timber.d("Loading data...")

        viewModelScope.launch {
            getHiringData.invoke()
                .map { response ->
                    response.data
                        ?.filter { item -> item.name?.isNotBlank() == true }
                        ?.groupBy { it.listId ?: -1 }
                        ?.toSortedMap()
                        ?.mapValues { (_, items) -> items.sortedBy { it.name } }
                        ?: emptyMap()
                }
                .catch { ex -> Timber.e("Error obtaining hiring dara", ex)}
                .collect {
                    Timber.i("Got ${it.size} data items")
                    _uiState.value = it
                }
        }
    }
}