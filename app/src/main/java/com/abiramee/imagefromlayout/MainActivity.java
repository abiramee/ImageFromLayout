package com.abiramee.imagefromlayout;



import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout mLinearLayoutParentLayout;
    private Button mButtonShowImage;
    private Button mButtonSaveImage;
    private Bitmap mBitMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                1);

        init();
        clickListener();
    }

    private void init() {
        mLinearLayoutParentLayout = findViewById(R.id.parent_layout);
        mButtonShowImage = findViewById(R.id.button_show_image);
        mButtonSaveImage = findViewById(R.id.button_save_image);
        mBitMap = ImageFromLayout.getBitmap(getApplicationContext(), mLinearLayoutParentLayout);
    }

    private void clickListener() {
        mButtonShowImage.setOnClickListener(this);
        mButtonSaveImage.setOnClickListener(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(MainActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    private void showDialog() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.alert_dialog, null);
        dialog.setView(view);
        dialog.setCancelable(true);

        final AlertDialog alertDialog = dialog.create();
        alertDialog.show();

        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageBitmap(mBitMap);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_show_image:
                showDialog();
                break;
            case R.id.button_save_image:
                try {
                    Toast.makeText(this, "File saved in: "  + ImageFromLayout.saveImage(getApplicationContext(), mLinearLayoutParentLayout, "filePath", "fileName", Format.JPG), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("error", e.toString());
                }
        }
    }
}
