package com.example.dynamicphotoframe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
ImageView pic;
TextView text;
Integer curImage=0;//current image number
//0-1-2-0-1-2 pics should move
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.text);
        text.setText(curImage.toString());
    }
    public void previous(View view){//previous button
    String idOld="pic"+curImage;//to declare the existing image id
        int old=this.getResources().getIdentifier(idOld,"id",getPackageName());
        pic=findViewById(old);
        pic.setAlpha(0f);//to transparent the existing image

        curImage=(3+curImage-1)%3;//to transfer images b/w 0-1-2-0-1-2
        //to move backwards
        String idNaya="pic"+curImage;//to declare the new image id
        int naya=this.getResources().getIdentifier(idNaya,"id",getPackageName());//the line says:find the resources with the help of these identifying parameters
        //similar to R.id.getResources does the work of R and getidentifier does the the work of .id
        //getIdentifier function finds the component with the id stored in the variable
        //The getId() method is used to return the thread identifier.
        //The thread ID is a unique positive number which was generated at the time of thread creation
        //The getResource() method is used to return the resources of the module in which this class exists.It returns the path of the component.
        pic=findViewById(naya);//now assign that component to 'pic' so that it can be used
        pic.setAlpha(1f);//to opaque the new image
        text.setText(curImage.toString());//setting the name according to image

    }
    public void next(View view){//next button
        String idOld="pic"+curImage;
        int old=this.getResources().getIdentifier(idOld,"id",getPackageName());
        pic=findViewById(old);
        pic.setAlpha(0f);

        curImage=(curImage+1)%3;//to move forward
        String idNaya="pic"+curImage;
        int naya=this.getResources().getIdentifier(idNaya,"id",getPackageName());
        pic=findViewById(naya);
        pic.setAlpha(1f);
        text.setText(curImage.toString());

    }
}