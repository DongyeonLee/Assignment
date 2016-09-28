package dramaandcompany.dongyeon.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StoryDetailActivity extends AppCompatActivity {
    TextView mActionBarTitleText;
    Button mActionBarOptionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storydetail);

        // action bar
        View actionBarLayout = getLayoutInflater().inflate(R.layout.actionbar, null);
        mActionBarTitleText = (TextView) actionBarLayout.findViewById(R.id.actionbarTitleText);
        mActionBarOptionButton = (Button) actionBarLayout.findViewById(R.id.actionbarOptionButton);
        mActionBarOptionButton.setText("편집");
        mActionBarOptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StoryCreateActivity.class);
                startActivity(intent);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0); // 그림자 없애기
        actionBar.setDisplayShowTitleEnabled(false);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
        actionBar.setCustomView(actionBarLayout, params);
        actionBar.setDisplayShowCustomEnabled(true);
    }
}
