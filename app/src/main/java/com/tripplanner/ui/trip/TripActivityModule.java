package com.tripplanner.ui.trip;

import android.app.DatePickerDialog;

import com.tripplanner.data.DataManager;
import com.tripplanner.data.model.api.trip.TripDetailsRequest;
import com.tripplanner.utils.rx.SchedulerProvider;

import java.util.Calendar;

import dagger.Module;
import dagger.Provides;

import static com.tripplanner.utils.AppConstants.DESTINATION_AIRPORT_CODE;
import static com.tripplanner.utils.AppConstants.NUMBER_OF_TICKETS;
import static com.tripplanner.utils.AppConstants.ORIGIN_AIRPORT_CODE;

/**
 * Created by suyashg on 10/06/18.
 */
@Module
public class TripActivityModule {

    @Provides
    TripViewModel provideTripViewModel(SchedulerProvider schedulerProvider, DataManager dataManager) {
        return new TripViewModel(schedulerProvider, dataManager);
    }

    @Provides
    TripDetailsRequest provideTripDetailsRequest() {
        return new TripDetailsRequest(ORIGIN_AIRPORT_CODE, DESTINATION_AIRPORT_CODE, Calendar.getInstance().getTimeInMillis(),
                Calendar.getInstance().getTimeInMillis(), NUMBER_OF_TICKETS);
    }

    @Provides
    DatePickerDialog provideDatePickerDialog(TripActivity tripActivity) {
        final Calendar c = Calendar.getInstance();
        return new DatePickerDialog(tripActivity, tripActivity, c.get(Calendar.YEAR), c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH));
    }
}
