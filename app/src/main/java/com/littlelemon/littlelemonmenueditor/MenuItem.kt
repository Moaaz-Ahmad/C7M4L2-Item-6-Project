package com.littlelemon.littlelemonmenueditor

import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity(tableName = "menu")
data class MenuItem(
    @PrimaryKey val id: String,
    val name: String,
    val price: Double
)
interface MenuDao {
    @Query("SELECT * FROM menu")
    fun getAllMenuItems(): LiveData<List<MenuItem>>
    @Insert
    fun insertMenuItem(menuItem: MenuItem)
    @Delete
    fun deleteMenuItem(menuItem: MenuItem)
}
@Database(entities = [MenuItem::class], version = 1)
abstract class MenuDatabase : RoomDatabase() {
    abstract val menuDao: MenuDao
}
