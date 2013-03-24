package cdl.android.ui.message;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import cdl.android.R;

public class ReadMessage extends Activity {
	
	Context context;
	//private String receiver;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		context = this;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.message_list_item);

		Bundle data = getIntent().getExtras();

		TextView subject = (TextView) findViewById(R.id.subject);
		subject.setText(data.getString("subject"));

		TextView from = (TextView) findViewById(R.id.from);
		from.setText(data.getString("from"));

		TextView text = (TextView) findViewById(R.id.text);
		text.setText(data.getString("text"));
		
		//receiver = data.getString("nickname");

		Button back = (Button) findViewById(R.id.readmsg);
		back.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
		
		Button reply = (Button) findViewById(R.id.reply);
		reply.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, CreateMessage.class);
				TextView subject = (TextView) findViewById(R.id.subject);
				//i.putExtra("receiver", receiver);
				i.putExtra("subject", "Re: " + subject.getText());
				startActivity(i);
				finish();
			}
		});
	}
}