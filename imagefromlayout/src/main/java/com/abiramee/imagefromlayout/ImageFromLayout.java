package com.abiramee.imagefromlayout;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.os.Environment;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageFromLayout {

//    private View mView;
//    private Context mContext;
//    private Bitmap mBitmap;

    public ImageFromLayout() {

    }

    public static Bitmap getBitmap(Context context, View view) {
        view.setDrawingCacheEnabled(true);
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache(true);

        return Bitmap.createBitmap(view.getDrawingCache());
    }

    public static String saveImage(Context context, View view, String fileName, String imageFormat) throws IOException {
        view.setDrawingCacheEnabled(true);
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache(true);

        String filePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        File dir = new File(filePath);
        if(!dir.exists())
            dir.mkdirs();
        File file = new File(dir, fileName + imageFormat);
        FileOutputStream fOut = new FileOutputStream(file);

        Bitmap.createBitmap(view.getDrawingCache()).compress(Bitmap.CompressFormat.PNG, 100, fOut);
        fOut.flush();
        fOut.close();

        return file.getAbsolutePath();
    }

    public static String saveImage(Context context, View view, String filePath, String fileName, String imageFormat) throws IOException {
        view.setDrawingCacheEnabled(true);
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache(true);

        File dir = new File(filePath);
        if(!dir.exists())
            dir.mkdirs();
        File file = new File(dir, fileName + imageFormat);
        FileOutputStream fOut = new FileOutputStream(file);

        Bitmap.createBitmap(view.getDrawingCache()).compress(Bitmap.CompressFormat.PNG, 100, fOut);
        fOut.flush();
        fOut.close();

        return file.getAbsolutePath();
    }
}
