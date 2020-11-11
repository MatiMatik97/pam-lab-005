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

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);

        getActivity().findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getResources().getString(R.string.first_fragment_label), Snackbar.LENGTH_LONG).show();

                Random random = new Random();
                int color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                getView().setBackgroundColor(color);
            }
        });

        view.findViewById(R.id.button_first_prev).setOnClickListener(viewOnClickListener(R.id.action_FirstFragment_to_ThirdFragment));
        view.findViewById(R.id.button_first_next).setOnClickListener(viewOnClickListener(R.id.action_FirstFragment_to_SecondFragment));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_second_fragment) {
            NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.SecondFragment);
            return true;
        } else if (id == R.id.action_third_fragment) {
            NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.ThirdFragment);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public View.OnClickListener viewOnClickListener(final int path) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this).navigate(path);
            }
        };
    }
}