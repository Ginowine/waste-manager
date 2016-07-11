package app.booking.taxi.wastemanager.mRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import app.booking.taxi.wastemanager.R;

/**
 * Created by user on 7/1/2016.
 */
public class MyHolder extends RecyclerView.ViewHolder {

    TextView sizeText;
    ImageView image;
    Button locAddress;

    public MyHolder(View itemView) {
        super(itemView);
        sizeText= (TextView)itemView.findViewById(R.id.sizeText);
        image = (ImageView) itemView.findViewById(R.id.dumpImage);
        //locAddress = (Button) itemView.findViewById(R.id.dumpLocation);
    }
}
