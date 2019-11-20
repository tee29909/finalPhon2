package buu.informatics.s59160102.luckyperson

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import buu.informatics.s59160102.luckyperson.Database.editDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class ViewModelEdit (
    val dataSource: editDao,
    application: Application
): AndroidViewModel(application)  {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _navigateToInventory = MutableLiveData<Boolean>()
    val navigateToInventory: LiveData<Boolean> get() = _navigateToInventory
    init {
        Log.i("ViewModel", "ViewModel created!")
    }
    override fun onCleared() {
        super.onCleared()
        Log.i("ViewModel", "ViewModel destroyed!")
    }
}