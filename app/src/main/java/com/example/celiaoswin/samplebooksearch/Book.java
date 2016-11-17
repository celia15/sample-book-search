package com.example.celiaoswin.samplebooksearch;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Celia Oswin on 08-11-2016.
 */
//{
//        "id" : "978-0641723445",
//        "cat" : ["book","hardcover"],
//        "name" : "The Lightning Thief",
//        "author" : "Rick Riordan",
//        "series_t" : "Percy Jackson and the Olympians",
//        "sequence_i" : 1,
//        "genre_s" : "fantasy",
//        "inStock" : true,
//        "price" : 12.50,
//        "pages_i" : 384
//        }
public class Book implements Parcelable {
    public String id;
    public List<String> cat;
    public String name;
    public String author;
    public String series_t;
    public String genre_s;
    public double price;
    public int pages_i;

    protected Book(Parcel in) {
        id = in.readString();
        cat = in.createStringArrayList();
        name = in.readString();
        author = in.readString();
        series_t = in.readString();
        genre_s = in.readString();
        price = in.readDouble();
        pages_i = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeStringList(cat);
        dest.writeString(name);
        dest.writeString(author);
        dest.writeString(series_t);
        dest.writeString(genre_s);
        dest.writeDouble(price);
        dest.writeInt(pages_i);
    }
}
