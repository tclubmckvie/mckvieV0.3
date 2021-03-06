package com.techclub.mckvie;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.google.developers.mobile.targeting.proto.Conditions;

import org.w3c.dom.Text;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");
        toolbar.setSubtitle("");

        TextView visit = (TextView)findViewById(R.id.visit);
        TextView Chairman = (TextView)findViewById(R.id.chairman);
        TextView campusnews = (TextView) findViewById(R.id.campusnews);
        final ImageView more = (ImageView) findViewById(R.id.more);
        final TextView about = (TextView)findViewById(R.id.abt);


        visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(info.this,visit.class));
            }
        });
        Chairman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(info.this,chairman_address.class));
            }
        });

       campusnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(info.this, webview.class);
                intent.putExtra("id", "https://www.mckvie.edu.in/blog/");
                startActivity(intent);
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(info.this, more);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.infomenu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.one:
                                startActivity(new Intent(info.this, know_mckvie.class));
                                break;
                            case R.id.two:
                                startActivity(new Intent(info.this, administration.class));
                                break;
                            case R.id.three:
                                startActivity(new Intent(info.this,aff_acc.class));
                                break;
                            case R.id.four:
                                startActivity(new Intent(info.this, chairman_address.class));
                                break;
                            case R.id.five:
                                startActivity(new Intent(info.this,director_address.class));
                                break;
                            case R.id.six:
                                startActivity(new Intent(info.this,principal_address.class));
                                break;
                            case R.id.seven:
                                startActivity(new Intent(info.this,trust.class));
                                break;
                            case R.id.eight:
                                startActivity(new Intent(info.this,governing_body.class));
                                break;
                            case R.id.eleven:
                                startActivity(new Intent(info.this,holiday_list.class));
                                break;

                            case R.id.nine:
                                startActivity(new Intent(info.this,visionandmission.class));
                                break;
                            case R.id.ten:
                                startActivity(new Intent(info.this,qualitypolicy.class));
                                break;

                        }

                        Toast.makeText(
                                info.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
