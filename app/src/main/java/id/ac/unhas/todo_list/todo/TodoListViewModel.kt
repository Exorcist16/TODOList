package id.ac.unhas.todo_list.todo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import id.ac.unhas.todo_list.database.TodoListRepository

class TodoListViewModel (application: Application): AndroidViewModel(application) {
    private var todoRepository =
        TodoListRepository(application)
    private var todos: LiveData<List<TodoList>>? = todoRepository.getTodos()


    fun getTodos(): LiveData<List<TodoList>>? {
        return todos
    }

    fun insertTodo(todo: TodoList) {
        todoRepository.insert(todo)
    }

    fun deleteTodo(todo: TodoList) {
        todoRepository.delete(todo)
    }

    fun updateTodo(todo: TodoList) {
        todoRepository.update(todo)
    }
}