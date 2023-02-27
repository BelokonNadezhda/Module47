package com.example.myapplication19.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.myapplication19.Film
import com.example.myapplication19.notifications.NotificationConstants
import com.example.myapplication19.notifications.NotificationHelper

class ReminderBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val bundle = intent?.getBundleExtra(NotificationConstants.FILM_BUNDLE_KEY)
        val film: Film = bundle?.get(NotificationConstants.FILM_KEY) as Film

        NotificationHelper.createNotification(context!!, film)
    }
}