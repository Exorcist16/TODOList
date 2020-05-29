package id.ac.unhas.todo_list.util

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import id.ac.unhas.todo_list.R
import kotlinx.android.synthetic.main.form_dialog.*

class FormDialog(context: Context, private val title: String, private val formLayout: View, private val saveAction: () -> Unit): Dialog(context){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCancelable(false)
        setContentView(R.layout.form_dialog)

        if (formLayout.parent != null) {
            (formLayout.parent as ViewGroup).removeView(formLayout)
        }

        tv_title.text = title
        container.addView(formLayout)
        btn_cancel.setOnClickListener { dismiss() }
        btn_save.setOnClickListener {
            saveAction()
            dismiss()
        }

    }

}