package ru.aidar.app_common.base

sealed class ScreenState() {
    object Fail : ScreenState()

    object Success : ScreenState()

    object Execution : ScreenState()
}
