package com.example.celiaoswin.samplebooksearch;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DescriptionActivity extends AppCompatActivity {

    public ImageView image;
    public TextView price, author, genre, series, pages, cat1, cat2, bookReview;
    public FloatingActionButton floatingActionButton;
    public CollapsingToolbarLayout collapsingToolbar;

    public int imageValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            final Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            setContentView(R.layout.activity_description);

//        String details = (String) getIntent().getSerializableExtra("bookdetails");
            Intent intent = getIntent();
            Book details = getIntent().getParcelableExtra("bookdetails");
            int position = intent.getExtras().getInt("position");

            collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.textView);
            bookReview = (TextView) findViewById(R.id.textView9);
            image = (ImageView) findViewById(R.id.imageView);
            price = (TextView) findViewById(R.id.textView6);
            author = (TextView) findViewById(R.id.textView2);
            genre = (TextView) findViewById(R.id.textView3);
            series = (TextView) findViewById(R.id.textView4);
            pages = (TextView) findViewById(R.id.textView5);
            cat1 = (TextView) findViewById(R.id.textView7);
            cat2 = (TextView) findViewById(R.id.textView8);
            floatingActionButton = (FloatingActionButton) findViewById(R.id.FAB);

            Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
            toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.back, null));
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(DescriptionActivity.this, DetailActivity.class));
                }
            });


//        List<Book> books = new Gson().fromJson(String.valueOf(details), new TypeToken<List<Book>>(){}.getType());

            if (position == 0) {
                imageValue = R.drawable.thief;
                image.setImageResource(R.drawable.thief);
                bookReview.setText(getString(R.string.thiefReview));
            } else if (position == 1) {
                imageValue = R.drawable.monster;
                image.setImageResource(R.drawable.monsters);
                bookReview.setText(getString(R.string.monsterReview));
            } else if (position == 2) {
                imageValue = R.drawable.sophiesicon;
                image.setImageResource(R.drawable.sophiesicon);
                bookReview.setText(getString(R.string.sophiesReview));
            } else {
                imageValue = R.drawable.luceneicon;
                image.setImageResource(R.drawable.luceneicon);
                bookReview.setText(getString(R.string.luceneReview));
            }

            collapsingToolbar.setTitle(details.name);
            String stringdouble = Double.toString(details.price);
            List<String> category = details.cat;
            cat1.setText("#" + category.get(0));
            cat2.setText("#" + category.get(1));
            price.setText("$  " + stringdouble);
            author.setText("Author : " + details.author);
            genre.setText("Type : " + details.genre_s);
            pages.setText("Pages : " + details.pages_i + " pages.");

            if (details.series_t != null) {
                series.setText("\n Other series of this Author : " + details.series_t);
            }


            Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), imageValue);
            Palette.generateAsync(bitmap,
                    new Palette.PaletteAsyncListener() {
                        @Override
                        public void onGenerated(Palette palette) {
                            Log.d("TAG", "palette" + palette);
                            Palette.Swatch vibrant =
                                    palette.getVibrantSwatch();
                            Log.d("TAG", vibrant.toString());

                            int mutedColor = palette.getVibrantSwatch().getRgb();

                            window.setStatusBarColor(getResources().getColor(palette.getDarkVibrantColor(mutedColor)));

                            if (vibrant != null) {
                                collapsingToolbar.setBackgroundColor(mutedColor);
//                            collapsingToolbar.setStatusBarScrimColor(palette.getDarkVibrantColor(mutedColor));
                                collapsingToolbar.setContentScrimColor(palette.getLightMutedColor(mutedColor));
//                            collapsingToolbar.setCollapsedTitleTextColor(palette.getLightMutedColor(mutedColor));
                            }
                        }
                    });
        }
    }

    public void fabClicked(View v) {
        floatingActionButton.setImageDrawable(ContextCompat.getDrawable(DescriptionActivity.this, R.drawable.redheart));
        Toast.makeText(DescriptionActivity.this, "Added to favorite list !", Toast.LENGTH_SHORT).show();
    }

//   public void extractProminentColors(Bitmap bitmap) {
//        int defaultColor = 0x000000;
//
//        Palette p = Palette.from(bitmap).generate();
//
//        int mutedColor = p.getLightMutedColor(defaultColor);
//       collapsingToolbar.setCollapsedTitleTextColor(mutedColor);
//
//       int vibrantColor = p.getDarkVibrantColor(defaultColor);
//        collapsingToolbar.setStatusBarScrimColor(vibrantColor);
//    }
}
