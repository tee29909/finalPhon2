package buu.informatics.s59160102.luckyperson.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class ListName(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "name")
    var name: String="",
    @ColumnInfo(name = "sername")
    var sername: String =""
)


