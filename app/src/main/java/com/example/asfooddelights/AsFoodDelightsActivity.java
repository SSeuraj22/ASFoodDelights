package com.example.asfooddelights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class AsFoodDelightsActivity extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_as_food_delights);
    }

    Order customerOrder = new Order();
    ArrayList<Order> custOrderList = new ArrayList<Order>();
    int count = 1;

    public void onClickCartOrder(View view){
        //Get reference to the spinner meat
        Spinner spin = (Spinner) findViewById(R.id.spinner_option);
        //Get the current selected item in the spinner
        String option = String.valueOf(spin.getSelectedItem());
        customerOrder.setOption(option);

        //RadioButton for meat option
        RadioGroup meatGroup = (RadioGroup) findViewById(R.id.meat);
        int radioIdMeat = meatGroup.getCheckedRadioButtonId();

        //No RadioButton was selected
        if(radioIdMeat == -1){
            //Display a toast
            CharSequence rmText = "Please select a meat";
            int lengthPopUp = Toast.LENGTH_LONG;
            Toast rmToast = Toast.makeText(this, rmText, lengthPopUp);
            rmToast.show();
        }
        else{//a radio button was selected
            RadioButton bMeat = findViewById(radioIdMeat);
            String meatText = bMeat.getText().toString();
            customerOrder.setMeat(meatText);
        }

        //RadioButton for size of box
        RadioGroup sizeBoxGroup = (RadioGroup) findViewById(R.id.box_size);
        int radioIdSize = sizeBoxGroup.getCheckedRadioButtonId();

        //No RadioButton was selected
        if(radioIdSize == -1){
            //Display a toast
            CharSequence rsText = "Please select a box size";
            int lengthPopUp = Toast.LENGTH_LONG;
            Toast rsToast = Toast.makeText(this, rsText, lengthPopUp);
            rsToast.show();
        }
        else{//a radio button was selected
            RadioButton bsSize = findViewById(radioIdSize);
            String sizeText = bsSize.getText().toString();
            customerOrder.setBoxSize(sizeText);
        }

        //For Checkbox
        CheckBox fries = (CheckBox) findViewById(R.id.checkBox_fries);
        CheckBox rice = (CheckBox) findViewById(R.id.checkBox_rice);
        CheckBox macSalad = (CheckBox) findViewById(R.id.checkBox_mac);
        CheckBox potatoSalad = (CheckBox) findViewById(R.id.checkBox_potato);
        CheckBox freshSalad = (CheckBox) findViewById(R.id.checkBox_salad);

        boolean friesChecked = fries.isChecked();
        boolean riceChecked = rice.isChecked();
        boolean macSaladChecked = macSalad.isChecked();
        boolean potatoSaladChecked = potatoSalad.isChecked();
        boolean freshSaladChecked = freshSalad.isChecked();

        if(friesChecked==true){
            String text = "Fries";
            customerOrder.setSide(text);
        }
        if(riceChecked==true){
            String text = "Rice";
            customerOrder.setSide(text);
        }
        if(macSaladChecked==true){
            String text = "Macaroni Salad";
            customerOrder.setSide(text);
        }
        if(potatoSaladChecked==true){
            String text = "Potato Salad";
            customerOrder.setSide(text);
        }
        if(freshSaladChecked==true){
            String text = "Fresh Salad";
            customerOrder.setSide(text);
        }

        if(radioIdMeat!=-1 && radioIdSize!=-1){
            if(customerOrder!=null){
                custOrderList.add(customerOrder);
                CharSequence addCartText = "Order #" + count + " added to Cart";
                count = count + 1;
                int lengthPopUp = Toast.LENGTH_LONG;
                Toast cartToast = Toast.makeText(this, addCartText, lengthPopUp);
                cartToast.show();
            }
        }
        customerOrder = new Order();
    }

    //To serialize object
    String filename = "customerorder.ser";
    File f = new File(filename);
    FileOutputStream outputFile = null;
    ObjectOutputStream outputObject = null;

    {
        try {
            outputFile = new FileOutputStream(filename);
            outputObject  = new ObjectOutputStream(outputFile);
            outputObject.writeObject(custOrderList);
            outputObject.close();
            outputFile.close();
        } catch (IOException as) {
            as.printStackTrace();
        }
    }

    public void onClickCompleteOrder(View view){
        ArrayList<Order> cOrderList;
        FileInputStream inputFile = null;
        ObjectInputStream inputObject = null;

        //Deserialization
        {
            try {
                inputFile = new FileInputStream(filename);
                inputObject = new ObjectInputStream(inputFile);
                custOrderList = (ArrayList<Order>) inputObject.readObject();
                inputObject.close();
                inputFile.close();
            } catch (IOException as) {
                as.printStackTrace();
            } catch (ClassNotFoundException sa) {
                sa.printStackTrace();
            }
        }

        Intent in = new Intent(this, CompleteOrderActivity.class);
        in.putExtra("ORDERS", (Serializable) custOrderList);
        startActivity(in);
    }

    public void onClickDisplayPastOrder(View view){


    }



}