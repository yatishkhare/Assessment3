package com.example.assessment3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var name: EditText? = null
    var email: EditText? = null
    var city: EditText? = null
    var phoneNumber: EditText? = null
    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var extract: Button
    var mPersonId = 0
    override fun getIntent(): Intent {
        return super.getIntent()
    }
    private var mDb: AppDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        mDb = AppDatabase.getInstance(applicationContext)
    }

    private fun initViews() {
        name = findViewById(R.id.editText_Name)
        email = findViewById(R.id.editText_EmailAddress)
        city = findViewById(R.id.editText_city)
        phoneNumber = findViewById(R.id.editTextPhone)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.btnSave)
        button.setOnClickListener {
                view ->
            run {
                onSaveButtonClicked()
            }
        }


    }

    fun onSaveButtonClicked() {
        val person = Person(
            name!!.text.toString(),
            email!!.text.toString(),
            phoneNumber!!.text.toString(),
            city!!.text.toString()
        )
        AppExecutors.instance?.diskIO()
            ?.execute(Runnable { mDb!!.personDao()!!.insertPerson(person) })
    }
    fun exctractData(view: View?) {
        AppExecutors.instance?.diskIO()?.execute(Runnable {
            val person = mDb!!.personDao()!!.loadPersonById(1)
            runOnUiThread {
                textView.setText(
                    """
                ${person!!.name}
                ${person.email}
                ${person.city}
                ${person.number}
                """.trimIndent()
                )
            }
        }
        )
    }
}