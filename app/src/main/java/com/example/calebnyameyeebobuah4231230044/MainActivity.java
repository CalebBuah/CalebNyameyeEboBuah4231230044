package com.example.calebnyameyeebobuah4231230044;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // VIEW REFERENCES
    private EditText etGallons, etKilowatts;
    private TextView tvWater, tvElectricity, tvTotal;
    private Button btnCalculate, btnNew, btnExit;
    private FloatingActionButton fab;

    // UTILITIES
    private NumberFormat currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Currency (Ghana Cedi)
        currency = NumberFormat.getCurrencyInstance(new Locale("en", "GH"));

        //Bind Views
        bindViews();

        // Initialize Result Fields
        resetResults();

        // Button Listeners
        btnCalculate.setOnClickListener(v -> calculateBills());
        btnNew.setOnClickListener(v -> resetForNewTransaction());
        btnExit.setOnClickListener(v -> confirmExit());
        fab.setOnClickListener(v -> showProgrammerInfo());
    }


    // View Binding

    private void bindViews() {
        etGallons = findViewById(R.id.etGallons);
        etKilowatts = findViewById(R.id.etKilowatts);

        tvWater = findViewById(R.id.tvWater);
        tvElectricity = findViewById(R.id.tvElectricity);
        tvTotal = findViewById(R.id.tvTotal);

        btnCalculate = findViewById(R.id.btnCalculate);
        btnNew = findViewById(R.id.btnNew);
        btnExit = findViewById(R.id.btnExit);

        fab = findViewById(R.id.fab);
    }

    // Initialize / Reset Results

    private void resetResults() {
        tvWater.setText(currency.format(0));
        tvElectricity.setText(currency.format(0));
        tvTotal.setText(currency.format(0));
    }

    private void resetForNewTransaction() {
        etGallons.setText("");
        etKilowatts.setText("");
        resetResults();
    }


    // Calculate Bills

    private void calculateBills() {

        if (isInputInvalid()) {
            Toast.makeText(this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
            return;
        }

        double gallons = Double.parseDouble(etGallons.getText().toString().trim());
        double kilowatts = Double.parseDouble(etKilowatts.getText().toString().trim());

        MyBills bills = new MyBills(gallons, kilowatts);

        tvWater.setText(currency.format(bills.waterBill()));
        tvElectricity.setText(currency.format(bills.electricityBill()));
        tvTotal.setText(currency.format(bills.totalBill()));
    }

    private boolean isInputInvalid() {
        return etGallons.getText().toString().trim().isEmpty()
                || etKilowatts.getText().toString().trim().isEmpty();
    }


    // Exit Confirmation

    private void confirmExit() {
        new AlertDialog.Builder(this)
                .setTitle("Exit Application")
                .setMessage("Do you want to exit the application?")
                .setPositiveButton("Yes", (dialog, which) -> finish())
                .setNegativeButton("No", null)
                .show();
    }


    // Floating Action Button – Programmer Info

    private void showProgrammerInfo() {
        new AlertDialog.Builder(this)
                .setTitle("Programmer Information")
                .setMessage(
                        "Name: Caleb Nyameye Ebo Buah\n" +
                                "Index Number: 4231230044\n" +
                                "Telephone: 0533358767"
                )
                .setPositiveButton("OK", null)
                .show();
    }
}
