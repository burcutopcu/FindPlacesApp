package com.burcutopcu.findplacesapp.fakes

import com.google.gson.Gson
import com.google.gson.GsonBuilder

class FakeGlobalGson {
    fun getFakeGlobalJson(): Gson? {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }
}