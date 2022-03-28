package com.example.whereismybike.ui.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.util.Log

/**I
 * Created by wangfei44 on 2021/12/28.
 */
class RecorderAppWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?,
    ) {
        Log.i(TAG, "onUpdate")
        super.onUpdate(context, appWidgetManager, appWidgetIds)
    }


    override fun onEnabled(context: Context) {
        super.onEnabled(context)
    }


    override fun onDisabled(context: Context) {
        super.onDisabled(context)
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
    }
}
