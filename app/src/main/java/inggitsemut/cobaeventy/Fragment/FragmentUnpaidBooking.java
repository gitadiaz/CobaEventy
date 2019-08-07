package inggitsemut.cobaeventy.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import inggitsemut.cobaeventy.R;

public class FragmentUnpaidBooking extends Fragment {
    View view;

    public FragmentUnpaidBooking() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.unpaid_booking_fragment, container, false);
        return view;
    }
}
