package com.example.lab2

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView


class TaskViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_file, parent, false)) {
    private var mTaskText: TextView? = null
    private var mCheckBox: CheckBox? = null
    private var mView: View? = null
    private var doneButton: Button? = null
    private var newTask: EditText? = null


    init {
        newTask = itemView.findViewById(R.id.newTask)
        doneButton = itemView.findViewById(R.id.doneButton)
        mTaskText = itemView.findViewById(R.id.taskView)
        mCheckBox = itemView.findViewById(R.id.checkBox)
        mView = itemView.findViewById(R.id.view2)
    }

    fun bind(task: Task) {
        mTaskText?.text = task.taskName
        if (task.checked == true) {
            mView?.visibility = View.VISIBLE
            mCheckBox?.setChecked(true)
        } else{
            mView?.visibility = View.INVISIBLE
            mCheckBox?.setChecked(false)
        }
        mCheckBox!!.setOnCheckedChangeListener(
            CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked == true) {
                    mView?.visibility = View.VISIBLE
                    buttonView?.setChecked(true)
                } else {
                    mView?.visibility = View.INVISIBLE
                    buttonView?.setChecked(false)
                }
            }
        )
        if (mTaskText!!.text.equals("New task")) {
            mTaskText!!.visibility = View.INVISIBLE
            newTask!!.visibility = View.VISIBLE
            doneButton!!.visibility = View.VISIBLE
        }

        doneButton!!.setOnClickListener{
            mTaskText!!.visibility = View.VISIBLE
            mTaskText!!.setText(newTask!!.text.toString())
            newTask!!.visibility = View.INVISIBLE
            doneButton!!.visibility = View.INVISIBLE
            mTaskText!!.freezesText
            newTask!!.freezesText
            doneButton!!.freezesText
        }
    }
}