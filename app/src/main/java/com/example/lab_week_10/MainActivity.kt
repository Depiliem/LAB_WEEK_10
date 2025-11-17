package com.example.lab_week_10

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.lab_week_10.viewmodels.TotalViewModel
import com.example.lab_week_10.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val viewModel by lazy {
        ViewModelProvider (this) [TotalViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        prepareViewModel()
    }

    private fun updateText(total: Int) {
        findViewById<TextView>(R.id.text_total).text =
            getString(R.string.text_total, total)
    }

    private fun prepareViewModel(){
        viewModel.total.observe(this, {
            updateText(it)
        })
        findViewById<Button>(R.id.button_increment).setOnClickListener {
            viewModel.incrementTotal()
        }
    }
}