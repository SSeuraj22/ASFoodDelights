package com.example.asfooddelights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class DisplayOrderActivity extends AppCompatActivity implements Serializable {
    public static final ArrayList<Order> ORDERS = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_order);
        Intent in2 = getIntent();
        ArrayList<Order> cOrderList = (ArrayList<Order>) in2.getSerializableExtra("ORDERS");
        String list = "";
        int sizeOrderList = cOrderList.size();
        TextView orderView = (TextView) findViewById(R.id.view_Order);
        for(Order orderCus: cOrderList){
            if(orderCus!=null){
                list += "ORDER #" + sizeOrderList + "\n";
                String opt = orderCus.getOption();
                list = list + "Option: " + opt + "\n";
                orderView.setText(list);
            }
        }



        //Deserialization
        /*try {
            FileInputStream inputFile = new FileInputStream(nameFile);
            ObjectInputStream inputObject = new ObjectInputStream(inputFile);
            cOrderList = (ArrayList<Order>) inputObject.readObject();
            for(Order orderCus: cOrderList){
                if(orderCus!=null){
                    //list += "ORDER #" + sizeOderList + "\n";
                    String opt = orderCus.getOption();
                    list = list + "Option: " + opt + "\n";
                    orderView.setText(list);
                }
            }
            inputObject.close();
            inputFile.close();
        }
        catch (IOException as) {
            as.printStackTrace();
        }
        catch (ClassNotFoundException sa){
            sa.printStackTrace();
        }*/



    }







}