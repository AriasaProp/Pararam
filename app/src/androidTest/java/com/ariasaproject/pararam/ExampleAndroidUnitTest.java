package com.ariasaproject.pararam;

import static org.junit.Assert.*;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit6;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit6.class)
public class ExampleAndroidUnitTest {
    @Test
    public void useAppContext() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.ariasaproject.pararam", appContext.getPackageName());
    }
}
