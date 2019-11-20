package buu.informatics.s59160102.luckyperson

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import buu.informatics.s59160102.luckyperson.Database.editDao

class ViewModelEditFactory (
    private val dataSource: editDao,
    private val application: Application
): ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelEdit::class.java)) {
            return ViewModelEdit(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
}
}