package inggitsemut.cobaeventy.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import inggitsemut.cobaeventy.R;

public class InboxFragment extends Fragment implements View.OnClickListener {

    public InboxFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_inbox, container, false);
        return rootView;
    }


    @Override
    public void onClick(View v) {
    }

}