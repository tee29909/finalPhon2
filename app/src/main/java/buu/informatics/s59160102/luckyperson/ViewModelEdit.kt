package buu.informatics.s59160102.luckyperson

import android.util.Log
import androidx.lifecycle.ViewModel

class ViewModelEdit : ViewModel() {
    init {
        Log.i("ViewModel", "ViewModel created!")
    }
    override fun onCleared() {
        super.onCleared()
        Log.i("ViewModel", "ViewModel destroyed!")
    }
}