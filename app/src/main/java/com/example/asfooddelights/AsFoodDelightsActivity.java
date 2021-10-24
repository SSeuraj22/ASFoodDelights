package com.example.asfooddelights;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AsFoodDelightsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_as_food_delights);
    }

    Order customerOrder = new Order();
    ArrayList<Order> custOrderList = new ArrayList<>();
    int count = 1;

    public AsFoodDelightsActivity(){

    }

    public void onClickCustOrder(View view){
        //Get reference to the spinner meat
        Spinner spin = (Spinner) findViewById(R.id.spinner_option);
        //Get the current selected item in the spinner
        String option = String.valueOf(spin.getSelectedItem());
        customerOrder.addOption(option);


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
            customerOrder.addMeat(meatText);
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
            customerOrder.addBoxSize(sizeText);
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

        if(friesChecked){
            customerOrder.addSide("fries");
        }
        if(riceChecked){
            customerOrder.addSide("rice");
        }
        if(macSaladChecked){
            customerOrder.addSide("Macaroni Salad");
        }
        if(potatoSaladChecked){
            customerOrder.addSide("Potato Salad");
        }
        if(freshSaladChecked){
            customerOrder.addSide("Fresh Salad");
        }

        if(radioIdMeat!=-1 && radioIdSize!=-1){
            custOrderList.add(customerOrder);
            CharSequence addCartText = "Order #" + count + " added to Cart";
            count = count + 1;
            int lengthPopUp = Toast.LENGTH_LONG;
            Toast cartToast = Toast.makeText(this, addCartText, lengthPopUp);
            cartToast.show();
        }

    }


}