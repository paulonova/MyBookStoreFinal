package paulo.android.nackademin.mybookstorefinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CartListActivity extends AppCompatActivity {

    ArrayAdapter cartAdapter;
    private CoordinatorLayout coordinatorLayout;
    ArrayAdapter<String> stringAdapter;

    //List<Book> bookListToCart;
    Book storedBook;
    ListView cartListView;
    List<String> messageArray = new ArrayList<>();
    //String[] messageArray = {"There is no Book in your cart!"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Get the extra sends from Intent
        Intent intent = getIntent();
        String bookNameRequest = intent.getStringExtra(MainActivity.SENDING_BOOK_NAME);

        // Getting the bookName stored by DetailActivity
        SharedPreferences preferences = getSharedPreferences(DetailActivity.BOOK_NAME, Context.MODE_PRIVATE);
        String sharedText = preferences.getString(DetailActivity.BOOK_NAME, null);
        Log.d("SHARED_PREFERENCES TEXT:", sharedText);


        storedBook = Bookstore.getBookContent(bookNameRequest);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cartCoordenator);
        cartListView = (ListView)findViewById(R.id.cartListView);

        cartAdapter = new CartArrayAdapter(CartListActivity.this, R.layout.book_cart_list_item, Bookstore.bookToCart);

        if(storedBook == null ){
            if(Bookstore.bookToCart.size() == 0){
                messageArray.add("There is no Book in your cart!");
                stringAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, messageArray);
                cartListView.setAdapter(stringAdapter);
            }else{
                cartListView.setAdapter(cartAdapter);
            }

        }else{
            Bookstore.bookToCart.add(new Book(storedBook.getImageId(), storedBook.getBookName(), storedBook.getDescription(), storedBook.getPrice()));
            cartListView.setAdapter(cartAdapter);

        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
