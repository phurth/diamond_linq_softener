package a.e.b;

import java.util.Arrays;
import no.nordicsemi.android.log.BuildConfig;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static int f114a = 1;

    /* renamed from: b  reason: collision with root package name */
    private String f115b;
    public int c = -1;
    int d = -1;
    public int e = 0;
    public float f;
    float[] g = new float[7];
    a h;
    b[] i = new b[8];
    int j = 0;
    public int k = 0;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.h = aVar;
    }

    static void a() {
        f114a++;
    }

    public final void b(b bVar) {
        int i2 = this.j;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.i[i3] == bVar) {
                for (int i4 = 0; i4 < (i2 - i3) - 1; i4++) {
                    b[] bVarArr = this.i;
                    int i5 = i3 + i4;
                    bVarArr[i5] = bVarArr[i5 + 1];
                }
                this.j--;
                return;
            }
        }
    }

    public final void c(b bVar) {
        int i2 = this.j;
        for (int i3 = 0; i3 < i2; i3++) {
            b[] bVarArr = this.i;
            bVarArr[i3].d.a(bVarArr[i3], bVar, false);
        }
        this.j = 0;
    }

    public String toString() {
        return BuildConfig.FLAVOR + this.f115b;
    }

    public final void a(b bVar) {
        int i2 = 0;
        while (true) {
            int i3 = this.j;
            if (i2 >= i3) {
                b[] bVarArr = this.i;
                if (i3 >= bVarArr.length) {
                    this.i = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.i;
                int i4 = this.j;
                bVarArr2[i4] = bVar;
                this.j = i4 + 1;
                return;
            } else if (this.i[i2] != bVar) {
                i2++;
            } else {
                return;
            }
        }
    }

    public void b() {
        this.f115b = null;
        this.h = a.UNKNOWN;
        this.e = 0;
        this.c = -1;
        this.d = -1;
        this.f = 0.0f;
        this.j = 0;
        this.k = 0;
    }

    public void a(a aVar, String str) {
        this.h = aVar;
    }
}
