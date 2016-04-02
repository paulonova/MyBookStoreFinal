package paulo.android.nackademin.mybookstorefinal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class CartArrayAdapter extends ArrayAdapter<Book> {

    Context context;
    List<Book> bookToCart;

    public CartArrayAdapter(Context context, int resource, List<Book> objects) {
        super(context, resource, objects);
        this.context = context;
        bookToCart = (List) objects;
    }


    // Ett sätt att optimera ListView ytterligare
    static class MyViewHolder {
        ImageView icon;
        TextView bookName;
        TextView price;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Skapa den View som visas för varje item i en ListView
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        final View itemView;

        if(convertView == null){
            itemView = layoutInflater.inflate(R.layout.book_cart_list_item, parent, false);
            MyViewHolder myViewHolder = new MyViewHolder();

            myViewHolder.icon = (ImageView)itemView.findViewById(R.id.cartImageView);
            myViewHolder.bookName = (TextView)itemView.findViewById(R.id.cartBookName);
            myViewHolder.price = (TextView)itemView.findViewById(R.id.cartBookPrice);

            itemView.setTag(myViewHolder);

        }else {
            itemView = convertView;
        }


        MyViewHolder returnedViewHolder = (MyViewHolder) itemView.getTag();

        String bookName = bookToCart.get(position).getBookName();
        double price = bookToCart.get(position).getPrice();
        int imageId = bookToCart.get(position).getImageId();

        returnedViewHolder.bookName.setText(bookName);
        returnedViewHolder.price.setText("kr. " + price);

        Bitmap bitmap = ResizeImage.getOptimizedBitmap(context, imageId, 100, 100);
        returnedViewHolder.icon.setImageBitmap(bitmap);



        BitmapFactory.Options options = new BitmapFactory.Options();
        //Utläs endast bildens egenskaper(höjd, bred osv men inte bild själv)
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), imageId, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        String imageType = options.outMimeType;

        Log.i("IMAGE ORIGINAL INFO ", "" + context.getResources().getResourceEntryName(imageId) + " : " + imageHeight + " : " + imageWidth + " : " + imageType);

        Log.i("AFTER DECODE ", "" + returnedViewHolder.icon.getHeight() + " New width: " + returnedViewHolder.icon.getWidth());



        return itemView;
    }
}
