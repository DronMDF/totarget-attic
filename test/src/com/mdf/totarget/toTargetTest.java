package com.mdf.totarget;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ListView;

public class toTargetTest extends ActivityInstrumentationTestCase2<toTarget> {

	private EditText editbox;
	private ListView listview;

	public toTargetTest() {
		super("com.mdf.totarget", toTarget.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setActivityInitialTouchMode(false);

		Activity activity = getActivity();
		editbox = (EditText)activity.findViewById(R.id.edittext);
		listview = (ListView)activity.findViewById(R.id.listview);
	}

	public void testEditBoxEmptyAfterInit() {
		assertEquals(editbox.getText().toString(), "");
	}

	public void testEditBoxEmptyAfterEnter() {
		//activity.runOnUiThread(new Runnable() {
		//	public void run() {
		//		editbox.requestFocus();
		//	}
		//});

		sendKeys("T E S T");
		assertEquals(editbox.getText().toString(), "test");
		sendKeys("ENTER");
		assertEquals(editbox.getText().toString(), "");
	}

	public void testTaskPushIntoFirstLine() {
		sendKeys("F I R S T ENTER");
		sendKeys("S E C O N D ENTER");
		assertEquals(listview.getAdapter().getItem(0).toString(), "second");
		assertEquals(listview.getAdapter().getItem(1).toString(), "first");
	}

}
