package com.ariasaproject.pararam

import static org.junit.Assert.*

import android.content.Context
import android.support.test.InstrumentationRegistry

import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4

@RunWith(AndroidJUnit4.class)
class ExampleAndroidUnitTest {
    @Test fun useAppContext() {
        var appContext : Context
        appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.ariasaproject.pararam", appContext.getPackageName())
    }
}
