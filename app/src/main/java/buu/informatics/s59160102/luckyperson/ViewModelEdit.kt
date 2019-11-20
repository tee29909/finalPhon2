package buu.informatics.s59160102.luckyperson

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import buu.informatics.s59160102.luckyperson.database.editDao
import kotlinx.coroutines.*

class ViewModelEdit (
    val dataSource: editDao,
    application: Application
): AndroidViewModel(application)  {
    private val _name = MutableLiveData<String>()
    private val _sername = MutableLiveData<String>()
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val _navigateToInsert = MutableLiveData<Boolean>()
    private val _navigateToInventory = MutableLiveData<Boolean>()
    private val _navigateToEdit = MutableLiveData<Long>()
    val navigateToInventory: LiveData<Boolean> get() = _navigateToInventory
    val database = dataSource
    val lists = database.getAllListNames()

    val name: LiveData<String>
        get() = _name
    val sername: LiveData<String>
        get() = _sername




    init {
        Log.i("ViewModel", "ViewModel created!")
    }


    fun onClickAdd(){
        uiScope.launch {
            _navigateToInsert.value = true
        }
    }
    fun doneNavigating(){
        _navigateToInsert.value = null
    }

    fun onClear() {
        uiScope.launch {
            // Clear the database table.
            clear()

        }
    }
    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }

    fun onListClicked(id: Long) {

        _navigateToEdit.value = id
    }
    fun onEditNavigated() {
        _navigateToEdit.value = null
    }
}