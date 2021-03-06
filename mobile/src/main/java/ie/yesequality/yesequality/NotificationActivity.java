package ie.yesequality.yesequality;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class NotificationActivity extends Activity {

    @InjectView(R.id.switchDayBefore) Switch dayBefore;
    @InjectView(R.id.switchOnDay) Switch onDay;
    @InjectView(R.id.okButton) Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.inject(this);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        onDay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    //Register Alarm
                    registerAlarm(true);
                }
                else {
                    //Cancel Alarm
                    cancelAlarm(true);
                }
            }
        });

        dayBefore.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    //Register Alarm
                    registerAlarm(false);
                }
                else {
                    //Cancel Alarm
                    cancelAlarm(false);
                }
            }
        });

    }

    private void registerAlarm(boolean onDay) {
        if (onDay){
            // Register alarm for voting day
            Log.d("NotificationActivity", "Registering Alarm for Voting day");
        }
        else {
            // Register alarm for day before voting day
            Log.d("NotificationActivity", "Registering Alarm for day before Voting day");

        }
    }

    private void cancelAlarm(boolean onDay) {
        if (onDay){
            // Canceling alarm for voting day
            Log.d("NotificationActivity", "Canceling Alarm for Voting day");
        }
        else {
            // Canceling alarm for day before voting day
            Log.d("NotificationActivity", "Canceling Alarm for day before Voting day");

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notification, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
