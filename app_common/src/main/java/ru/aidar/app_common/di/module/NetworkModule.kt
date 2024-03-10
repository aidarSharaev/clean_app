package ru.aidar.app_common.di.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import ru.aidar.app_common.config.AppProperties
import ru.aidar.app_common.config.NetworkProperties
import ru.aidar.app_common.data.network.NetworkApiCreator
import ru.aidar.app_common.scope.ApplicationScope
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {
    @Provides
    @ApplicationScope
    fun provideNetworkProperties(appProperties: AppProperties): NetworkProperties {
        return appProperties.networkProperties()
    }

    @Provides
    @ApplicationScope
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor =
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        return interceptor
    }

    @Provides
    @ApplicationScope
    fun provideOkHttpClient(
        networkProperties: NetworkProperties,
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(httpLoggingInterceptor)
            .writeTimeout(networkProperties.writeTimeout, TimeUnit.SECONDS)
            .readTimeout(networkProperties.readTimeout, TimeUnit.SECONDS)
            .connectTimeout(networkProperties.connectTimeout, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    @Provides
    @ApplicationScope
    fun provideApiCreator(
        okHttpClient: OkHttpClient,
        appProperties: AppProperties,
    ): NetworkApiCreator {
        return NetworkApiCreator(
            okHttpClient = okHttpClient,
            catUrl = appProperties.getCatUrl(),
            dogUrl = appProperties.getDogUrl(),
        )
    }
}
