package com.example.jylee.hurryup;

import android.content.Intent;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.skp.Tmap.TMapMarkerItem;
import com.skp.Tmap.TMapPOIItem;
import com.skp.Tmap.TMapPoint;
import com.skp.Tmap.TMapView;

import java.util.ArrayList;

public class SearchHelperActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    private TMapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_helper);

        mapView = (TMapView) findViewById(R.id.map);
        new Thread(new Runnable() {
            @Override
            public void run() {
                mapView.setSKPMapApiKey("bd1e8741-7d62-30c1-920a-5f430065323f");
                mapView.setLanguage(mapView.LANGUAGE_KOREAN);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setUpMap();
                    }
                });
            }
        }).start();

//        TMapView.OnClickListenerCallback click = new TMapView.OnClickListenerCallback() {
//            @Override
//            public boolean onPressEvent(ArrayList<TMapMarkerItem> markers, ArrayList<TMapPOIItem> pois, TMapPoint tMapPoint, PointF pointF) {
//                Toast.makeText(SearchHelperActivity.this, "onPressEvent", Toast.LENGTH_SHORT).show();
//                for (TMapMarkerItem marker : markers) {
//                    if (marker.getID().equals(MARKER_ID_LABEL + "0")) {
//                        Toast.makeText(SearchHelperActivity.this, "first maker press", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                return true;
//            }
//
//            @Override
//            public boolean onPressUpEvent(ArrayList<TMapMarkerItem> markers, ArrayList<TMapPOIItem> pois, TMapPoint tMapPoint, PointF pointF) {
//                Toast.makeText(SearchHelperActivity.this, "onPressEvent", Toast.LENGTH_SHORT).show();
//                for (TMapMarkerItem marker : markers) {
//                    if (marker.getID().equals(MARKER_ID_LABEL + "0")) {
//                        Toast.makeText(SearchHelperActivity.this, "first maker press up", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                return true;
//            }
//            return true;
//        }

        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textView);

        textView.setText(getIntent().getStringExtra("info"));

        Button btn = (Button)findViewById(R.id.btn_departure);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent().putExtra("info", editText.getText().toString());
                setResult(intent.getIntExtra("position", 0), intent);
                finish();
            }
        });
    }

    public void setUpMap() {
        mapView.setCompassMode(true);   // 단말의 방향에 따라 지도를 회전시켜주는 기능
        mapView.setTrackingMode(true);  // 지도의 위치를 현재 단말의 위치로 이동시켜 줌
        mapView.setTrafficInfo(true);   // 지도에 교통정보를 알려줌
        mapView.setSightVisible(true);  // 단말이 가리키는 방향이 지도에서 어디를 보여주고 있는지 나타내 줌
//        mapView.setOnClickListenerCallBack(click);  // 지도가 click 되었을 때 호출되는 함수가 정의되어 있는 interface
//        mapView.setOnLongClickListenerCallback(longclick);  // 지도가 LongClick 되었을 때 호출되는 함수가 정의 되어 있는 interface
//        mapView.setOnCalloutRightButtonClickListener(callout);  // Marker를 click했을 때 보여지는 설명화면의 오른쪽 button 이미지를 click 했을 때 호출되는 함수가 정의된 interface
//        isInitialized = true;
//        if (currentLocation != null) {
//            setCurrentLocation(currentLocation);
//        }
    }
}
