package ru.maksonic.simplenotification

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

/**
 * @Author: maksonic on 25.01.2022
 */
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels {
        MainViewModel.BlurViewModelFactory(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = this.findViewById<Button>(R.id.button)

        btn.setOnClickListener {
            viewModel.showNotification(this)
        }
    }
}



