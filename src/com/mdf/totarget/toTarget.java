package com.mdf.totarget;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class toTarget extends Activity
{
	private EditText inputView;
	private ListView listView;
	private ArrayAdapter listAdapter;

	private final View.OnKeyListener keyListener = new View.OnKeyListener() {
		public boolean onKey(View view, int keyCode, KeyEvent event) {
			if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
				addTask();
				return true;
			}

			return false;
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		inputView = (EditText)findViewById(R.id.edittext);
		inputView.setOnKeyListener(keyListener);
		
		listAdapter = new ArrayAdapter<String>(this, R.layout.task_item);

		listView = (ListView)findViewById(R.id.listview);
		listView.setAdapter(listAdapter);
	}

	private void addTask()
	{
		String task = inputView.getText().toString();
		listAdapter.insert(task, 0);
		inputView.setText("");
	}
}
