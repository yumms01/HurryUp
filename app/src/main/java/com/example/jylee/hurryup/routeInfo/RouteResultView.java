package com.example.jylee.hurryup.routeInfo;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jylee.hurryup.R;

public class RouteResultView extends FrameLayout {
    public RouteResultView(Context context) {
        super(context);
        init();
    }

    ImageView imageView;
    TextView textView;
    RouteData data;

    public interface OnImageClickListener {
        public void onImageClick(RouteResultView view, RouteData data);
    }

    OnImageClickListener mImageClickListener;

    public void setOnImageClickListener(OnImageClickListener listener) {
        mImageClickListener = listener;
    }

    private void init() {
        inflate(getContext(), R.layout.view_route_result, this);
        imageView = (ImageView)findViewById(R.id.imageView);
        textView = (TextView)findViewById(R.id.textView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImageClickListener != null) {
                    mImageClickListener.onImageClick(RouteResultView.this, data);
                }
            }
        });
    }

    public void setData(RouteData d) {
        this.data = d;
        textView.setText(d.route);
    }
}