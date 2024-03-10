package ru.aidar.app_common.config

data class NetworkProperties(
    val connectTimeout: Long,
    val readTimeout: Long,
    val writeTimeout: Long,
)
