package com.example.agh.fragmentexample;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class OverviewFragment extends Fragment {

    private OverviewFragmentActivityListener _listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1: updateDetail("Elemencie pierwszym."); break;
                    case R.id.button2: updateDetail("Elemencie drugim.");    break;
                    default:                                                 break;
                }
            }
        };

        Button button1 = (Button) view.findViewById(R.id.button1);
        Button button2 = (Button) view.findViewById(R.id.button2);

        button1.setOnClickListener(clickListener);
        button2.setOnClickListener(clickListener);

        return view;
    }

    public interface OverviewFragmentActivityListener {
        public void onItemSelected(String msg);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OverviewFragmentActivityListener) {
            _listener = (OverviewFragmentActivityListener) activity;
        } else {
            throw new ClassCastException(activity.toString());
        }
    }

    public void updateDetail(String msg) {
        _listener.onItemSelected(msg);
    }
}