package wangfei.sample;

import android.databinding.ObservableField;
import android.view.View;

import wangfei.util.global.BeepManager;

public class MainVH {

    public final ObservableField<String> result = new ObservableField<>("结果");

    public void onClick(View view) {
//        BeepManager.getInstance().lalala();
//        MediaUtil.getInstance().initMediaPlayer(R.raw.lalala).play();
        BeepManager.getInstance().beep();

    }
}
