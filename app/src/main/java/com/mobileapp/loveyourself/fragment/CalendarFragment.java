package com.mobileapp.loveyourself.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobileapp.loveyourself.R;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.Date;

public class CalendarFragment extends Fragment {

    MaterialCalendarView calendarView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        calendarView = (MaterialCalendarView) view.findViewById(R.id.calendarView);
        Date date = new Date();
        calendarView.setDateSelected(date, true);
        calendarView.setSelectionMode(MaterialCalendarView.SELECTION_MODE_MULTIPLE);
        return view;
    }

}
