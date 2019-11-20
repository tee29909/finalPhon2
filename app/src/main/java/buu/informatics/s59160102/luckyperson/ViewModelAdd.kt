package buu.informatics.s59160102.luckyperson

import android.app.Application
import android.provider.SyncStateContract.Helpers.insert
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import buu.informatics.s59160102.luckyperson.Database.ListName
import buu.informatics.s59160102.luckyperson.Database.editDao
import kotlinx.coroutines.*

class ViewModelAdd (
    val dataSource: editDao,
    application: Application
): AndroidViewModel(application)  {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val database = dataSource


    private val _name = MutableLiveData<String>()
    val name : LiveData<String> get() = _name

    private val _sername = MutableLiveData<String>()
    val sername : LiveData<String> get() = _sername



    val nameTextVisible = Transformations.map(name){
        it == null
    }
    val sernameTextVisible = Transformations.map(sername){
        it == null
    }


















    private val _navigateToInventory = MutableLiveData<Boolean>()
    val navigateToInventory: LiveData<Boolean>
        get() = _navigateToInventory
    fun onSetValue(nameState:String, sernameState:String){
        _name.value = nameState
        _sername.value = sernameState

    }
    fun onSave(inputName:String,InputSername:String) {
        uiScope.launch {
            // Create a new night, which captures the current time,
            // and insert it into the database.
            _name.value = inputName
            _sername.value = InputSername


            val newPerson = ListName()
            newPerson.name = name.value.toString()
            newPerson.sername = sername.value.toString()

            Log.i("Add Pokemon", name.value.toString() + " " + sername.value.toString())

            insert(newPerson)

        }




    }
    private suspend fun insert(listName: ListName) {
        withContext(Dispatchers.IO) {
            database.insert(listName)
        }
    }

    init {
        Log.i("ViewModel", "ViewModel created!")
    }
    override fun onCleared() {
        super.onCleared()
        Log.i("ViewModel", "ViewModel destroyed!")
    }
}