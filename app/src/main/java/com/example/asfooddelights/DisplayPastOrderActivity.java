package com.example.asfooddelights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayPastOrderActivity extends AppCompatActivity {
    public static final String PAST_ORDER = "Past Orders";
    public String pOrdersList = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_past_order);
        Intent pOrders = getIntent();
        String ordersPast = pOrders.getStringExtra(PAST_ORDER);
        TextView tv = (TextView) findViewById(R.id.past_orders);
        pOrdersList = pOrdersList + ordersPast;
        tv.setText(pOrdersList);
    }

}