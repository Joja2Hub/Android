package com.example.studentform
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.widget.EditText
class EditActivity : AppCompatActivity(){
    private lateinit var nameEditText: EditText
    private lateinit var surnameEditText: EditText
    private lateinit var patronicEditText: EditText
    private lateinit var FacultEditText: EditText
    private lateinit var GroupEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var cancelButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        nameEditText = findViewById(R.id.nameEditText)
        surnameEditText = findViewById(R.id.surnameEditText)
        patronicEditText = findViewById(R.id.PatronicEditText)
        FacultEditText = findViewById(R.id.FacultEditText)
        GroupEditText = findViewById(R.id.GroupEditText)
        saveButton = findViewById(R.id.saveButton)
        cancelButton = findViewById(R.id.cancelButton)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val surname = surnameEditText.text.toString()
            val patronic = patronicEditText.text.toString()
            val facult = FacultEditText.text.toString()
            val group = GroupEditText.text.toString()
            // Проверка имени
            if (name.isEmpty() || !name.matches(Regex("[A-Z][a-z]+"))) {
                nameEditText.error = "Имя должно начинаться с заглавной буквы и содержать только буквы"
                return@setOnClickListener
            }

            // Проверка фамилии
            if (surname.isEmpty() || !surname.matches(Regex("[A-Z][a-z]+"))) {
                surnameEditText.error = "Фамилия должна начинаться с заглавной буквы и содержать только буквы"
                return@setOnClickListener
            }

            // Проверка отчества
            if (patronic.isEmpty() || !patronic.matches(Regex("[A-Z][a-z]+"))) {
                patronicEditText.error = "Отчество должно начинаться с заглавной буквы и содержать только буквы"
                return@setOnClickListener
            }


            if(surnameEditText.error==null&&nameEditText.error==null&&patronicEditText.error==null){
            val intent = Intent()
            intent.putExtra(MainActivity.EXTRA_NAME, name)
            intent.putExtra(MainActivity.EXTRA_SURNAME, surname)
                intent.putExtra(MainActivity.EXTRA_PATRONIC, patronic)
            intent.putExtra(MainActivity.EXTRA_FACULT, facult)
            intent.putExtra(MainActivity.EXTRA_GROUP, group)
            setResult(RESULT_OK, intent)
            finish()}

        }

        cancelButton.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}

