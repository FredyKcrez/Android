package com.fredykcrez.cr11005utilidades;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
    String[] menu={"Audio", "Video", "Camara" , "TextToSpeech", "Speech", "GPS"};
    String[] activities={"Audio" , "Video" , "Camara", "TextToSpeechActivity" , "Speech", "GPS" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        ListView listView = getListView();
        listView.setBackgroundColor(Color.GREEN);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, menu);
        setListAdapter(adapter);
    }

    protected void onListItemClick(ListView l,View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        String nombreValue=activities[position];
        l.getChildAt(position).setBackgroundColor(Color. rgb(128, 128, 255));
        try{
            Class<?> clase=Class.forName("com.fredykcrez.cr11005utilidades." +nombreValue);
            Intent inte = new Intent(this,clase);
            this.startActivity(inte);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}