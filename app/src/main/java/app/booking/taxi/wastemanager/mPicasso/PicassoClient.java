package app.booking.taxi.wastemanager.mPicasso;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import app.booking.taxi.wastemanager.R;

/**
 * Created by user on 7/1/2016.
 */
public class PicassoClient {

    public static void downloadImage(Context c, String url, ImageView img){

        if (url != null && url.length() >0){
            Picasso.with(c).load(url).placeholder(R.drawable.placeholder).into(img);
        }else {
            Picasso.with(c).load(R.drawable.placeholder).into(img);
        }

    }
}
