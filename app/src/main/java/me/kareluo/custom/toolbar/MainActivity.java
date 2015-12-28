package me.kareluo.custom.toolbar;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import me.kareluo.custom.toolbar.BaseToolbar.OnOptionItemClickListener;

public class MainActivity extends AppCompatActivity implements OnOptionItemClickListener {

    private TitleToolbar titleToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleToolbar = (TitleToolbar) findViewById(R.id.toolbar);
        titleToolbar.setOnOptionItemClickListener(this);

        setSupportActionBar(titleToolbar);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayOptions(actionBar.getDisplayOptions() | ActionBar.DISPLAY_HOME_AS_UP);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOptionItemClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.close:
                Toast.makeText(this, "关闭", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
