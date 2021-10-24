package com.example.asfooddelights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class CompleteOrderActivity extends AppCompatActivity implements Serializable {
    public static final ArrayList<Order> ORDERS = null;
    String list = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_order);
        Intent in2 = getIntent();
        ArrayList<Order> cOrderList = (ArrayList<Order>) in2.getSerializableExtra("ORDERS");

        int sizeOrderList = cOrderList.size();
        int count = 1;
        TextView orderView = (TextView) findViewById(R.id.view_Order);
        for(Order orderCus: cOrderList){
            if(orderCus!=null && count<=sizeOrderList){
                String opt = orderCus.getOption();
                String meat = orderCus.getMeat();
                String box_size = orderCus.getBoxSize();
                list += "ORDER #" + count + "\n" +
                "Option: " + opt + "\n" +
                "Meat: " + meat + "\n" +
                "Side/s: ";
                count++;
                ArrayList<String> sidesMenu = orderCus.getSides();
                for(String s: sidesMenu){
                    if(sidesMenu.get(sidesMenu.size()-1)==s){
                        list += s + "\n" + "\n";
                    }
                    else{
                        list += s + ", ";
                    }

                }
                orderView.setText(list);
            }
        }
    }

    public void onClicktoWhatsapp(View view){
        Intent inWhatsapp = new Intent(Intent.ACTION_SEND);
        inWhatsapp.setType("text/plain");
        inWhatsapp.setPackage("com.whatsapp");
        inWhatsapp.putExtra(Intent.EXTRA_TEXT, list);

        //Is whatsapp installed on the device?
        if(inWhatsapp.resolveActivity(getPackageManager()) == null){
            CharSequence message = "Need to install Whatsapp first...";
            int lengthPopUp = Toast.LENGTH_LONG;
            Toast messageToast = Toast.makeText(this, message, lengthPopUp);
            messageToast.show();
            return;
        }
        startActivity(inWhatsapp);

    }







}