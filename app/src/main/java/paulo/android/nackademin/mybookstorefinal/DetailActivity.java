package paulo.android.nackademin.mybookstorefinal;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    ImageView detailBookImage;
    TextView detailBookName;
    TextView detailDescription;
    TextView detailBookPrice;
    public static final String BOOK_NAME = "book name";
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String productName = getIntent().getStringExtra(MainActivity.PRODUCT_NAME);
        Log.d("PRODUCT_NAME", "" + productName);

        final Bookstore bookstore = new Bookstore();
        final Book book = bookstore.getBookContent(productName);
        Log.d("PRODUCT_NAME", " price: " + book.getPrice() + " bookname: " + book.getBookName());


        detailBookName = (TextView)findViewById(R.id.txvDetailBookName);
        detailBookName.setText(book.getBookName());

        detailDescription = (TextView)findViewById(R.id.txvDetailDescription);
        detailDescription.setText(book.getDescription());

        detailBookPrice = (TextView)findViewById(R.id.txvDetailBookPrice);
        detailBookPrice.setText("Kr. " + book.getPrice());

        detailBookImage = (ImageView)findViewById(R.id.imvDetailImage);
        detailBookImage.setImageResource(book.getImageId());

        //SharedPreferences to store the book name and use it in CartListActivity
        sharedpreferences = getSharedPreferences(BOOK_NAME, Context.MODE_PRIVATE);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                data.putExtra(MainActivity.RETURN_MESSAGE, book.getBookName() + " added to shopping cart");
                setResult(RESULT_OK, data);

                //Sending a book object to List in CartListActivity..
                Log.d("BOOK: ", book.getImageId() + " : " + book.getBookName() + " : " + book.getPrice());

                //Storing the bookName in sharedPreferences...
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(BOOK_NAME, book.getBookName());
                editor.commit();

                //Notifications..
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(DetailActivity.this);
                mBuilder.setSmallIcon(book.getImageId());
                mBuilder.setContentTitle("Notification from MyBookstore App!");
                mBuilder.setContentText("You bought the book " + book.getBookName() + " !");
                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                // notificationID allows you to update the notification later on.
                mNotificationManager.notify(1, mBuilder.build());

                finish();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



}
