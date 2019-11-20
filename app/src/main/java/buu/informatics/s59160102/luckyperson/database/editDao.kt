package buu.informatics.s59160102.luckyperson.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface editDao {

    @Insert
    fun insert(listName: ListName)

    @Update
    fun update(listName: ListName)

    @Query("SELECT * from person WHERE id = :key")
    fun get(key: Int): ListName?

    @Query("DELETE FROM person")
    fun clear()

    @Query("SELECT * FROM person ORDER BY id DESC LIMIT 1")
    fun getListName(): ListName?

    @Query("SELECT * FROM person ORDER BY id DESC")
    fun getAllListNames(): LiveData<List<ListName>>
}