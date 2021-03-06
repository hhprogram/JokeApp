package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.R;

import static android.content.ContentValues.TAG;


/**
 * Moved the old sadasd from the 'main' module to the 'free' module as since this
 * fragment has to refer to a View (adView) I need to put this java code in the free module as
 * in the paid module there won't be a AdView and thus if I tried to keep this fragment in main (ie
 * shared between free and paid flavors then we I tried to run the paid flavor it wouldn't compile
 * because the R.id.adView wouldn't exist in the layout fragment_main as I have removed that view
 *
 * Thefore each flavor needs its own mainFragment...can share the same main activity though
 * as both will have button but the fragment layout shown will be different
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "in main fragment free");
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }
}
