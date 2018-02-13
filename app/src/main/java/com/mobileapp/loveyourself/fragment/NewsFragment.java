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

public class NewsFragment extends Fragment implements View.OnClickListener {

    private Button buttonImage1, buttonImage2, buttonImage3, buttonImage4, buttonImage5, buttonImage6, buttonImage7, buttonImage8, buttonImage9, buttonImage10, buttonImage11, buttonImage12, buttonImage13, buttonImage14, buttonImage15, buttonImage16, buttonImage17, buttonImage18, buttonImage19, buttonImage20, buttonImage21,
            buttonImage22, buttonImage23, buttonImage24, buttonImage25, buttonImage26, buttonImage27, buttonImage28, buttonImage29, buttonImage30;
    private ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12, image13, image14, image15, image16, image17, image18, image19, image20, image21,
            image22, image23, image24, image25, image26, image27, image28, image29, image30;
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
        buttonImage6 = (Button) view.findViewById(R.id.button6);
        buttonImage7 = (Button) view.findViewById(R.id.button7);
        buttonImage8 = (Button) view.findViewById(R.id.button8);
        buttonImage9 = (Button) view.findViewById(R.id.button9);
        buttonImage10 = (Button) view.findViewById(R.id.button10);
        buttonImage11 = (Button) view.findViewById(R.id.button11);
        buttonImage12 = (Button) view.findViewById(R.id.button12);
        buttonImage13 = (Button) view.findViewById(R.id.button13);
        buttonImage14 = (Button) view.findViewById(R.id.button14);
        buttonImage15 = (Button) view.findViewById(R.id.button15);
        buttonImage16 = (Button) view.findViewById(R.id.button16);
        buttonImage17 = (Button) view.findViewById(R.id.button17);
        buttonImage18 = (Button) view.findViewById(R.id.button18);
        buttonImage19 = (Button) view.findViewById(R.id.button19);
        buttonImage20 = (Button) view.findViewById(R.id.button20);
        buttonImage21 = (Button) view.findViewById(R.id.button21);

        buttonImage22 = (Button) view.findViewById(R.id.button22);
        buttonImage23 = (Button) view.findViewById(R.id.button23);
        buttonImage24 = (Button) view.findViewById(R.id.button24);
        buttonImage25 = (Button) view.findViewById(R.id.button25);
        buttonImage26 = (Button) view.findViewById(R.id.button26);

        buttonImage27 = (Button) view.findViewById(R.id.button27);
        buttonImage28 = (Button) view.findViewById(R.id.button28);
        buttonImage29 = (Button) view.findViewById(R.id.button29);
        buttonImage30 = (Button) view.findViewById(R.id.button30);

        image1 = (ImageView) view.findViewById(R.id.image_news1);
        image2 = (ImageView) view.findViewById(R.id.image_news2);
        image3 = (ImageView) view.findViewById(R.id.image_news3);
        image4 = (ImageView) view.findViewById(R.id.image_news4);
        image5 = (ImageView) view.findViewById(R.id.image_news5);
        image6 = (ImageView) view.findViewById(R.id.image_news6);
        image7 = (ImageView) view.findViewById(R.id.image_news7);
        image8 = (ImageView) view.findViewById(R.id.image_news8);
        image9 = (ImageView) view.findViewById(R.id.image_news9);
        image10 = (ImageView) view.findViewById(R.id.image_news10);
        image11 = (ImageView) view.findViewById(R.id.image_news11);
        image12 = (ImageView) view.findViewById(R.id.image_news12);
        image13 = (ImageView) view.findViewById(R.id.image_news13);
        image14 = (ImageView) view.findViewById(R.id.image_news14);
        image15 = (ImageView) view.findViewById(R.id.image_news15);
        image16 = (ImageView) view.findViewById(R.id.image_news16);
        image17 = (ImageView) view.findViewById(R.id.image_news17);
        image18 = (ImageView) view.findViewById(R.id.image_news18);
        image19 = (ImageView) view.findViewById(R.id.image_news19);
        image20 = (ImageView) view.findViewById(R.id.image_news20);
        image21 = (ImageView) view.findViewById(R.id.image_news21);

        image22 = (ImageView) view.findViewById(R.id.image_news22);
        image23 = (ImageView) view.findViewById(R.id.image_news23);
        image24 = (ImageView) view.findViewById(R.id.image_news24);
        image25 = (ImageView) view.findViewById(R.id.image_news25);
        image26 = (ImageView) view.findViewById(R.id.image_news26);

        image27 = (ImageView) view.findViewById(R.id.image_news27);
        image28 = (ImageView) view.findViewById(R.id.image_news28);
        image29 = (ImageView) view.findViewById(R.id.image_news29);
        image30 = (ImageView) view.findViewById(R.id.image_news30);

