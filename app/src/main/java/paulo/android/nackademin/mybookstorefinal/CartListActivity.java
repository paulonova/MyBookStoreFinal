package paulo.android.nackademin.mybookstorefinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CartListActivity extends AppCompatActivity {

    CartArrayAdapter cartAdapter;
    private CoordinatorLayout coordinatorLayout;

    List<Book> booksToCart;

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

        final Book book = Bookstore.getBookContent(bookNameRequest);
        booksToCart = new ArrayList<>();
        booksToCart.add(book);



        Log.d("RECIEVING A BOOK", "" + book.getBookName() + " : " + book.getPrice() + " : " + book.getImageId());

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cartCoordenator);

        final ListView cartListView = (ListView)findViewById(R.id.cartListView);


        Log.d("Book to Cart","" + booksToCart.size());
        cartAdapter = new CartArrayAdapter(CartListActivity.this, R.layout.book_cart_list_item, booksToCart);
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
