package com.example.paxandroidinternship;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomViewModel extends ViewModel {
    private List<String> nouns =
        Arrays.asList("shark", "cat", "candy", "flower", "mountain", "sunshine", "phone", "tree", "bird", "snake",
            "blanket", "fire");
    private List<WeirdBook> shelf = new ArrayList<>();
    private MutableLiveData<List<WeirdBook>> books;

    public LiveData<List<WeirdBook>> getBooks() {
        if (books == null) {
            books = new MutableLiveData<>();
            addBook();
            addBook();
            addBook();
        }
        return books;
    }

    public WeirdBook addBook() {
        double random = Math.random();
        WeirdBook newBook;
        if (random < 0.2) {
            newBook = new WeirdBook("The " + randomNoun() + " and the " + randomNoun(), (int) (Math.random() * 50));
        } else if (random < 0.4) {
            newBook = new WeirdBook("A  dark " + randomNoun(), (int) (Math.random() * 50));
        } else if (random < 0.6) {
            newBook = new WeirdBook("My " + randomNoun(), (int) (Math.random() * 50));
        } else if (random < 0.8) {
            newBook = new WeirdBook("The history of the " + randomNoun(), (int) (Math.random() * 50));
        } else {
            newBook = new WeirdBook(randomNoun() + " on a " + randomNoun(), (int) (Math.random() * 50));
        }
        shelf.add(newBook);
        books.setValue(shelf);
        return newBook;
    }

    private String randomNoun() {
        return nouns.get((int) (nouns.size() * Math.random()));
    }
}
