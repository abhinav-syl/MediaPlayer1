package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;
import android.os.Bundle;
import java.util.Arraylist
public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {
    VideoView vw;
    ArrayList<Integer> vediolist = new ArrayList<>();
    int currvedio =0;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vw = (VideoView)findViewById(R.id.vidvw);
        vm.setMediaController (new MediaController(this));
        vm.setOnCompletionListener(this);

        videolist.add(R.raw.middle);
        videolist.add(R.raw.faded);
        videolist.add(R.raw.aeroplane);
        setVideo(videolist.get(0))
    }
    public void setVideo(int id){
        String uriPath = 'android.resource://' +getPackageName() +"/" +id;
        Uri uri = Uri.parse(uriPath);
        vw.setVideoURI(uri);
        vw.start();
    }
    public void onCompletion(MediaPlayer mediaplayer){
        AlertDialog.Builder obj = new AlertDialog.Builder(this);
        obj.setTitle("Playback Finished!");
        obj.setIcon(R.mipmap.ic_launcher);
        MyListener m = new MyListener();
        obj.setPositiveButton("Replay",m);
        obj.setNegativeButton("Next",m);
        obj.setMessage("replay or next");
        obj.show();
    }
    class MyListener implements DialogInterface.OnClickListener{

        if(which==-1){
            vw.seekTo(0);
            vw.start();
        }
        else{
            ++currvideo;
            if (currvideo == videolist.size())
                currvideo = 0;
            setVideo(videolist.get(currvideo));
        }
    }
}