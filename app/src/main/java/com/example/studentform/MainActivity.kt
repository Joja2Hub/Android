package com.example.studentform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {
    private lateinit var nameTextView: TextView
    private lateinit var surnameTextView: TextView
    private lateinit var patronicTextView: TextView
    private lateinit var facultTextView: TextView
    private lateinit var groupTextView: TextView
    private lateinit var editButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameTextView = findViewById(R.id.nameTextView)
        surnameTextView = findViewById(R.id.surnameTextView)
        patronicTextView = findViewById(R.id.PatronictextView)
        facultTextView = findViewById(R.id.facultTextView)
        groupTextView = findViewById(R.id.groupTextView)
        editButton = findViewById(R.id.editButton)

        editButton.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_EDIT)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_EDIT && resultCode == RESULT_OK) {
            val name = data?.getStringExtra(EXTRA_NAME)
            val surname = data?.getStringExtra(EXTRA_SURNAME)
            val patronic = data?.getStringExtra(EXTRA_PATRONIC)
            val facult = data?.getStringExtra(EXTRA_FACULT)
            val group = data?.getStringExtra(EXTRA_GROUP)

            nameTextView.text = "Имя: " + name
            surnameTextView.text = "Фамилия: " + surname
            patronicTextView.text = "Отчество: " + patronic
            facultTextView.text = "Факультет: " + facult
            groupTextView.text = "Группа: " + group
        }
    }

    companion object {
        const val REQUEST_CODE_EDIT = 1
        const val EXTRA_NAME = "name"
        const val EXTRA_SURNAME = "surname"
        const val EXTRA_PATRONIC = "patronic"
        const val EXTRA_FACULT = "facult"
        const val EXTRA_GROUP = "group"
    }
}