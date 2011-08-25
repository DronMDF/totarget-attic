package com.mdf.totarget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.EditText;
import android.view.View.OnKeyListener;
import android.view.KeyEvent;
import android.view.View;

public class toTarget extends Activity
{
	private EditText inputView;

	private final OnKeyListener keyListener = new OnKeyListener() {
		public boolean onKey(View view, int keyCode, KeyEvent event) {
			if (keyCode != KeyEvent.KEYCODE_ENTER) {
				return false;
			}

			if (event.getAction() != KeyEvent.ACTION_DOWN) {
				return false;
			}

			addTask();
			return true;
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		inputView = (EditText)findViewById(R.id.edittext);
		inputView.setOnKeyListener(keyListener);
	}

	private void addTask()
	{
		String task = inputView.getText().toString();
		Toast.makeText(toTarget.this, task, Toast.LENGTH_SHORT).show();
		inputView.setText("");
	}
}
