package com.mdf.totarget;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

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

	private Activity activity;
	private EditText editbox;

	public toTargetTest() {
		super("com.mdf.totarget", toTarget.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setActivityInitialTouchMode(false);
		activity = getActivity();
		editbox = (EditText)activity.findViewById(R.id.edittext);
	}

	public void testEditBoxEmptyAfterInit() {
		assertEquals(editbox.getText().toString(), "");
	}
}
