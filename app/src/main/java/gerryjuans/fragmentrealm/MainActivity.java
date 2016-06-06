package gerryjuans.fragmentrealm;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initAddFab();
        initLoadFab();
    }

    private void initLoadFab() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_load);

        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    User user = getMainActivityFragment().loadUser();

                    if (user == null) {
                        makeSnackBar(v, "Data not found");
                    } else if (user.name.equalsIgnoreCase("")) {
                        makeSnackBar(v, "Both fields are empty");
                    } else {
                        makeSnackBar(v, "User successfully loaded");
                    }
                }
            });
        }
    }

    private MainActivityFragment getMainActivityFragment() {
        return (MainActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
    }

    private void initAddFab() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_add);

        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    User user = getMainActivityFragment().addUser();
                    if (user.name.equalsIgnoreCase("")) {
                        makeSnackBar(v, "A field is empty");
                    } else {
                        makeSnackBar(v, "User successfully added");
                    }
                }
            });
        }
    }

    public void makeSnackBar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
    }
}
