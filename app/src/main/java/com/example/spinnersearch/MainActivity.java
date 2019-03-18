package com.example.spinnersearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  ArrayList<String> items = new ArrayList<>();
  SpinnerDialog spinnerDialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    final TextView selectedItems = findViewById(R.id.txt);

    items.add("Dhaka");
    items.add("Delhi");
    items.add("Chittagong");
    items.add("Bangladesh");
    items.add("India");
    items.add("America");
    items.add("Boshundhara");
    items.add("Appolo");
    items.add("Kolkata");
    items.add("Jamalput");
    items.add("Jhenidah");
    items.add("Nikunjo");

    spinnerDialog = new SpinnerDialog(MainActivity.this, items,
        "Select or Search Hospital");

    spinnerDialog.setCancellable(true);
    spinnerDialog.setShowKeyboard(false);

    spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
      @Override
      public void onClick(String item, int position) {
        Toast.makeText(MainActivity.this, item + "  " + position + "", Toast.LENGTH_SHORT).show();
        selectedItems.setText(item + " Position: " + position);
      }
    });

    findViewById(R.id.layout).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        spinnerDialog.showSpinerDialog();
      }
    });
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    spinnerDialog.closeSpinerDialog();
  }
}