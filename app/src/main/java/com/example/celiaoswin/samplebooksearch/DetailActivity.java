package com.example.celiaoswin.samplebooksearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity implements Serializable {

    private RecyclerView recyclerView;
    private BookAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

//        Bundle bundle = getIntent().getExtras();
//        message = bundle.getString("key");
//        List<Book> books = new Gson().fromJson(message, new TypeToken<List<Book>>(){}.getType());
//        Log.d("TAG", "books size:" + books.size());

        final ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Book>> call = service.getBooks();
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                final List<Book> booklist = response.body();
                mAdapter = new BookAdapter(booklist);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(mAdapter);
                mAdapter.SetOnItemClickListener(new BookAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        Intent next = new Intent(DetailActivity.this, DescriptionActivity.class);
                        next.putExtra("bookdetails", booklist.get(position));
//                      next.putExtra("bookdetails", (Serializable) booklist.get(position));
                        next.putExtra("position", position);
//                      Log.d ("TAG", "book"+ booklist.get(position));
                        startActivity(next);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
            }
        });
    }
}