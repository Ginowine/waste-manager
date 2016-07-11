package app.booking.taxi.wastemanager.mFirebase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

import app.booking.taxi.wastemanager.mData.Report;
import app.booking.taxi.wastemanager.mRecycler.MyAdapter;

/**
 * Created by user on 7/1/2016.
 */
public class FireBaseClient {

    Context context;
    String databaseURL;
    RecyclerView recyclerView;

    Firebase firebase;
    ArrayList<Report> reports = new ArrayList<>();

    MyAdapter adapter;

    public FireBaseClient(Context context, String DB_URL, RecyclerView recyclerView){
        this.context = context;
        this.databaseURL = DB_URL;
        this.recyclerView = recyclerView;

        Firebase.setAndroidContext(context);
        firebase = new Firebase(databaseURL);

    }

    public FireBaseClient(Context context, String DB_URL){
        this.context = context;
        this.databaseURL = DB_URL;

        Firebase.setAndroidContext(context);
        firebase = new Firebase(databaseURL);
    }

    public void saveOnline(String size, String url, String locationAddress){

        Report report = new Report();
        report.setSize(size);
        report.setImageURL(url);
        report.setLocAddress(locationAddress);

        firebase.child("Report").push().setValue(report);
    }

    public void refreshData(){

        firebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getUpdate(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getUpdate(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    private void getUpdate(DataSnapshot dataSnapshot){
        reports.clear();

        for (DataSnapshot ds : dataSnapshot.getChildren()){

            Report rp = new Report();
            rp.setSize(ds.getValue(Report.class).getSize());
            rp.setImageURL(ds.getValue(Report.class).getImageURL());
            //rp.setLocAddress(ds.getValue(Report.class).getLocAddress());

            reports.add(rp);
        }

        if (reports.size() > 0){

            adapter = new MyAdapter(context, reports);
            recyclerView.setAdapter(adapter);

        }else {
            Toast.makeText(context, "NO DATA", Toast.LENGTH_SHORT).show();
        }
    }
}
