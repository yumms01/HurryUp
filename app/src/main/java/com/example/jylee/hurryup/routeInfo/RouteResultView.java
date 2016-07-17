package com.example.jylee.hurryup.routeInfo;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.jylee.hurryup.R;

public class RouteResultView extends FrameLayout {
    public RouteResultView(Context context) {
        super(context);
    }

    TextView textView;
    RouteData item;

    private void init() {
        inflate(getContext(), R.layout.view_route_result, this);
        textView = (TextView)findViewById(R.id.textView);
    }

    public void setData(RouteData d) {
        this.item = d;
        textView.setText(d.route + "경로");
    }
}