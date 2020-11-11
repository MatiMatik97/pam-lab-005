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

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);

        getActivity().findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getResources().getString(R.string.second_fragment_label), Snackbar.LENGTH_LONG).show();

                Random random = new Random();
                int color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                getView().setBackgroundColor(color);
            }
        });

        view.findViewById(R.id.button_second_prev).setOnClickListener(viewOnClickListener(R.id.action_SecondFragment_to_FirstFragment));
        view.findViewById(R.id.button_second_next).setOnClickListener(viewOnClickListener(R.id.action_SecondFragment_to_ThirdFragment));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_first_fragment) {
            NavHostFragment.findNavController(SecondFragment.this).navigate(R.id.FirstFragment);
            return true;
        } else if (id == R.id.action_third_fragment) {
            NavHostFragment.findNavController(SecondFragment.this).navigate(R.id.ThirdFragment);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public View.OnClickListener viewOnClickListener(final int path) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this).navigate(path);
            }
        };
    }
}