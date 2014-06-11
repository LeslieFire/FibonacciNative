package com.seefeel.android.fibonaccinative;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FibonacciActivity extends Activity implements OnClickListener {

	private EditText input;
	private RadioGroup type;
	private TextView output;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fibonacci);
		
		this.input = (EditText) super.findViewById(R.id.input);
		this.type = (RadioGroup) super.findViewById(R.id.type);
		this.output = (TextView) super.findViewById(R.id.output);
		
		Button button = (Button) super.findViewById(R.id.button);
		button.setOnClickListener(this);
		
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fibonacci, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_fibonacci,
					container, false);
			return rootView;
		}
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String s = this.input.getText().toString();
		if (TextUtils.isEmpty(s)){
			return;
		}
		
		final ProgressDialog dialog = ProgressDialog.show(this, "", "Calculating", true);
		final long n = Long.parseLong(s);
		new AsyncTask<Void, Void, String>() {

			@Override
			protected String doInBackground(Void... arg0) {
				// TODO Auto-generated method stub
				long result = 0;
				long t = System.currentTimeMillis();
				switch(FibonacciActivity.this.type.getCheckedRadioButtonId()){
				case R.id.type_fib_jr:
					result = FibLib.fibJR(n);
					break;
				case R.id.type_fib_ji:
					result = FibLib.fibJI(n);
					break;
				case R.id.type_fib_nr:
					result = FibLib.fibNR(n);
					break;
				case R.id.type_fib_ni:
					result = FibLib.fibNI(n);
					break;
				}
				t = System.currentTimeMillis() - t;
				return String.format("fib(%d)=%d in %d ms", n, result, t );
			}

			@Override
			protected void onPostExecute(String result) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				FibonacciActivity.this.output.setText(result);
			}
			
		}.execute();
		
		
	}

}
