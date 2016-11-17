package com.example.celiaoswin.samplebooksearch;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Celia Oswin on 08-11-2016.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<Book> bookList;
    OnItemClickListener onItem;


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView nm, author, amount;
        public ImageView image;


        public ViewHolder(View itemView) {
            super(itemView);
            nm = (TextView) itemView.findViewById(R.id.name);
            author = (TextView) itemView.findViewById(R.id.author);
            amount = (TextView) itemView.findViewById(R.id.amount);
            image = (ImageView) itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onItem != null) {
                onItem.onItemClick(v, getPosition());
            }
        }
    }

    public BookAdapter(List<Book> Book) {
        this.bookList = Book;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = bookList.get(position);

        if (position == 0)
            holder.image.setImageResource(R.drawable.thieficon);
        else if (position == 1)
            holder.image.setImageResource(R.drawable.monstericon);
        else if (position == 2)
            holder.image.setImageResource(R.drawable.sophiesicon);
        else
            holder.image.setImageResource(R.drawable.luceneicon);

        holder.nm.setText(book.name);
        holder.author.setText(book.author);
        String stringdouble = Double.toString(book.price);
        holder.amount.setText("$ " + stringdouble);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public interface OnItemClickListener {
        public void onItemClick(View v, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.onItem = mItemClickListener;
    }
}
