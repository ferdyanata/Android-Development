package mad.com.exercise1;


import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener
{
    private EditText mDateDialog;
    private EditText mLastName;
    private EditText mFirstName;
    private String mNameEntry;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button submitBtn = (Button) findViewById(R.id.submit_button);
        submitBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mFirstName = (EditText) findViewById(R.id.first_name_edit_text);
                mLastName = (EditText) findViewById(R.id.last_name_edit_text);
                mNameEntry = mFirstName.getText().toString() + " " + mLastName.getText().toString();

                Snackbar.make(view, "Hello, " + mNameEntry + "!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mDateDialog = (EditText) findViewById(R.id.date_dialog);
        // Hides keyboard for date of birth
        mDateDialog.setShowSoftInputOnFocus(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int day)
    {
        Calendar cal = new GregorianCalendar(year, month, day);
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        Log.d("VVV", dateFormat.format(cal.getTime()));
        mDateDialog.setText(dateFormat.format(cal.getTime()));
    }

    public void getDate(View v)
    {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getFragmentManager(), "Date dialog");
    }

}

