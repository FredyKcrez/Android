package com.fredykcrez.cr11005utilidades;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import java.io.File;

public class Video extends Activity {
    Button Play;
    Button Stop;
    VideoView video;
    MediaController mediacontrol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        video=(VideoView) findViewById(R.id.video);

        File f=new File(Environment.getExternalStorageDirectory(), "/Videos/Music/Earth Hour 2011.3gp");

        if (f.exists()){
            Uri uri=Uri.fromFile(f);
            video.setVideoURI(uri);
            mediacontrol=new MediaController(this);
            video.setMediaController(mediacontrol);
            mediacontrol.show();
        }
    }
}