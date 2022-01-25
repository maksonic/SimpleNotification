package ru.maksonic.simplenotification

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import ru.maksonic.simplenotification.domain.NotificationWorker

/**
 * @Author: maksonic on 25.01.2022
 */
class MainViewModel(application: Application) : ViewModel() {

    fun showNotification(context: Context) {
        val notificationWork = OneTimeWorkRequest.Builder(NotificationWorker::class.java)
            .build()

        val instanceWorkManager = WorkManager.getInstance(context)
        instanceWorkManager.beginWith(notificationWork).enqueue()
    }

    internal class BlurViewModelFactory(private val application: Application) :
        ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                MainViewModel(application) as T
            } else {
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }
}