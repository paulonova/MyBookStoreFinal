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

    List<Book> bookListToCart;
    Book storedBook;

    ImageView bookImageId;
    TextView bookName;
    TextView bookPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String bookNameRequest = intent.getStringExtra(MainActivity.SENDING_BOOK_NAME);
        Toast.makeText(this,"SENDING_BOOK_NAME: " + bookNameRequest, Toast.LENGTH_LONG).show();

        SharedPreferences preferences = getSharedPreferences(DetailActivity.BOOK_NAME, Context.MODE_PRIVATE);
        String sharedText = preferences.getString(DetailActivity.BOOK_NAME, null);
        Log.d("SHARED_PREFERENCES TEXT:", sharedText);


        storedBook = Bookstore.getBookContent(bookNameRequest);
        bookListToCart = new ArrayList<>();
        bookListToCart.add(new Book(storedBook.getImageId(), storedBook.getBookName(), storedBook.getDescription(), storedBook.getPrice()));


        Log.d("RECIEVING A BOOK", "" + storedBook.getBookName() + " : " + storedBook.getPrice() + " : " + storedBook.getImageId());

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cartCoordenator);
        final ListView cartListView = (ListView)findViewById(R.id.cartListView);


        Log.d("Book to Cart", "" + bookListToCart.size());
        cartAdapter = new CartArrayAdapter(CartListActivity.this, R.layout.book_cart_list_item, bookListToCart);
        cartListView.setAdapter(cartAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
