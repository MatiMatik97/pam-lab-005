package matkoz.lab.basiclab;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class ThirdFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);

        getActivity().findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getResources().getString(R.string.third_fragment_label), Snackbar.LENGTH_LONG).show();

                Random random = new Random();
                int color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                getView().setBackgroundColor(color);
            }
        });

        view.findViewById(R.id.button_third_prev).setOnClickListener(viewOnClickListener(R.id.action_ThirdFragment_to_SecondFragment));
        view.findViewById(R.id.button_third_next).setOnClickListener(viewOnClickListener(R.id.action_ThirdFragment_to_FirstFragment));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_first_fragment) {
            NavHostFragment.findNavController(ThirdFragment.this).navigate(R.id.FirstFragment);
            return true;
        } else if (id == R.id.action_second_fragment) {
            NavHostFragment.findNavController(ThirdFragment.this).navigate(R.id.SecondFragment);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public View.OnClickListener viewOnClickListener(final int path) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this).navigate(path);
            }
        };
    }
}