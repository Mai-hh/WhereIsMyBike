package com.example.whereismybike.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews
import com.example.whereismybike.MainActivity
import com.example.whereismybike.R


private const val TAG = "WhereBikeAppWidgetProvider"
class WhereBikeAppWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {

        val pendingIntent = Intent(context, MainActivity::class.java)
            .putExtra("Clicked", "Clicked")
            .let {
                PendingIntent.getActivity(context, 0, it, 0)
            }

        appWidgetIds.forEach { appWidgetId ->
            appWidgetManager.updateAppWidget(appWidgetId, RemoteViews(
                context.packageName,
                R.layout.widget_layout
            ).apply {
                setOnClickPendingIntent(R.id.widget_image, pendingIntent)
            })
        }
    }
}