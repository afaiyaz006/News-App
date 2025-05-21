package com.faiyaz.dummy_news_app

import android.app.Application
import com.faiyaz.dummy_news_app.di.AppContainer

class NewsApplication:Application() {
    lateinit var container: AppContainer
    override fun onCreate(){
        super.onCreate()
        container = AppContainer(this)
    }
}