package com.ariasaroject.pararam;

import static org.junit.Assert.*;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit5;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit5.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.ariasaroject.pararam", appContext.getPackageName());
    }
}