        buttonImage1.setOnClickListener(this);
        buttonImage2.setOnClickListener(this);
        buttonImage3.setOnClickListener(this);
        buttonImage4.setOnClickListener(this);
        buttonImage5.setOnClickListener(this);
        buttonImage6.setOnClickListener(this);
        buttonImage7.setOnClickListener(this);
        buttonImage8.setOnClickListener(this);
        buttonImage9.setOnClickListener(this);
        buttonImage10.setOnClickListener(this);
        buttonImage11.setOnClickListener(this);
        buttonImage12.setOnClickListener(this);
        buttonImage13.setOnClickListener(this);
        buttonImage14.setOnClickListener(this);
        buttonImage15.setOnClickListener(this);
        buttonImage16.setOnClickListener(this);
        buttonImage17.setOnClickListener(this);
        buttonImage18.setOnClickListener(this);
        buttonImage19.setOnClickListener(this);
        buttonImage20.setOnClickListener(this);
        buttonImage21.setOnClickListener(this);

        buttonImage22.setOnClickListener(this);
        buttonImage23.setOnClickListener(this);
        buttonImage24.setOnClickListener(this);
        buttonImage25.setOnClickListener(this);
        buttonImage26.setOnClickListener(this);

        buttonImage27.setOnClickListener(this);
        buttonImage28.setOnClickListener(this);
        buttonImage29.setOnClickListener(this);
        buttonImage30.setOnClickListener(this);

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
                url = "http://www.loveyourself.ph/2017/03/status-women-and-hiv-4-reasons-we.html";
                break;
            case R.id.button6:
                url = "http://www.loveyourself.ph/2017/03/job-opening-nurses.html";
                break;
            case R.id.button7:
                url = "http://www.loveyourself.ph/2017/03/volunteer-spotlight-ruben-leo-aaron-and.html";
                break;
            case R.id.button8:
                url = "http://www.loveyourself.ph/2017/03/job-opening-treatment-hub-physician.html";
                break;
            case R.id.button9:
                url = "http://www.loveyourself.ph/2017/04/status-hiv-myths-and-fictions-debunked.html";
                break;
            case R.id.button10:
                url = "http://www.loveyourself.ph/2017/04/loveyourself-pays-tribute-to-its.html";
                break;
            case R.id.button11:
                url = "http://www.loveyourself.ph/2017/04/2017-holy-week-clinic-schedule-and-arv.html";
                break;
            case R.id.button12:
                url = "http://www.loveyourself.ph/2017/04/2017-holy-week-clinic-schedule-and-arv.html";
                break;
            case R.id.button13:
                url = "http://www.loveyourself.ph/2017/06/prism-colorful-life-in-motion-set-on.html";
                break;
            case R.id.button14:
                url = "http://www.loveyourself.ph/2017/06/status-yes-i-am-positive.html";
                break;
            case R.id.button15:
                url = "http://www.loveyourself.ph/2017/06/batch-marcelino-loveyourselfs-17th.html";
                break;
            case R.id.button16:
                url = "http://www.loveyourself.ph/2017/06/the-history-of-lgbtq-visibility-in.html";
                break;
            case R.id.button17:
                url = "http://www.loveyourself.ph/2017/07/status-a-to-e-of-being-positive-to.html";
                break;
            case R.id.button18:
                url = "http://www.loveyourself.ph/2017/08/miss-universe-2015-as-ambassador-of.html";
                break;
            case R.id.button19:
                url = "http://www.loveyourself.ph/2017/08/asias-premier-charity-and-awards-gala.html";
                break;
            case R.id.button20:
                url = "http://www.loveyourself.ph/2017/09/status-working-with-hiv.html";
                break;
            case R.id.button21:
                url = "http://www.loveyourself.ph/2017/09/hiv-cases-continue-to-rise-according-to.html";
                break;

            case R.id.button22:
                url = "http://www.loveyourself.ph/2017/10/status-hiv-and-blood-donations.html";
                break;
            case R.id.button23:
                url = "http://www.loveyourself.ph/2017/10/batch-duque-loveyourselfs-18th-batch.html";
                break;
            case R.id.button24:
                url = "http://www.loveyourself.ph/2017/11/join-lovesquad-on-november-26-and-make.html";
                break;
            case R.id.button25:
                url = "http://www.loveyourself.ph/2017/11/get-ready-for-lovesquad-on-november-26.html";
                break;
            case R.id.button26:
                url = "http://www.loveyourself.ph/2017/11/travel-squad-tells-you-how-to-get-to.html";
                break;

