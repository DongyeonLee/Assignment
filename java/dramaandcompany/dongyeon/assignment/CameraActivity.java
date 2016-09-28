package dramaandcompany.dongyeon.assignment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class CameraActivity extends AppCompatActivity {
    SurfaceView mCameraSurfaceView;
    SurfaceHolder mSurfaceHolder;
    Camera mCamera;

    int mPictureCount = 0;
    public static Bitmap[] picturesBitmap;

    Button mCameraOkButton;
    public static Boolean cameraCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        mCameraSurfaceView = (SurfaceView) findViewById(R.id.cameraSurfaceView);
        mSurfaceHolder = mCameraSurfaceView.getHolder();
        mSurfaceHolder.addCallback(mSurfaceListener);
        mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        mCameraOkButton = (Button) findViewById(R.id.cameraOkButton);
    }

    public void CameraTakeButtonClicked(View v) {
        mCamera.takePicture(null, null, mTakePicture);
        mPictureCount++;
        mCameraOkButton.setText("완료" + String.valueOf(mPictureCount));
    }

    public void CameraOkButtonClicked(View v) {
        finish();
        cameraCheck = true;
    }

    public void CameraExitButtonClicked(View v) {
        finish();
    }

    private Camera.PictureCallback mTakePicture = new Camera.PictureCallback() {

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            if (data != null) {
                picturesBitmap[mPictureCount] = BitmapFactory.decodeByteArray(data, 0, data.length);

                camera.startPreview();
                // Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
            }
        }
    };

    private SurfaceHolder.Callback mSurfaceListener = new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            mCamera = Camera.open();

            try {
                mCamera.setPreviewDisplay(surfaceHolder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height) {
            Camera.Parameters parameters = mCamera.getParameters();
            parameters.setPreviewSize(width, height);
            mCamera.startPreview();
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            mCamera.release();
            mCamera = null;
        }
    };
}
