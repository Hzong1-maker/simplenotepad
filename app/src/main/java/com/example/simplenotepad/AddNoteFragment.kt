package com.example.simplenotepad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment

class AddNoteFragment : Fragment() {

    private lateinit var editTextTitle: EditText
    private lateinit var editTextContent: EditText
    private lateinit var spinnerCategory: Spinner
    private lateinit var buttonAddNote: Button
    private val notes = mutableListOf<Note>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_add_note, container, false)

        editTextTitle = view.findViewById(R.id.editTextTitle)
        editTextContent = view.findViewById(R.id.editTextContent)
        spinnerCategory = view.findViewById(R.id.spinnerCategory)
        buttonAddNote = view.findViewById(R.id.buttonAddNote)

        // 设置 Spinner 适配器
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.categories_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCategory.adapter = adapter
        }

        buttonAddNote.setOnClickListener {
            // 处理添加笔记的逻辑
            val title = editTextTitle.text.toString()
            val content = editTextContent.text.toString()
            val category = spinnerCategory.selectedItem.toString()

            if (title.isNotEmpty() && content.isNotEmpty()) {
                // 创建一个新的 Note 对象并添加到列表中
                val note = Note(title, content, category)
                notes.add(note)

                // 显示一个 Toast 消息
                Toast.makeText(activity, "Note added: $title", Toast.LENGTH_SHORT).show()

                // 清空输入字段
                editTextTitle.text.clear()
                editTextContent.text.clear()
            } else {
                Toast.makeText(activity, "Please enter title and content", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
