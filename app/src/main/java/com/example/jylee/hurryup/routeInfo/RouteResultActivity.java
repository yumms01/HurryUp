package com.example.jylee.hurryup.routeInfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jylee.hurryup.DetailRouteInfoActivity;
import com.example.jylee.hurryup.R;

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
                Toast.makeText(RouteResultActivity.this, "DetailRouteInfoActivity로 이동", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        listView.setAdapter(list_mAdapter);
        initData();
    }

    private void initData() {
        for (int i=1 ; i<=5 ; i++) {
            RouteData rd = new RouteData();
            rd.route = "경로" + i;
            list_mAdapter.add(rd);
        }
    }
}
