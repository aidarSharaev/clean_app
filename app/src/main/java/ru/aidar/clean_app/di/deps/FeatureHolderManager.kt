package ru.aidar.clean_app.di.deps

import ru.aidar.app_common.di.FeatureApiHolder

class FeatureHolderManager(
    private val mFeatureHolders: Map<Class<*>, FeatureApiHolder>,
) {
    fun <T> getFeature(key: Class<*>): T? {
        val featureApiHolder = mFeatureHolders[key] ?: throw IllegalStateException()
        return featureApiHolder.getFeatureApi<T>()
    }

    fun releaseFeature(key: Class<*>) {
        val featureApiHolder = mFeatureHolders[key] ?: throw IllegalStateException()
        featureApiHolder.releaseFeatureApi()
    }
}
