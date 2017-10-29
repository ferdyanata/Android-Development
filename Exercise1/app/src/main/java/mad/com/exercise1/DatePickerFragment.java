package mad.com.exercise1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import java.util.Calendar;

/**
 * Created by Ferdy on 25/10/2017.
 * Resources used: http://en.proft.me/2017/05/4/android-time-and-date-picker-tutorial/
 */

public class DatePickerFragment extends DialogFragment
{
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        int themeResId = 2;
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), R.style.DatePicker,
                (DatePickerDialog.OnDateSetListener)
                    getActivity(), year, month, day);
    }
}
