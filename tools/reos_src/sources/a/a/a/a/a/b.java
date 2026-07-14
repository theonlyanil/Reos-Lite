package a.a.a.a.a;

import android.media.AudioRecord;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static a.a.a.a a(int i, int i2, int i3) {
        int minBufferSize = AudioRecord.getMinBufferSize(i, 16, 2);
        if (minBufferSize / 2 > i2) {
            throw new IllegalArgumentException("Buffer size too small should be at least " + (minBufferSize * 2));
        }
        AudioRecord audioRecord = new AudioRecord(1, i, 16, 2, i2 * 2);
        a aVar = new a(audioRecord, new a.a.a.a.b(i, 16, 1, true, false));
        audioRecord.startRecording();
        return new a.a.a.a(aVar, i2, i3);
    }
}
