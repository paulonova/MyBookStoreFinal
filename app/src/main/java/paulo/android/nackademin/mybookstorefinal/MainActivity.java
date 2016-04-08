package paulo.android.nackademin.mybookstorefinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity  {

    BookArrayAdapter bookAdapter;
    private int lastClickedPosition;
    private int positionSelected;
    public static final String PRODUCT_NAME = "PRODUCT_NAME";
    public static final String RETURN_MESSAGE = "RETURN_MESSAGE";
    public static final String SENDING_BOOK_NAME = "sending book name";
    private static final int DETAIL_REQUEST = 101;
    private CoordinatorLayout coordinatorLayout;
    Book book;
    List<Book> bookFromBookstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_coordinator);

        //Create my Bookstore content..
        final Bookstore myBookstore = new Bookstore();
        bookFromBookstore = myBookstore.getBooks();

        final ListView myBookList = (ListView)findViewById(R.id.bookListView);

        bookAdapter = new BookArrayAdapter(this, R.layout.book_list_item, bookFromBookstore);
        myBookList.setAdapter(bookAdapter);

        myBookList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                book = bookFromBookstore.get(position);
                positionSelected = position;
                intent.putExtra(PRODUCT_NAME, book.getBookName());
                startActivityForResult(intent, DETAIL_REQUEST);

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == DETAIL_REQUEST){
            if(resultCode == RESULT_OK){
                String message = data.getStringExtra(RETURN_MESSAGE);
                Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG).setAction("Go to cart", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, CartListActivity.class);
                        startActivity(intent);
                    }
                }).show();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here.
        int id = item.getItemId();

        switch (id){

            case R.id.go_to_cart:
                Intent intent = new Intent(MainActivity.this, CartListActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_facebook:

                return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
