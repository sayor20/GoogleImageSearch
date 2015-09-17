package com.sayor.org.googleimagesearcher.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.sayor.org.googleimagesearcher.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageResultsActivity extends ActionBarActivity {

    private Intent i;
    private String urlstring;
    private ImageView ivFullURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_results);

        // get intent from first activity
        i  =getIntent();
        //pull ou the extras
        urlstring = i.getStringExtra("url");
        // find the imageview
        // download remotely and load the image
       // Picasso.with(getBaseContext()).load(URL).into(ivFullURL);

        // iamge downloading using android framework without third-party API

        new vanGogh().execute(urlstring);
    }

    private class vanGogh extends AsyncTask<String, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... params) {
            URL url = null;
            Bitmap bitmap = null;
            try {
                url = new URL(params[0]);
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                InputStream inputStream = http.getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            ivFullURL = (ImageView)findViewById(R.id.ivFullURL);
            ivFullURL.setImageBitmap(bitmap);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_image_results, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
