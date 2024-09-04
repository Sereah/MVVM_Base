package com.lunacattus.my_base.util

import android.util.Log

object AppLogger {

    enum class Level {
        INFO,
        DEBUG,
        WARNING,
        ERROR
    }

    private fun log(level: Level, tag: String, message: String) {
        val appTag = "[MyBase][App]"
        when (level) {
            Level.INFO -> Log.i(appTag + tag, message)
            Level.DEBUG -> Log.d(appTag + tag, message)
            Level.WARNING -> Log.w(appTag + tag, message)
            Level.ERROR -> Log.e(appTag + tag, message)
        }
    }

    fun i(tag: String, message: String) {
        log(Level.INFO, tag, message)
    }

    fun i(message: String) {
        log(Level.INFO, "", message)
    }

    fun d(tag: String, message: String) {
        log(Level.DEBUG, tag, message)
    }

    fun d(message: String) {
        log(Level.DEBUG, "", message)
    }

    fun w(tag: String, message: String) {
        log(Level.WARNING, tag, message)
    }

    fun w(message: String) {
        log(Level.WARNING, "", message)
    }

    fun e(tag: String, message: String) {
        log(Level.ERROR, tag, message)
    }

    fun e(message: String) {
        log(Level.ERROR, "", message)
    }
}