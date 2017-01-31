package com.example.bijan.noticationarea;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragone extends Fragment {

    EditText editText1, editText2, editText3, editText4;
    Button button1, button2;
    NotificationManager notificationManager;
    NotificationCompat.Builder builder;

    public Fragone() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragone, container, false);

        editText1 = (EditText) v.findViewById(R.id.edittext1);
        editText2 = (EditText) v.findViewById(R.id.edittext2);
        editText3 = (EditText) v.findViewById(R.id.edittext3);
        editText4 = (EditText) v.findViewById(R.id.edittext4);
        button1 = (Button) v.findViewById(R.id.button1);
        button2 = (Button) v.findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                builder = new NotificationCompat.Builder(getActivity());

                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setTicker(editText1.getText().toString());
                BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.a);
                builder.setLargeIcon(bitmapDrawable.getBitmap());
                builder.setContentTitle(editText2.getText().toString());
                builder.setContentText(editText3.getText().toString());
                builder.setContentInfo(editText4.getText().toString());

                //Write code for starting our own screen(app) when user clicks
                Intent intent = new Intent(getActivity(), MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 0, intent, 0);
                builder.setContentIntent(pendingIntent);

                //for autocancel the notify
                builder.setAutoCancel(true);
































































































































































































































































                //push to notify to the top bar
                notificationManager.notify(1, builder.build());

                //perticular notification
//                notificationManager.cancel(1);
                //cancel all
//                notificationManager.cancelAll();
                //Toast.makeText(getActivity(), ""+editText1.getText().toString()+"-"+editText2.getText().toString()+"-"+editText3.getText().toString()+"-"+editText4.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setContentTitle(editText2.getText().toString());
                notificationManager.notify(1, builder.build());
            }
        });

        return v;
    }

}
