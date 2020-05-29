package id.ac.unhas.todo_list.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ac.unhas.todo_list.todo.TodoList

@Database(entities = [TodoList::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoListDao

    companion object{
        private const val DB_NAME = "TODO_DB"
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room.databaseBuilder(context, AppDatabase::class.java,
                        DB_NAME
                    ).build()
                }
            }

            return instance
        }
    }

}