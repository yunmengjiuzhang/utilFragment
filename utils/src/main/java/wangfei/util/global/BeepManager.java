package wangfei.util.global;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.util.Log;

import java.io.Closeable;
import java.io.IOException;

import wangfei.util.BaseApp;
import wangfei.util.R;

public final class BeepManager implements MediaPlayer.OnErrorListener, Closeable {
    private static BeepManager instance = new BeepManager();// 饿汉式
    private static final String TAG = BeepManager.class.getSimpleName();
    private MediaPlayer mediaPlayer;

    private BeepManager() {
        if (mediaPlayer == null) {
            mediaPlayer = initMediaPlayer();
        }
    }

    public static BeepManager getInstance() {
        return instance;
    }

    public synchronized void beep() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public synchronized void vibrate() {
        ((Vibrator) BaseApp.getInstance().getSystemService(Context.VIBRATOR_SERVICE)).vibrate(200L);
    }

    public synchronized void vibrate(long time) {
        ((Vibrator) BaseApp.getInstance().getSystemService(Context.VIBRATOR_SERVICE)).vibrate(time);
    }

    private static boolean isCanRing() {
        AudioManager audioService = (AudioManager) BaseApp.getInstance().getSystemService(Context.AUDIO_SERVICE);
        return audioService.getRingerMode() == AudioManager.RINGER_MODE_NORMAL;
    }

    private MediaPlayer initMediaPlayer() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            AssetFileDescriptor file = BaseApp.getInstance().getResources().openRawResourceFd(R.raw.beep);
            try {
                mediaPlayer.setDataSource(file.getFileDescriptor(), file.getStartOffset(), file.getLength());
            } finally {
                file.close();
            }
            mediaPlayer.setOnErrorListener(this);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setLooping(false);
            mediaPlayer.setVolume(1f, 1f);
            mediaPlayer.prepare();
            return mediaPlayer;
        } catch (IOException ioe) {
            Log.w(TAG, ioe);
            mediaPlayer.release();
            return null;
        }
    }

    @Override
    public synchronized boolean onError(MediaPlayer mp, int what, int extra) {
        if (what == MediaPlayer.MEDIA_ERROR_SERVER_DIED) {
            // we are finished, so put up an appropriate error toast if required and finish
//            activity.finish();
        } else {
            // possibly media player error, so release and recreate
            close();
        }
        return true;
    }

    @Override
    public synchronized void close() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}
