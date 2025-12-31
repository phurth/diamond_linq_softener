package a.g.h;

import android.util.Log;
import java.io.Writer;

public class b extends Writer {

    /* renamed from: a  reason: collision with root package name */
    private final String f192a;

    /* renamed from: b  reason: collision with root package name */
    private StringBuilder f193b = new StringBuilder(128);

    public b(String str) {
        this.f192a = str;
    }

    private void a() {
        if (this.f193b.length() > 0) {
            Log.d(this.f192a, this.f193b.toString());
            StringBuilder sb = this.f193b;
            sb.delete(0, sb.length());
        }
    }

    public void close() {
        a();
    }

    public void flush() {
        a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == 10) {
                a();
            } else {
                this.f193b.append(c);
            }
        }
    }
}