            case R.id.button27:
                url = "http://www.loveyourself.ph/2017/11/these-squads-explain-why-its-cool-to.html";
                break;
            case R.id.button28:
                url = "http://www.loveyourself.ph/2017/12/status-live-and-let-love-open-letter.html";
                break;
            case R.id.button29:
                url = "http://www.loveyourself.ph/2017/12/celebrating-2017-at-behind-mask.html";
                break;
            case R.id.button30:
                url = "http://www.loveyourself.ph/2018/01/safe-spaces-ph-distributing-free.html";
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
        Picasso.with(this.getContext()).load("https://4.bp.blogspot.com/-Dxjs8atUd8o/WNMl8c9P-5I/AAAAAAAAWC4/jS8ROt-kb2suZ0wLUm1VHiYfpBaQFdkWACLcB/s640/17342438_271797109911935_2078872097_o.jpg").into(image6);
        Picasso.with(this.getContext()).load("https://4.bp.blogspot.com/-CT0obbn29Ek/WNndhy1gsgI/AAAAAAAACow/TbGLakvY6AINT0rpNDVgV308XhVARZ3KACLcB/s320/Job%2BOpening%2BNurse.jpg").into(image7);
        Picasso.with(this.getContext()).load("https://3.bp.blogspot.com/-NaR8UU7dPjw/WNpNx8W4xYI/AAAAAAAAWFg/J_P_nB_zlWMksNFLmucdwUiHKUpxq_1FQCLcB/s640/20160813_193639%25280%2529.jpg").into(image8);
        Picasso.with(this.getContext()).load("https://3.bp.blogspot.com/-IMRgSod154k/WNt2_l3PkbI/AAAAAAAACpE/RNK3jA7yqgYVWAXyGFk-iUZPe3OnprXsQCLcB/s320/Job%2BOpening%2BNurse.jpg").into(image9);
        Picasso.with(this.getContext()).load("https://4.bp.blogspot.com/-vuWm6-5K8qU/WOYGm32p43I/AAAAAAAAWGo/KdJkqcnlhtQZ9bARQZ1xcBKYlk_xIc3FwCLcB/s640/hiv-facts-banner.png").into(image10);
        Picasso.with(this.getContext()).load("https://4.bp.blogspot.com/-aDtMdi5aP-4/WO4YtWgOH4I/AAAAAAAAWIY/W_O-tn9I34A3tgcE9mmgtX80V14Vuq4eQCLcB/s640/DSC_2117.JPG").into(image11);
        Picasso.with(this.getContext()).load("https://3.bp.blogspot.com/-YtTvPqfmPeI/WO4fxTbupkI/AAAAAAAACpg/0930N3GwK4Yif43hSh1eV0mhdqT--hH8wCLcB/s1600/LoveYourself%2Blogo.png").into(image12);
        Picasso.with(this.getContext()).load("https://3.bp.blogspot.com/-ePBlbUTEJY0/WUFHApaPRJI/AAAAAAAAACo/vU_bzTjT42swy5KPQjzqpw99Ak8bWdJAwCLcBGAs/s640/PRISM%2Bposter%2Bv02.jpg").into(image13);
        Picasso.with(this.getContext()).load("https://lh3.googleusercontent.com/fLUM2Nco5rxANgpvPDa-YERrrurZ_iQ2w678MGPTsHGmi9y2QrBlqlZ56rC2zmKcF2Rkxk2pjh3D242fE_waNLJ_E3otJPfQ3qp5C0M6hae4MdB52nEC8HZ2fu35U_Uk6MMoeyxs").into(image14);
        Picasso.with(this.getContext()).load("https://lh4.googleusercontent.com/Ej5brBMINQkjevF35vu3SDAq0c86s1q0RZmZQluRaQEkzdRZQpLjAbBuNaL1Q0-cT4g-jy3dusqQfCNqECRqMHv8JJ49YnHQE2RzsC_zxWicpaMP0ULpGUkP_9IZl6D-nv5JLAto").into(image15);
        Picasso.with(this.getContext()).load("https://1.bp.blogspot.com/-8ltGARlsu_o/WUpicvrMlDI/AAAAAAAAADE/Jz5xny4XIRQzuE2xj6iGX7Zs96AO6WgagCLcBGAs/s640/Infographic%2BPart%2B1%2Bv.3.png").into(image16);
        Picasso.with(this.getContext()).load("https://lh4.googleusercontent.com/oYXZLhRdoY-yeTRt0aCRN_0ZAkSnRM9SHK0qmMKTV_MmcECJLo4K9_83f3mnOkWM6DI5evLFFEMptYOXdV8ZQmpYHnyj1qO4OURXIVts_iN_Y74BW58cSxwnv6vh2jN5pppRVLOq").into(image17);

