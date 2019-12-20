package com.percival.avitomap.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.percival.avitomap.App
import com.percival.avitomap.domain.models.Pin
import com.percival.avitomap.domain.repositories.implementations.PinsRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SharedViewModel: ViewModel() {
    @Inject
    lateinit var pinsRepository: PinsRepositoryImpl

    var pinMap: MutableLiveData<Map<String, List<Pin>>> = MutableLiveData()
    var activeServices: MutableLiveData<Set<String>> = MutableLiveData()

    init {
        App.appComponent.inject(this@SharedViewModel)

        activeServices.value = HashSet()
        CoroutineScope(Dispatchers.IO).async {
            val data = pinsRepository.getPinsMap()
            withContext(Dispatchers.Main){
                pinMap.value = data
            }
        }
    }

    fun changeActiveServices(string: String){
        val set = activeServices.value?.toMutableSet()
        activeServices.value?.let {
            if (it.contains(string)){
                set?.remove(string)
            }else{
                set?.add(string)
            }
        }
        activeServices.value = set
    }



}