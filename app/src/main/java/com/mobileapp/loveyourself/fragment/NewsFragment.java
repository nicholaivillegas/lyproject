package com.mobileapp.loveyourself.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.mobileapp.loveyourself.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Nico on 3/13/2017.
 */

public class NewsFragment extends Fragment implements View.OnClickListener {

    private Button buttonImage1, buttonImage2, buttonImage3, buttonImage4, buttonImage5;
    private ImageView image1, image2, image3, image4, image5;
    String url;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        buttonImage1 = (Button) view.findViewById(R.id.button1);
        buttonImage2 = (Button) view.findViewById(R.id.button2);
        buttonImage3 = (Button) view.findViewById(R.id.button3);
        buttonImage4 = (Button) view.findViewById(R.id.button4);
        buttonImage5 = (Button) view.findViewById(R.id.button5);

        image1 = (ImageView) view.findViewById(R.id.image_news1);
        image2 = (ImageView) view.findViewById(R.id.image_news2);
        image3 = (ImageView) view.findViewById(R.id.image_news3);
        image4 = (ImageView) view.findViewById(R.id.image_news4);
        image5 = (ImageView) view.findViewById(R.id.image_news5);

        buttonImage1.setOnClickListener(this);
        buttonImage2.setOnClickListener(this);
        buttonImage3.setOnClickListener(this);
        buttonImage4.setOnClickListener(this);
        buttonImage5.setOnClickListener(this);

        initImage();
        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button1:
                url = "http://www.loveyourself.ph/2017/03/triangle-of-self-care-understanding.html";
                break;
            case R.id.button2:
                url = "http://www.loveyourself.ph/2017/03/volunteer-spotlight-yanyan-arana-and.html";
                break;
            case R.id.button3:
                url = "http://www.loveyourself.ph/2017/02/loveyourself-holds-annual-cherry-poppin.html";
                break;
            case R.id.button4:
                url = "http://www.loveyourself.ph/2017/02/score-good-kind-of-high-with-sinulog.html";
                break;
            case R.id.button5:
                url = "http://www.loveyourself.ph/2017/02/coffee-prince-mark-ortega-will-make-you.html";
                break;
        }
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void initImage() {
        Picasso.with(this.getContext()).load("https://lh3.googleusercontent.com/7JbmVbGVA2z76kfc5S3UN7z5K0PotHEDzgmHRQdrm3JTz0H1XmyAoLLZuno3YxALd0VNYZaqLT_XpmpLHELjGxUXFsq7AhQm_OalQhDRVJZzB_om7PbTgrzG2ac9S80pok1OgK7V").into(image1);
        Picasso.with(this.getContext()).load("https://1.bp.blogspot.com/-DMCxOZ5NDvE/WKkUR1Fc9VI/AAAAAAAAUzg/cd5l730d-9A6Gd6zpjprW1kPxZVie4hagCEw/s640/nDSC_0020-01.jpg").into(image2);
        Picasso.with(this.getContext()).load("https://3.bp.blogspot.com/-GCY_8sa3CyY/WLRG9GjClhI/AAAAAAAAVdo/M4gBCh6lUFIeGKmQf3TUcYsq9aOjSi-iACLcB/s640/PHOTO%2BBJ%2BPascual.JPG").into(image3);
        Picasso.with(this.getContext()).load("https://1.bp.blogspot.com/-Do70Psgg4ao/WK7ERM2JnfI/AAAAAAAAVGc/csz3mJESps4H1r4iN57--f49LR0-2cPNACEw/s640/CP3%2BJhoseph%2B2.jpg").into(image4);
        Picasso.with(this.getContext()).load("https://1.bp.blogspot.com/-mC7QjK6d2uQ/WK5Sp9N7nRI/AAAAAAAAVGI/9xZSAIloYuQVvfdC5TNJDwYS0_KeErZUgCLcB/s640/CP3%2BMark%2B2.jpg").into(image5);
    }
}