        Picasso.with(this.getContext()).load("https://3.bp.blogspot.com/-pJ_zkS5rsQk/WchZ9cN_0YI/AAAAAAAAYgk/hDov_IYlSlEi-l-2yvWKCAEMaAjKBymXQCLcBGAs/s640/blood%2Bextraction.jpg").into(image21);
        Picasso.with(this.getContext()).load("https://3.bp.blogspot.com/--a4JIPaPALo/WbkVkHogdiI/AAAAAAAAADw/zoD6HQ7vKMwxrArVktXMF_JwWs-jZL8OQCLcBGAs/s640/pic2.jpg").into(image20);
        Picasso.with(this.getContext()).load("https://4.bp.blogspot.com/-GDKf7T1iiN4/WY_uh6bXNfI/AAAAAAAAYcQ/fJ0TccD4XPskrelpjHlSzgHUT76kXILiACLcBGAs/s640/image.png").into(image19);
        Picasso.with(this.getContext()).load("https://3.bp.blogspot.com/-fkvaIZRl3B4/WY_lMCEnvEI/AAAAAAAAYcE/n4l7KTuwWjkv9z5EvdueRsjHtisCAFhTgCEwYBhgL/s640/Pia%2BLove%2BGala%2BAmbassador.jpg").into(image18);

        Picasso.with(this.getContext()).load("https://lh5.googleusercontent.com/yx2PDSm52PG1XlD95cdzXIyFFtMsYX2utg6CQHj7Sb0CGznjDoIvoVEM2JuAQ4jLFFHFkrBGC1agdqiPDSL_VUuKXoW6-XUCoNFF9IbOcum8E5UZ6yvohpOD_y7Bcp_OJT3pnUqd").into(image22);
        Picasso.with(this.getContext()).load("https://lh6.googleusercontent.com/2P5lI5CVXlIVOpUb3mKq-spC7GoMTmNOusr3p_z2qTEGdXSzzPTyhUpggohhusAXCTZ1qXlkYOdvKlSnOlsQWb5QgQXa9DA7NUOu0_ldY38IDS5HmZxh_8Jh0XJUnalUKG9Ga5zu").into(image23);
        Picasso.with(this.getContext()).load("https://2.bp.blogspot.com/-4FoNFtblIPk/WfxUdXW9szI/AAAAAAAAAEU/IiKQzVEZbDAHkcCw1aTeX7ib83WSIil_wCLcBGAs/s640/LOVE%2BSQUAD%2Bposter%2B1%2Bv02.jpg").into(image24);
        Picasso.with(this.getContext()).load("https://1.bp.blogspot.com/-VX9RuR8o3y8/WgVWTYpYQFI/AAAAAAAAY94/bg3fqWvZUJAabopvoTt_6VxUMASIOL0OQCLcBGAs/s640/LS%2BSTUDY%2BPOSTER2%2B%25282%2529.jpg").into(image25);
        Picasso.with(this.getContext()).load("https://1.bp.blogspot.com/-xpOO_7QfcVI/WgfDNTZ4_6I/AAAAAAAAZA4/QM-2YZUEBXA7tSF_5Y0Y3baNdwmx8It_QCLcBGAs/s320/travel%2Bsquad.jpg").into(image26);

        Picasso.with(this.getContext()).load("https://1.bp.blogspot.com/-oC3iGYV8srA/WgrSHkURt6I/AAAAAAAAZB4/3iSyCGGdIWEdIO5sRZkltxxPTGjm2ieDgCLcBGAs/s640/love%2Bsquad%2Bmain.jpg").into(image27);
        Picasso.with(this.getContext()).load("https://lh3.googleusercontent.com/kzvK-A8J7pz7BvJijSMyuUNDOFVY41v8dc-smF7Xg-GdR-BftXWsX1aFvQFPSE_KGDuyWstEfOtItCNeEFrLpask13uQ8vuEP7jK2Y0MUP_sUWgOxIZ28Gaj8ithLskvjk_Ks_Ph").into(image28);
        Picasso.with(this.getContext()).load("https://lh4.googleusercontent.com/r6TpDMD47i-xOp5CRFF3LsK6lUdzwYcnL-lMXt0qrlT5FlJ-2h0cDxEoe2ZOa1QC5Jw_CmtVuyYheFXJTH_X3d3PM-pVgjqqBXb8rpUvo6HWCqSMuLqscca_EI52aLpVF1zwAWZP").into(image29);
        Picasso.with(this.getContext()).load("https://lh5.googleusercontent.com/9GjPbWq6OXQUZsalOU5xSEP0Y8P6mdts2vNIRRceRE0cJFzafE6giQpKEIyPoyWDgJ_P6arAG5GGJ2un-GLzdGzHy1P4cYDMHqJI7AHkF_ZNaJrOcWQNtHzcWFzzrUbBZtHjT8cN").into(image30);

    }
}
