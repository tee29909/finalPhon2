package buu.informatics.s59160102.luckyperson.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class ListName(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    @ColumnInfo(name = "name")
    var name: String="",
    @ColumnInfo(name = "sername")
    var sername: String =""
)


