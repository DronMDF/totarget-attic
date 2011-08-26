package com.mdf.totarget;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.ArrayAdapter;

public class toTarget extends Activity
{
	private EditText inputView;
	private ListView listView;
	private ArrayAdapter listAdapter;

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
		
		listAdapter = new ArrayAdapter<String>(this, R.layout.list_item);

		listView = (ListView)findViewById(R.id.listview);
		listView.setAdapter(listAdapter);
	}

	private void addTask()
	{
		String task = inputView.getText().toString();
		listAdapter.add(task);
		inputView.setText("");

	}
}
