package dramaandcompany.dongyeon.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StoryListActivity extends AppCompatActivity {
    TextView mActionBarTitleText;
    Button mActionBarOptionButton;

    EditText mStoryListSearchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storylist);

        // action bar
        View actionBarLayout = getLayoutInflater().inflate(R.layout.actionbar, null);
        mActionBarTitleText = (TextView) actionBarLayout.findViewById(R.id.actionbarTitleText);
        mActionBarTitleText.setText("스토리(0)");
        mActionBarOptionButton = (Button) actionBarLayout.findViewById(R.id.actionbarOptionButton);
        mActionBarOptionButton.setText("+추가");
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

        mStoryListSearchEditText = (EditText) findViewById(R.id.storyListSearchEditText);
        mStoryListSearchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 제목과 메모 내용으로 검색
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
