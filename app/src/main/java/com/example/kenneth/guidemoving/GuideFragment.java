package com.example.kenneth.guidemoving;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class GuideFragment extends Fragment {

    public static GuideFragment newInstance(int index, int imageID) {
        GuideFragment f = new GuideFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        f.setImageID(imageID);
        return f;
    }

    private int imageID;
    private ImageView view;

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = (ImageView) inflater.inflate(R.layout.fragment_guide, container, false);
        view.setImageResource(imageID);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
