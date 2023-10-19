package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edtWriteAName;
    private TextView txtOutput;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finding the view by id
        edtWriteAName = findViewById(R.id.edtWriteAName);
        txtOutput = findViewById(R.id.txtOutput);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                txtOutput.setText(edtWriteAName.getText().toString());
            }
        });






        //        House myHouse = new House(73, "wood", "San Ramon", 10);
//        House mFriendsHouse = new House(68, "carpet", "Livermoore", 12);

//        String mHouseFlooring = myHouse.flooring;
//        System.out.println(mHouseFlooring);
//        String mCityOfHouse = myHouse.cityOfHouse = "Livermore";
//        System.out.println(mCityOfHouse);
//        int mFriendTemp = mFriendsHouse.temperature;
//        System.out.println(mFriendTemp);
//        myHouse.checkTemp();
        //iteration for loops and while loops
//
//        ArrayList<String> cars = new ArrayList();
//        cars.add("Lamborghini");
//        cars.add("Mclaren");
//        cars.add("Mercedes");
//        cars.add("Acura");
//        cars.add("Ferrari");
////
//       cars.set(1, "Toyota");
//        //while loop
//        int c=0;
//        while (c<cars.size()) {
//            System.out.println(cars.get(c));
//            c++;
//        }
//
//        //do while loop
//        int i = 0;
//        do{
//            //whatever you want to do
//            System.out.println("Number " +i);
//            i++;
//        } while(i < 5);

        //for loops
//    for(int c = 0; c<cars.size(); c++) {
//        System.out.println(cars.get(c));
//    }


//        ArrayList<String> celebrities = new ArrayList();
//        celebrities.add("Tom Holland");
//        celebrities.add("Tom Cruise");
//        celebrities.add("Miley Cyrus");
//        celebrities.add("Natalie Portman");
//        celebrities.add("Katy Perry");
//        celebrities.add("Vin Diesel");
//        celebrities.remove(0);
//        celebrities.set(0, "Jennifer Lopez");
//        //celebrities.clear();

        //operators
//        int a = 1;
//        int b = 6;
//        if(a < b) {
//            System.out.println("A is less than B");
//        }else if(a > b) {
//            System.out.println("A is greater than b");
//        }else {
//            System.out.println("A is equal to b");
//        }

        //var = (condition) ? expressionTrue : expressionFalse;

//        int carsInGarage = 6;
//        if(carsInGarage > 2) {
//            System.out.println("Wow, that's a lot of cars");
//        }else if(carsInGarage ==1) {
//            System.out.println("That's a normal amount of cars");
//        }else{
//            System.out.println("Nice Cars");
//        }

        //shorter way

//        int carsInGarage = 6;
//        String answer = (carsInGarage > 2) ? "Wow, that's a lot of cars" : "Nice Cars";
//        System.out.println(answer);

//        String mcity = "San Francisco";
//        ArrayList<String> cities = new ArrayList();
//        cities.add("San Francisco");
//        cities.add("Dallas");
//        cities.add("Cleveland");
//        cities.add("Tampa");
//        cities.add("Los Angelos");
//
//        for(int c = 0; c<cities.size(); c++) {
//            if(cities.get(c) == mcity) {
//                System.out.println("My favorite city is San Fransisco");
//            }
   }

}