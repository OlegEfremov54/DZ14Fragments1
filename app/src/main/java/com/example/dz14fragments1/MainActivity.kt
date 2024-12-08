package com.example.dz14fragments1

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Date

class MainActivity : AppCompatActivity() {
    private lateinit var toolbarMain:Toolbar
    private lateinit var addBTN:Button

    private lateinit var recyclerViewRV: RecyclerView
    private lateinit var generateCountTV: TextView
    private lateinit var textNoteET: EditText

    private val textMess: MutableList<TextMes> = mutableListOf()
    private var count: Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Тулбар
        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = "  Мои заметки"
        toolbarMain.subtitle = " Версия 1.Главная страница"
        toolbarMain.setLogo(R.drawable.adresbook2smoll)

        addBTN = findViewById(R.id.addBTN)

        recyclerViewRV = findViewById(R.id.recyclerViewRV)
        generateCountTV = findViewById(R.id.generateCountTV)
        textNoteET = findViewById(R.id.textNoteET)

        generateCountTV.text = "№ $count"
        recyclerViewRV.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter(textMess)
        recyclerViewRV.adapter = adapter
        recyclerViewRV.setHasFixedSize(true)

        addBTN.setOnClickListener {
            if (textNoteET.text.isEmpty()) {
                return@setOnClickListener
            }
            val text = textNoteET.text.toString()
            val date = Date().toString()
            val checkBoxStart = false
            val note = TextMes(count, text, date, checkBoxStart)
            textMess.add(note)
            adapter.notifyDataSetChanged()
            count = ((textMess[textMess.size - 1].count) + 1)
            generateCountTV.text = "№ $count"
            textNoteET.text.clear()

        }





    }
    //Инициализация Меню
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.infoMenuMain -> {
                Toast.makeText(
                    applicationContext, "Автор Ефремов О.В. Создан 8.12.2024",
                    Toast.LENGTH_LONG
                ).show()
            }

            R.id.exitMenuMain -> {
                Toast.makeText(
                    applicationContext, "Работа приложения завершена",
                    Toast.LENGTH_LONG
                ).show()
                finishAffinity()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}