package com.somnath_land_share_calculator.somnathlandsharecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText ownershare1,land1,katha2,chatak2,sqft2,total_land2;
    private TextView katha1,chatak1,sqft1,ownershare2,land_shatak1,land_shatak2;
    private double ownershare1_val,land1_val,his_land1,land2,his_share,katha2_val,chatak2_val,sqft2_val;
    private int katha1_val,chathk1_val,sqft1_val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ////////////////////////////////////////////////
        /*for cal1*/
        ownershare1= findViewById(R.id.ownershare1);
        land1=findViewById(R.id.land1);
        katha1=findViewById(R.id.katha1);
        chatak1= findViewById(R.id.chatak1);
        sqft1=findViewById(R.id.sqft1);
        land_shatak1=findViewById(R.id.land_shatak1);

        /*for cal2*/
        ownershare2= findViewById(R.id.ownershare2);
        total_land2=findViewById(R.id.land2);
        katha2=findViewById(R.id.katha2);
        chatak2= findViewById(R.id.chatak2);
        sqft2=findViewById(R.id.sqft2);
        land_shatak2=findViewById(R.id.land_shatak2);


        /////////////////////////////////////////////////
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ////////////////////////////////////////////////

        changeCrusor();

    }

    public void changeCrusor(){
        StringBuilder sb=new StringBuilder();
        ownershare1.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String[] list =s.toString().split("\\.");

                if(list.length==2){
                    if(list[1].length()>3){
                        ownershare1.clearFocus();
                        land1.requestFocus();
                        land1.setCursorVisible(true);
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {}

            public void afterTextChanged(Editable s) {}
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("About");
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NotNull MenuItem item){
        if(item.getTitle().equals("About")){
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);}


    public void closeKeyboard(View view){
        if(view!=null){
            InputMethodManager imm= (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
    ///////////////////////////////////////////////////
    public void calculation1(View view){


        try{

            if(ownershare1.getText().toString().equals("")){ownershare1_val=0;}
            else{ownershare1_val=Double.parseDouble(ownershare1.getText().toString());}

            if(land1.getText().toString().equals("")){ land1_val=0;}
            else{land1_val=Double.parseDouble(land1.getText().toString());}


            his_land1=Math.ceil((ownershare1_val)*(land1_val)*(435.6));


            katha1_val=(int) his_land1/720;
            his_land1=his_land1%720;
            chathk1_val = (int)his_land1/45;

            his_land1=his_land1%45;
            sqft1_val=(int) his_land1;

            DecimalFormat output=new DecimalFormat("0.0000");
            output.setRoundingMode(RoundingMode.FLOOR);
            land_shatak1.setText(output.format(ownershare1_val*land1_val));

            katha1.setText(Integer.toString(katha1_val));
            chatak1.setText(Integer.toString(chathk1_val));
            sqft1.setText(Integer.toString(sqft1_val));

            ownershare1.setText("");
            land1.setText("");
        }


        catch(Exception e){
            katha1.setText("");
            chatak1.setText("");
            sqft1.setText("");

            ownershare1.setText("");
            land1.setText("");
            land_shatak1.setText("");}
        finally {
            closeKeyboard(view);
        }

    }

    public void calculation2(View view){

        try {



            if(katha2.getText().toString().equals("")){katha2_val=0;}
            else{ katha2_val = Double.parseDouble(katha2.getText().toString());}

            if(chatak2.getText().toString().equals("")){ chatak2_val=0;}
            else{chatak2_val = Double.parseDouble(chatak2.getText().toString());}

            if(sqft2.getText().toString().equals("")){sqft2_val=0;}
            else{sqft2_val = Double.parseDouble(sqft2.getText().toString());}

            if(total_land2.getText().toString().equals("")){ land2=0;}
            else{land2 = Double.parseDouble(total_land2.getText().toString());}



            his_share = (720 * katha2_val + 45 * chatak2_val + sqft2_val) / (land2 * 435.6);

            DecimalFormat output=new DecimalFormat("0.0000");
            output.setRoundingMode(RoundingMode.FLOOR);
            ownershare2.setText(output.format(his_share));
            land_shatak2.setText(output.format(his_share* land2));

            katha2.setText("");
            chatak2.setText("");
            sqft2.setText("");
            total_land2.setText("");


        }


        catch(Exception e){
                ownershare2.setText("");

                katha2.setText("");
                chatak2.setText("");
                sqft2.setText("");
                land_shatak2.setText("");
                total_land2.setText("");}

        finally {
            closeKeyboard(view);
        }
    }
}