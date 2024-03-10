package ru.aidar.app_common.config

import android.content.Context
import ru.aidar.app_common.R
import java.util.Properties

class AppProperties(context: Context) {
    private val properties: Map<String, String> = initProperties(context)

    @Suppress("UNCHECKED_CAST")
    private fun initProperties(context: Context): Map<String, String> {
        return context.resources.openRawResource(R.raw.config).use {
            val properties = Properties()
            properties.load(it)
            properties as Map<String, String>
        }
    }

    fun networkProperties(): NetworkProperties {
        val connectTimeout = properties["http.timeout.connect"]?.toLong() ?: 0
        val readTimeout = properties["http.timeout.read"]?.toLong() ?: 0
        val writeTimeout = properties["http.timeout.write"]?.toLong() ?: 0
        return NetworkProperties(connectTimeout, readTimeout, writeTimeout)
    }

    fun getCatUrl(): String = properties["cat_url"] ?: ""

    fun getDogUrl(): String = properties["dog_url"] ?: ""
}
