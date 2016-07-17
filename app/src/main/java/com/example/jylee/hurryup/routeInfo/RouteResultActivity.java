package com.example.jylee.hurryup.routeInfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.jylee.hurryup.DetailRouteInfoActivity;
import com.example.jylee.hurryup.R;

import java.util.List;

public class RouteResultActivity extends AppCompatActivity {

    ListView listView;
    RouteResultAdapter list_mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_result);

        listView = (ListView)findViewById(R.id.listView);
        list_mAdapter = new RouteResultAdapter();
        list_mAdapter.setOnAdapterItemClickListener(new RouteResultAdapter.OnAdapterItemClickListener() {
            @Override
            public void onAdapterItemClickListener(RouteResultAdapter adapter, RouteResultView view, RouteData item, int position) {
                Intent intent = new Intent(RouteResultActivity.this, DetailRouteInfoActivity.class);
                startActivity(intent);
            }
        });

        listView.setAdapter(list_mAdapter);
    }
}
