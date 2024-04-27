package com.example.todoapp.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.todoapp.R
import com.example.todoapp.database.TodoDatabase
import com.example.todoapp.database.model.TodoModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.Calendar

class ModelBottomSheet : BottomSheetDialogFragment() {
    lateinit var titleEditText: EditText
    lateinit var descriptionEditText: EditText
    lateinit var timeValueText: TextView
    lateinit var calendar: Calendar
    lateinit var addButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.model_bottom_sheet, container, false)

    companion object {
        const val TAG = "ModalBottomSheet"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

    }
    private fun initViews(){
        titleEditText=requireView().findViewById(R.id.task_name_Ed)
        descriptionEditText=requireView().findViewById(R.id.description_task_Ed)
        timeValueText=requireView().findViewById(R.id.select_time_Tex)
        addButton=requireView().findViewById(R.id.addTask_button)
         calendar=Calendar.getInstance()
        timeValueText.text =
            "${calendar.get(Calendar.DAY_OF_MONTH)} / ${calendar.get(Calendar.MONTH) + 1} / ${
                calendar.get(Calendar.YEAR)
            }"
        timeValueText.setOnClickListener {
            showDatePicker()
        }

        addButton.setOnClickListener{
            addTodoToDataBase()
        }
    }
    private fun validateFields(): Boolean{
              var isValid=true
        if (titleEditText.text.toString().isNullOrBlank()){
            titleEditText.error="please enter title"
            isValid=false
        }else{
            titleEditText.error=null
        }
        if (descriptionEditText.text.toString().isNullOrBlank()){
            descriptionEditText.error="please enter description"
            isValid=false

        }else{
            descriptionEditText.error=null
        }
        if (timeValueText.text.toString().isNullOrBlank()){
            timeValueText.error="please enter time"
            isValid=false

        }else{
            timeValueText.error=null
        }
        return isValid
    }
    private fun showDatePicker(){
        val datePicker= DatePickerDialog(requireContext())
        datePicker.show()
        datePicker.setOnDateSetListener { view, year, month, dayOfMonth ->
            timeValueText.text = "$dayOfMonth / ${month + 1} / $year"
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            calendar.clear()
        }
    }

    private fun addTodoToDataBase() {
        if (validateFields()) {
            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()
            val time = timeValueText.text.toString()


            TodoDatabase
                .getInstance(requireContext())
                .getTodosDao()
                .insertTask(
                    TodoModel(
                        title = title,
                        time = calendar.time
                    )
                )
            dismiss()
        }
    }
}