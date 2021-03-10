package com.example.paxandroidinternship;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<WeirdBook> localDataSet;

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public BookViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.textView);
        }

        public void bind(String title) {
            textView.setText(title);
        }
    }

    public BookAdapter() {
        localDataSet = new ArrayList<>();
    }

    @Override public BookViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.viewholder_book, viewGroup, false);
        return new BookViewHolder(view);
    }

    @Override public void onBindViewHolder(BookViewHolder viewHolder, final int position) {
        viewHolder.bind(localDataSet.get(position).getTitle());
    }

    @Override public int getItemCount() {
        return localDataSet.size();
    }

    public void updateBooks(List<WeirdBook> newBooks) {
        localDataSet = newBooks;
        notifyDataSetChanged();
    }
}