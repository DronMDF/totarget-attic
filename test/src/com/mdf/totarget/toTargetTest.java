package com.mdf.totarget;

import android.test.ActivityInstrumentationTestCase2;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.mdf.totarget.toTargetTest \
 * com.mdf.totarget.tests/android.test.InstrumentationTestRunner
 */
public class toTargetTest extends ActivityInstrumentationTestCase2<toTarget> {

    public toTargetTest() {
        super("com.mdf.totarget", toTarget.class);
    }

}
