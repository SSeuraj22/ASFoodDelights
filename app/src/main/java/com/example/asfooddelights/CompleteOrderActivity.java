package com.example.asfooddelights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class CompleteOrderActivity extends AppCompatActivity implements Serializable {
    public static final ArrayList<Order> ORDERS = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_order);
        Intent in2 = getIntent();
        ArrayList<Order> cOrderList = (ArrayList<Order>) in2.getSerializableExtra("ORDERS");
        String list = "";
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