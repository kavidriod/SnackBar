package myandroidninja.wordpress.snackbar;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    FrameLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootLayout = findViewById(R.id.rootLayout);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Basic Components");
        toolbar.inflateMenu(R.menu.menu_main);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {
                    case  R.id.simple_snackbar:
                        showSimpleSnackBar();
                        break;
                    case  R.id.custom_snackbar:
                        showCustomSnackBar();
                        break;
                    case  R.id.snackbar_withoptions:
                        showSnackBarWithOptions();
                        break;
                }
                return false;
            }
        });
    }

    private void showSimpleSnackBar() {
        Snackbar.make(rootLayout,"Simple Snackbar",Snackbar.LENGTH_LONG).show();
    }

    private void showCustomSnackBar() {
        Snackbar snackbar = Snackbar.make(rootLayout,"Custom Snackbar",Snackbar.LENGTH_LONG);
        snackbar.setAction("Retry", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        snackbar.setActionTextColor(Color.BLUE);

        //Change Action Button Text Color
        View view = snackbar.getView();
        TextView textView = view.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();
    }

    private void showSnackBarWithOptions() {
        Snackbar snackbar = Snackbar.make(rootLayout,"File Deleted",Snackbar.LENGTH_LONG);
        snackbar.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Snackbar.make(rootLayout,"File Restored",Snackbar.LENGTH_LONG).show();
            }
        });
        snackbar.show();
    }
}
