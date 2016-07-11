package app.booking.taxi.wastemanager.mRecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.booking.taxi.wastemanager.R;
import app.booking.taxi.wastemanager.mData.Report;
import app.booking.taxi.wastemanager.mPicasso.PicassoClient;

/**
 * Created by user on 7/1/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder>{

    Context context;
    ArrayList<Report> reports;

    public MyAdapter(Context c, ArrayList<Report> reports) {
        this.context = c;
        this.reports = reports;
    }



    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model, parent, false);
        MyHolder holder = new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.sizeText.setText(reports.get(position).getSize());
        //holder.locAddress.setText(reports.get(position).getLocAddress());
        PicassoClient.downloadImage(context, reports.get(position).getImageURL(), holder.image);

    }

    @Override
    public int getItemCount() {
        return reports.size();
    }
}
