package com.example.asfooddelights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DisplayOrderActivity extends AppCompatActivity {
    public static final String FILE_NAME = "file name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_order);
        Intent in2 = getIntent();
        String nameFile = in2.getStringExtra(FILE_NAME);
        ArrayList<Order> cOrderList = new ArrayList<Order>();

        try {
            FileInputStream inputFile = new FileInputStream(nameFile);
            ObjectInputStream inputObject = new ObjectInputStream(inputFile);
            cOrderList = (ArrayList<Order>) inputObject.readObject();
            inputObject.close();
            inputFile.close();
        }
        catch (IOException as) {
            as.printStackTrace();
        }
        catch (ClassNotFoundException sa){
            sa.printStackTrace();
        }

        TextView orderView = (TextView) findViewById(R.id.view_Order);

        int sizeOderList = cOrderList.size();
        //orderView.setText(nameFile);
        String list = "";
        for(Order orderCus: cOrderList){
            //list += "ORDER #" + sizeOderList + "\n";
            String opt = orderCus.getOption();
            list = list + "Option: " + opt + "\n";

        }
        //orderView.setText("Shalana\nSeuraj");

        orderView.setText(list);
    }







}