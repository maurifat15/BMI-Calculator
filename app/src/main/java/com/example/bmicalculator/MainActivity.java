package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtBMIAge, edtBMIWeight,edtBMIHeighFeet,edtBMIHeightInches;
        Button btnBMICalculate;
        TextView bmiResultShowText;
        LinearLayout bmillmain;

        edtBMIAge = findViewById(R.id.edtBMIAge);
        edtBMIWeight = findViewById(R.id.edtBMIWeight);
        edtBMIHeighFeet = findViewById(R.id.edtBMIHeighFeet);
        edtBMIHeightInches = findViewById(R.id.edtBMIHeightInches);
        btnBMICalculate = findViewById(R.id.btnBMICalculate);
        bmiResultShowText = findViewById(R.id.bmiResultShowText);
        bmillmain = findViewById(R.id.bmillmain);

        btnBMICalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                double weight = Integer.parseInt(edtBMIWeight.getText().toString());
                int heightFeet = Integer.parseInt(edtBMIHeighFeet.getText().toString());
                int age = Integer.parseInt(edtBMIAge.getText().toString());
                int heightInches = Integer.parseInt(edtBMIHeightInches.getText().toString());

                /*
                * BMI = (mass in kg) / [(height in m) * (height in m)]
                * To convert feet and inches to meters (since 1 foot = 0.3048 meeters and 1 inch = 0.0254 meters), you'll need to do some conversions for the height part:
                * 1. Convert feet and inches to inches (1 foot = 12 inches).
                * 2. Convert the total inches to meters by multiplying by 0.0254
                * */

                // Convert feet and inches to meters
                double heightM = ((heightFeet * 12) + heightInches) * 0.0254;

                // Calculate BMI
                double bmi = weight / (heightM * heightM);

                //Calculate Ponderal Index (PI)
                double pi = weight / (Math.pow(heightM,3));

                // Initialize BMI Prime
                double bmiPrime = 0.0;
                if (bmi < 16) {
                    // Severe Thinness
                    bmiPrime = bmi / 16; // Calculate BMI Prime
                    // Perform actions or display a message for Severe Thinness
                    bmiResultShowText.setText("\n\n BMI: " +bmi+ " kg/m (Severe Thinness) \n\n BMI Prime: " +bmiPrime+ "\n\n Ponderal Index: " +pi+ " kg/m");
                    bmillmain.setBackgroundColor(getResources().getColor(R.color.bmiBgColo1));
                } else if (bmi >= 16 && bmi < 17) {
                    // Moderate Thinness
                    bmiPrime = (bmi - 16) / (17 - 16) * (0.68 - 0.64) + 0.64; // Calculate BMI Prime
                    // Perform actions or display a message for Moderate Thinness
                    bmiResultShowText.setText("\n\n BMI: " +bmi+ " kg/m (Moderate Thinness) \n\n BMI Prime: " +bmiPrime+ "\n\n Ponderal Index: " +pi+ " kg/m");
                    bmillmain.setBackgroundColor(getResources().getColor(R.color.bmiBgColo2));
                } else if (bmi >= 17 && bmi < 18.5) {
                    // Mild Thinness
                    bmiPrime = (bmi - 17) / (18.5 - 17) * (0.74 - 0.68) + 0.68; // Calculate BMI Prime
                    // Perform actions or display a message for Mild Thinness
                    bmiResultShowText.setText("\n\n BMI: " +bmi+ " kg/m (Mild Thinness) \n\n BMI Prime: " +bmiPrime+ "\n\n Ponderal Index: " +pi+ " kg/m");
                    bmillmain.setBackgroundColor(getResources().getColor(R.color.bmiBgColo3));
                } else if (bmi >= 18.5 && bmi < 25) {
                    // Normal
                    bmiPrime = (bmi - 18.5) / (25 - 18.5) * (1 - 0.74) + 0.74; // Calculate BMI Prime
                    // Perform actions or display a message for Normal
                    bmiResultShowText.setText("\n\n BMI: " +bmi+ " kg/m (Normal) \n\n BMI Prime: " +bmiPrime+ "\n\n Ponderal Index: " +pi+ " kg/m");
                    bmillmain.setBackgroundColor(getResources().getColor(R.color.bmiBgColo4));
                } else if (bmi >= 25 && bmi < 30) {
                    // Overweight
                    bmiPrime = (bmi - 25) / (30 - 25) * (1.2 - 1) + 1; // Calculate BMI Prime
                    // Perform actions or display a message for Overweight
                    bmiResultShowText.setText("\n\n BMI: " +bmi+ " kg/m (Overweight) \n\n BMI Prime: " +bmiPrime+ "\n\n Ponderal Index: " +pi+ " kg/m");
                    bmillmain.setBackgroundColor(getResources().getColor(R.color.bmiBgColo3));
                } else if (bmi >= 30 && bmi < 35) {
                    // Obese Class I
                    bmiPrime = (bmi - 30) / (35 - 30) * (1.4 - 1.2) + 1.2; // Calculate BMI Prime
                    // Perform actions or display a message for Obese Class I
                    bmiResultShowText.setText("\n\n BMI: " +bmi+ " kg/m (Obese Class I) \n\n BMI Prime: " +bmiPrime+ "\n\n Ponderal Index: " +pi+ " kg/m");
                    bmillmain.setBackgroundColor(getResources().getColor(R.color.bmiBgColo2));
                } else if (bmi >= 35 && bmi < 40) {
                    // Obese Class II
                    bmiPrime = (bmi - 35) / (40 - 35) * (1.6 - 1.4) + 1.4; // Calculate BMI Prime
                    // Perform actions or display a message for Obese Class II
                    bmiResultShowText.setText("\n\n BMI: " +bmi+ " kg/m (Obese Class II) \n\n BMI Prime: " +bmiPrime+ "\n\n Ponderal Index: " +pi+ " kg/m");
                    bmillmain.setBackgroundColor(getResources().getColor(R.color.bmiBgColo1));
                } else {
                    // Obese Class III
                    bmiPrime = (bmi - 40) / (bmi - 40); // Calculate BMI Prime
                    // Perform actions or display a message for Obese Class III
                    bmiResultShowText.setText("\n\n BMI: " +bmi+ " kg/m (Obese Class III) \n\n BMI Prime: " +bmiPrime+ "\n\n Ponderal Index: " +pi+ " kg/m");
                    bmillmain.setBackgroundColor(getResources().getColor(R.color.bmiBgColo5));
                }


            }
        });

    }
}