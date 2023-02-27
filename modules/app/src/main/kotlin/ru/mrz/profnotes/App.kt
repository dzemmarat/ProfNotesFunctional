package ru.mrz.profnotes

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin(this)
        setupNavigator()
    }
}