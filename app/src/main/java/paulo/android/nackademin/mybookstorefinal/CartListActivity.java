package paulo.android.nackademin.mybookstorefinal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CartListActivity extends AppCompatActivity implements CustomDialogFragment.CustomDialogClickListener {

    ArrayAdapter cartAdapter;
    private CoordinatorLayout coordinatorLayout;
    Book storedBook;
    ListView cartListView;
    private int lastClickedPosition;


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

        if(Bookstore.bookToCart.size() == 0){
            showAlert(this);
        }else{
            cartListView.setAdapter(cartAdapter);
        }


        cartListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                lastClickedPosition = position;

                // Skapa en ny instans av vår egen klass CustomDialogFragment
                CustomDialogFragment dialog = new CustomDialogFragment();
                dialog.setBook(Bookstore.bookToCart.get(position));
                dialog.show(getSupportFragmentManager(), "CustomDialogFragment");

                return true;
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void showAlert(Context context){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setMessage("Your cart is empty!");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK! Let me buy something..",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        finish();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }




    @Override
    public void onCancelClick(DialogFragment dialog) {
        Toast.makeText(this, "No book deleted!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeleteClick(DialogFragment dialog) {
        String bookToRemove = cartAdapter.getItem(lastClickedPosition).toString();
        Log.i("cartAdapter.getItem", "" + bookToRemove);

        //Bookstore.bookToCart.remove(Bookstore.bookToCart.get(position));
        Bookstore.bookToCart.remove(Bookstore.getBookContent(bookToRemove));
        cartAdapter.remove(Bookstore.bookToCart.get(lastClickedPosition));
    }
}
