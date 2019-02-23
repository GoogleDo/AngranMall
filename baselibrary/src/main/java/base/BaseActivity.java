package base;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import org.kymjs.kjframe.KJActivity;

/**
 * author: Create By dushu on 2019/2/16 21:15
 * email : dushu@bytedance.com
 */
public class BaseActivity extends KJActivity {

    public static final String TAG = "BaseActivity";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }


    @Override
    public void setRootView() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
