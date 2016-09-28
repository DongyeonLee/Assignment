package dramaandcompany.dongyeon.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class StoryCreateActivity extends AppCompatActivity {
    TextView mActionBarTitleText;
    Button mActionBarOptionButton;

    TextView mStoryCreatePictureNumberText;
    EditText mStoryCreateTitleEditText, mStoryCreateMemoEditText;

    Button mStoryCreateCameraOpenButton;
    ImageView mStoryCreateImage1, mStoryCreateImage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storycreate);

        // action bar
        View actionBarLayout = getLayoutInflater().inflate(R.layout.actionbar, null);
        mActionBarTitleText = (TextView) actionBarLayout.findViewById(R.id.actionbarTitleText);
        mActionBarTitleText.setText("스토리 생성");
        mActionBarOptionButton = (Button) actionBarLayout.findViewById(R.id.actionbarOptionButton);
        mActionBarOptionButton.setText("완료");
        mActionBarOptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StoryListActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0); // 그림자 없애기
        actionBar.setDisplayShowTitleEnabled(false);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
        actionBar.setCustomView(actionBarLayout, params);
        actionBar.setDisplayShowCustomEnabled(true);

        mStoryCreatePictureNumberText = (TextView) findViewById(R.id.storyCreatePictureNumberText);
        mStoryCreateTitleEditText = (EditText) findViewById(R.id.storyCreateTitleEditText);
        mStoryCreateMemoEditText = (EditText) findViewById(R.id.storyCreateMemoEditText);

        mStoryCreateCameraOpenButton = (Button) findViewById(R.id.storyCreateCameraOpenButton);
        mStoryCreateImage1 = (ImageView) findViewById(R.id.storyCreateImage1);
        mStoryCreateImage2 = (ImageView) findViewById(R.id.storyCreateImage2);

        if (CameraActivity.cameraCheck == true) {
            if (CameraActivity.picturesBitmap.length == 1) {
                mStoryCreatePictureNumberText.setText("1장의 사진");
                mStoryCreateCameraOpenButton.setVisibility(View.GONE);
                mStoryCreateImage1.setVisibility(View.VISIBLE);
                mStoryCreateImage1.setImageBitmap(CameraActivity.picturesBitmap[0]);
            } else if (CameraActivity.picturesBitmap.length > 1) {
                mStoryCreatePictureNumberText.setText(String.valueOf(CameraActivity.picturesBitmap.length) + "장의 사진");
                mStoryCreateCameraOpenButton.setVisibility(View.GONE);
                mStoryCreateImage1.setVisibility(View.VISIBLE);
                mStoryCreateImage1.setImageBitmap(CameraActivity.picturesBitmap[0]);
                mStoryCreateImage2.setVisibility(View.VISIBLE);
                mStoryCreateImage2.setImageBitmap(CameraActivity.picturesBitmap[1]);
            }
        }
    }

    public void StoryCreateCameraOpenButtonClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), CameraActivity.class);
        startActivity(intent);
    }
}
