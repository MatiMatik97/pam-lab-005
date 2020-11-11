package matkoz.lab.basiclab;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_first_fragment) {
            Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.first_fragment_label), Snackbar.LENGTH_LONG).show();
            return false;
        } else if (id == R.id.action_second_fragment) {
            Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.second_fragment_label), Snackbar.LENGTH_LONG).show();
            return false;
        } else if (id == R.id.action_third_fragment) {
            Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.third_fragment_label), Snackbar.LENGTH_LONG).show();
            return false;
        }

        return super.onOptionsItemSelected(item);
    }
}