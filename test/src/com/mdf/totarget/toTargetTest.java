package com.mdf.totarget;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.widget.EditText;

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

	public void testEditBoxEmptyAfterEnter() {
		activity.runOnUiThread(new Runnable() {
			public void run() {
				editbox.requestFocus();
			}
		});

		sendKeys(KeyEvent.KEYCODE_T, KeyEvent.KEYCODE_E, KeyEvent.KEYCODE_S, KeyEvent.KEYCODE_T);
		assertEquals(editbox.getText().toString(), "test");
		sendKeys(KeyEvent.KEYCODE_ENTER);
		assertEquals(editbox.getText().toString(), "");
	}
}
