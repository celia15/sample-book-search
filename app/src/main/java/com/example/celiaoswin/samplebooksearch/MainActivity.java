package com.example.celiaoswin.samplebooksearch;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = (Button) findViewById(R.id.button);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog dialog;
                dialog = new ProgressDialog(MainActivity.this);
                dialog.setMessage("Getting Data ...");
                dialog.setIndeterminate(false);
                dialog.setCancelable(true);
                dialog.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        dialog.dismiss();
                    }
                }, 3000);
                Intent i = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(i);
            }
        });

//        search = (Button)findViewById(R.id.button);
////        TV = (EditText)findViewById(R.id.text);
//
//        search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new Task().execute();
//                     }
//        });
//
//
//    }
//
//    private class Task extends AsyncTask<String, Void, List<Book>>
//    {
//        private ProgressDialog pDialog;
//
//        @Override
//        protected List<Book> doInBackground(String... params) {
//            Gson gson = new Gson();
//            HttpURLConnection urlConnection;
//            URL url = null;
//            try {
//                url = new URL("https://raw.githubusercontent.com/tamingtext/book/master/apache-solr/example/exampledocs/books.json");
//                urlConnection = (HttpURLConnection) url.openConnection();
//                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
//                response = convertStreamToString(in);
//                Log.d ("debug", response);
//                List<Book> books = gson.fromJson(response, new TypeToken<List<Book>>(){}.getType());
//                return books;
//                } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            pDialog = new ProgressDialog(MainActivity.this);
//            pDialog.setMessage("Getting Data ...");
//            pDialog.setIndeterminate(false);
//            pDialog.setCancelable(true);
//            pDialog.show();
//        }
//
//        @Override
//        protected void onPostExecute(List<Book> books) {
//            pDialog.dismiss();
//            Toast.makeText(MainActivity.this, "books loaded: " + books.size() , Toast.LENGTH_LONG).show();
//            Toast.makeText(MainActivity.this, "Starting activity: ", Toast.LENGTH_LONG).show();
//            Intent i = new Intent(MainActivity.this, DetailActivity.class);
//            i.putExtra("key", response);
//            startActivity(i);
//        }
//    }
//    private String convertStreamToString(InputStream is) {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//        StringBuilder sb = new StringBuilder();
//
//        String line;
//        try {
//            while ((line = reader.readLine()) != null) {
//                sb.append(line).append('\n');
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                is.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return sb.toString();
    }
}