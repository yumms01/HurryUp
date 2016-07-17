package com.example.jylee.hurryup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jylee.hurryup.routeInfo.RouteResultActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText[] whereInfo;
    private String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        whereInfo = new EditText[2];
        whereInfo[0] = (EditText)findViewById(R.id.text_departure);
        whereInfo[1] = (EditText)findViewById(R.id.text_destination);

        View view = findViewById(R.id.btn_search1);
        view.setTag(0);
        view.setOnClickListener(this);

        view = findViewById(R.id.btn_search2);
        view.setTag(1);
        view.setOnClickListener(this);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SearchHelperActivity.class);
//                intent.putExtra("position",0);
//                intent.putExtra("info", text_departure.getText().toString());
//                startActivityForResult(intent, 0);
//            }
//        });

//        findViewById(R.id.btn_search2).setTag(1);
//        btn = (Button)findViewById(R.id.btn_search2);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SearchHelperActivity.class);
//                intent.putExtra("position",1);
//                intent.putExtra("info", text_destination.getText().toString());
//                startActivityForResult(intent, 1);
//            }
//        });

        Button btn = (Button)findViewById(R.id.btn_lotate);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = whereInfo[0].getText().toString();
                whereInfo[0].setText(whereInfo[1].getText());
                whereInfo[1].setText(temp);
            }
        });

        btn = (Button)findViewById(R.id.btn_routeSearch);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RouteResultActivity.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, SearchHelperActivity.class);
        int position = (int)v.getTag();
        intent.putExtra("position",position);
        intent.putExtra("info", whereInfo[position].getText().toString());
        startActivityForResult(intent, position);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            String info = data.getStringExtra("info");
            whereInfo[requestCode].setText(info);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
