package com.irv205.composewithxml.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irv205.composewithxml.core.di.IODispatcher
import com.irv205.composewithxml.core.di.MainDispatcher
import com.irv205.composewithxml.domain.model.CharacterDomain
import com.irv205.composewithxml.domain.repository.Repository
import com.irv205.composewithxml.domain.response.DataResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
    @MainDispatcher private val mainDispatcher: CoroutineDispatcher
    ): ViewModel() {

    private val _list = mutableStateListOf<CharacterDomain>()
    val list : SnapshotStateList<CharacterDomain> get() = _list
    var pagination = 1

    fun setPaginationValue(){
        pagination++
        getCharacterList(pagination)
    }

    init {
        getCharacterList(pagination)
    }

    fun getCharacterList(page: Int){

        viewModelScope.launch(ioDispatcher) {
            when(val result = repository.getCharacters(page)){
                is DataResponse.OnFailure -> {
                    withContext(Dispatchers.Main){

                    }
                }
                is DataResponse.Success -> {
                    withContext(mainDispatcher){
                        _list.clear()
                        _list.addAll(result.data)
                    }
                }
            }
        }
    }

}