package buu.informatics.s59160102.luckyperson.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [ListName::class], version = 1, exportSchema = false)
abstract class editDatabase : RoomDatabase() {
    abstract val editDao: editDao
    @Volatile
    private var INSTANCE: editDatabase? = null

    fun getInstance(context: Context): editDatabase {
        synchronized(this) {
            var instance = INSTANCE

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    editDatabase::class.java,
                    "person"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
            }
            return instance
        }
    }


}