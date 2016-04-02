package paulo.android.nackademin.mybookstorefinal;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by Paulo Vila Nova on 2016-03-31.
 */
public class CustomDialogFragment extends DialogFragment{


    CustomDialogClickListener activity;
    private Book book;

    public void setBook(Book book){
        this.book = book;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        this.activity = (CustomDialogClickListener) activity;
    }


    // INTERFACE
    public interface CustomDialogClickListener {
        // Metoden för cancel-knappen
        public void onCancelClick(DialogFragment dialog);
        // Metoden för delete-knappen
        public void onDeleteClick(DialogFragment dialog);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setMessage("THIS BOOK WILL BE DELETED \n" + book.getBookName() + " ?");

        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Kör metoden onCancelClick som finns i MainActivity
                activity.onCancelClick(CustomDialogFragment.this);
            }
        });

        alertDialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Kod som ska köras när man klickar på "Delete away"!
                activity.onDeleteClick(CustomDialogFragment.this);
            }
        });


        return alertDialog.create();
    }
}
