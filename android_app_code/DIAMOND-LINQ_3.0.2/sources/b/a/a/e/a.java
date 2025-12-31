package b.a.a.e;

import android.content.Context;
import b.a.a.C0176ca;
import b.a.a.D;
import b.a.a.Fa;
import b.a.a.G;
import b.a.a.ia;
import b.a.a.ka;
import b.a.a.ra;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f1131a;

    /* renamed from: b  reason: collision with root package name */
    private byte f1132b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;
    private byte i;
    private byte j;
    private byte k;
    private byte l;
    private boolean m;
    private int n;
    private final int[] o = new int[8];
    private final boolean[] p = new boolean[8];
    private boolean q;

    public String a(C0176ca caVar) {
        if (caVar == C0176ca.Standard) {
            return ia.a(this.f * 1000);
        }
        return ia.a(ka.b(ra.Grains, this.f * 1000));
    }

    public String b() {
        return String.valueOf(this.i).concat(" ").concat(this.f1131a.getString(this.i == 1 ? Fa.unit_day : Fa.unit_days));
    }

    public int c() {
        return this.n;
    }

    public String d() {
        return String.valueOf(this.n).concat(" ").concat(this.f1131a.getString(this.n == 1 ? Fa.unit_hour : Fa.unit_hours));
    }

    public int e() {
        return this.c;
    }

    public boolean[] f() {
        return this.p;
    }

    public int[] g() {
        return this.o;
    }

    public byte h() {
        return this.l;
    }

    public byte i() {
        return this.j;
    }

    public byte j() {
        return this.k;
    }

    public int k() {
        return this.d;
    }

    public String l() {
        int i2 = this.d;
        if (i2 == 0) {
            return this.f1131a.getString(Fa.disabled);
        }
        return String.valueOf(i2).concat(" ").concat(this.f1131a.getString(this.d == 1 ? Fa.unit_day : Fa.unit_days));
    }

    public int m() {
        return this.e;
    }

    public String n() {
        return String.valueOf(this.e).concat(this.f1131a.getString(Fa.percent));
    }

    public int o() {
        return this.f;
    }

    public boolean p() {
        return this.q;
    }

    public boolean q() {
        return this.m;
    }

    public boolean r() {
        return this.g;
    }

    public boolean s() {
        return this.h;
    }

    public void t() {
        this.q = false;
    }

    public byte a() {
        return this.i;
    }

    public void a(boolean z) {
        this.q = z;
    }

    public void a(Context context, byte[] bArr, int i2, int i3, boolean z) {
        this.f1131a = context;
        if (!G.a(bArr)) {
            if (z) {
                a(bArr, i3);
            } else {
                a(bArr, i3, i2);
            }
        }
    }

    private void a(byte[] bArr, int i2) {
        if (i2 >= 32 && i2 < 47) {
            boolean z = false;
            if (bArr[0] == 118 && bArr[1] == 118 && bArr[2] == 118) {
                this.f1132b = bArr[i2 - 21];
                this.k = bArr[i2 - 20];
                this.i = bArr[i2 - 19];
                this.c = D.c(bArr[i2 - 18]);
                this.g = bArr[i2 + -17] == 11;
                this.h = bArr[i2 + -16] != 0;
                this.d = D.c(bArr[i2 - 14]);
                this.e = D.c(bArr[i2 - 13]);
                this.f = D.b(bArr[i2 - 11], bArr[i2 - 12]);
                for (int i3 = 0; i3 < 8; i3++) {
                    int i4 = i2 - (10 - i3);
                    this.p[i3] = D.d(bArr[i4]);
                    this.o[i3] = this.p[i3] ? bArr[i4] + 128 : bArr[i4];
                }
            }
            if (this.f1132b == 75) {
                z = true;
            }
            this.q = z;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [int] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(byte[] r9, int r10, int r11) {
        /*
            r8 = this;
            r0 = 0
            byte r1 = r9[r0]
            r2 = 20
            r3 = 2
            r4 = 8
            r5 = 118(0x76, float:1.65E-43)
            r6 = 1
            if (r1 != r5) goto L_0x008f
            byte r1 = r9[r6]
            if (r1 != r5) goto L_0x008f
            byte r1 = r9[r3]
            if (r1 != 0) goto L_0x008f
            if (r10 != r2) goto L_0x008f
            r1 = 19
            byte r1 = r9[r1]
            r7 = 66
            if (r1 != r7) goto L_0x008f
            r10 = 3
            byte r10 = r9[r10]
            int r10 = b.a.a.D.c(r10)
            r8.c = r10
            r10 = 4
            byte r10 = r9[r10]
            int r10 = b.a.a.D.c(r10)
            r8.d = r10
            r10 = 5
            byte r10 = r9[r10]
            int r10 = b.a.a.D.c(r10)
            r8.e = r10
            r10 = 7
            byte r10 = r9[r10]
            r1 = 6
            byte r1 = r9[r1]
            int r10 = b.a.a.D.b(r10, r1)
            r8.f = r10
            byte r10 = r9[r4]
            r1 = 11
            if (r10 != r1) goto L_0x004e
            r10 = 1
            goto L_0x004f
        L_0x004e:
            r10 = 0
        L_0x004f:
            r8.g = r10
            r10 = 9
            byte r10 = r9[r10]
            if (r10 == 0) goto L_0x0059
            r10 = 1
            goto L_0x005a
        L_0x0059:
            r10 = 0
        L_0x005a:
            r8.h = r10
            r10 = 10
            byte r10 = r9[r10]
            r8.i = r10
            byte r10 = r9[r1]
            r8.k = r10
            r10 = 15
            byte r10 = r9[r10]
            r8.j = r10
            r10 = 210(0xd2, float:2.94E-43)
            if (r11 < r10) goto L_0x00c1
            r10 = 12
            byte r10 = r9[r10]
            r8.l = r10
            r10 = 13
            byte r10 = r9[r10]
            int r10 = b.a.a.D.c(r10)
            int r10 = java.lang.Math.max(r6, r10)
            r8.n = r10
            r10 = 14
            byte r9 = r9[r10]
            r9 = r9 & r4
            if (r9 == 0) goto L_0x008c
            r0 = 1
        L_0x008c:
            r8.m = r0
            goto L_0x00c1
        L_0x008f:
            byte r11 = r9[r0]
            if (r11 != r5) goto L_0x00c1
            byte r11 = r9[r6]
            if (r11 != r5) goto L_0x00c1
            byte r11 = r9[r3]
            if (r11 != r6) goto L_0x00c1
            if (r10 != r2) goto L_0x00c1
        L_0x009d:
            if (r0 >= r4) goto L_0x00bf
            int r10 = r0 + 3
            boolean[] r11 = r8.p
            byte r1 = r9[r10]
            boolean r1 = b.a.a.D.d(r1)
            r11[r0] = r1
            int[] r11 = r8.o
            boolean[] r1 = r8.p
            boolean r1 = r1[r0]
            if (r1 == 0) goto L_0x00b8
            byte r10 = r9[r10]
            int r10 = r10 + 128
            goto L_0x00ba
        L_0x00b8:
            byte r10 = r9[r10]
        L_0x00ba:
            r11[r0] = r10
            int r0 = r0 + 1
            goto L_0x009d
        L_0x00bf:
            r8.q = r6
        L_0x00c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.e.a.a(byte[], int, int):void");
    }
}
