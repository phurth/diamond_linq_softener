package b.a.a.e;

import b.a.a.wa;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1138a;

    /* renamed from: b  reason: collision with root package name */
    private byte f1139b;
    private wa c;
    private boolean d;
    private int e;
    private byte f;
    private byte g;
    private String h;
    private String i;
    private boolean j;
    private boolean k;

    public e(byte[] bArr, int i2, boolean z) {
        a(bArr, i2, z);
    }

    public int a() {
        return this.e;
    }

    public byte b() {
        return this.f;
    }

    public byte c() {
        return this.g;
    }

    public String d() {
        return this.h;
    }

    public String e() {
        return this.i;
    }

    public byte f() {
        return this.f1139b;
    }

    public wa g() {
        return this.c;
    }

    public boolean h() {
        return this.d;
    }

    public boolean i() {
        return this.j;
    }

    public boolean j() {
        return !this.k;
    }

    public boolean k() {
        return this.f1138a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a2 A[Catch:{ Exception -> 0x0163 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a5 A[Catch:{ Exception -> 0x0163 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ac A[Catch:{ Exception -> 0x0163 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ae A[Catch:{ Exception -> 0x0163 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00b4 A[Catch:{ Exception -> 0x0163 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b7 A[Catch:{ Exception -> 0x0163 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00bc A[Catch:{ Exception -> 0x0163 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bf A[Catch:{ Exception -> 0x0163 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00c8 A[Catch:{ Exception -> 0x0163 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00d1 A[Catch:{ Exception -> 0x0163 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ff A[Catch:{ Exception -> 0x0163 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0160 A[Catch:{ Exception -> 0x0163 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(byte[] r17, int r18, boolean r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = 0
            byte r3 = r1[r2]
            r4 = 116(0x74, float:1.63E-43)
            r5 = 2
            r6 = 1
            if (r3 != r4) goto L_0x001b
            byte r3 = r1[r6]
            if (r3 != r4) goto L_0x001b
            byte r3 = r1[r5]
            if (r19 == 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r4 = 0
        L_0x0017:
            if (r3 != r4) goto L_0x001b
            r3 = 1
            goto L_0x001c
        L_0x001b:
            r3 = 0
        L_0x001c:
            r0.f1138a = r3
            r3 = 15
            boolean r4 = b.a.a.G.a((byte[]) r1, (int) r3)
            if (r4 != 0) goto L_0x0163
            boolean r4 = r0.f1138a
            if (r4 != 0) goto L_0x002c
            goto L_0x0163
        L_0x002c:
            if (r19 == 0) goto L_0x0034
            int r4 = r18 + -3
            byte r4 = r1[r4]     // Catch:{ Exception -> 0x0163 }
            r0.f1139b = r4     // Catch:{ Exception -> 0x0163 }
        L_0x0034:
            r4 = 3
            if (r19 == 0) goto L_0x003a
            int r7 = r18 + -1
            goto L_0x003b
        L_0x003a:
            r7 = 3
        L_0x003b:
            byte r7 = r1[r7]     // Catch:{ Exception -> 0x0163 }
            r8 = 12
            r9 = 11
            r10 = 7
            r11 = 8
            r12 = 10
            r13 = 4
            r14 = 16
            r15 = 9
            if (r7 == r6) goto L_0x009c
            if (r7 != r4) goto L_0x0050
            goto L_0x009c
        L_0x0050:
            if (r7 != r5) goto L_0x0057
            b.a.a.wa r3 = b.a.a.wa.TimeClockSoftener     // Catch:{ Exception -> 0x0163 }
            r0.c = r3     // Catch:{ Exception -> 0x0163 }
            goto L_0x00a0
        L_0x0057:
            if (r7 < r13) goto L_0x0060
            if (r7 > r10) goto L_0x0060
            b.a.a.wa r3 = b.a.a.wa.BackWashingFilter     // Catch:{ Exception -> 0x0163 }
            r0.c = r3     // Catch:{ Exception -> 0x0163 }
            goto L_0x00a0
        L_0x0060:
            if (r7 != r11) goto L_0x0067
            b.a.a.wa r3 = b.a.a.wa.UltraFilter     // Catch:{ Exception -> 0x0163 }
            r0.c = r3     // Catch:{ Exception -> 0x0163 }
            goto L_0x00a0
        L_0x0067:
            if (r7 == r15) goto L_0x0097
            if (r7 != r9) goto L_0x006c
            goto L_0x0097
        L_0x006c:
            if (r7 == r12) goto L_0x0092
            if (r7 != r8) goto L_0x0071
            goto L_0x0092
        L_0x0071:
            r8 = 13
            if (r7 != r8) goto L_0x007a
            b.a.a.wa r3 = b.a.a.wa.NitroPro     // Catch:{ Exception -> 0x0163 }
            r0.c = r3     // Catch:{ Exception -> 0x0163 }
            goto L_0x00a0
        L_0x007a:
            r8 = 14
            if (r7 == r8) goto L_0x008d
            if (r7 != r3) goto L_0x0081
            goto L_0x008d
        L_0x0081:
            if (r7 != r14) goto L_0x0088
            b.a.a.wa r3 = b.a.a.wa.CenturionNitroSidekickV3     // Catch:{ Exception -> 0x0163 }
            r0.c = r3     // Catch:{ Exception -> 0x0163 }
            goto L_0x00a0
        L_0x0088:
            b.a.a.wa r3 = b.a.a.wa.Unknown     // Catch:{ Exception -> 0x0163 }
            r0.c = r3     // Catch:{ Exception -> 0x0163 }
            goto L_0x00a0
        L_0x008d:
            b.a.a.wa r3 = b.a.a.wa.NitroProSidekick     // Catch:{ Exception -> 0x0163 }
            r0.c = r3     // Catch:{ Exception -> 0x0163 }
            goto L_0x00a0
        L_0x0092:
            b.a.a.wa r3 = b.a.a.wa.CenturionNitroSidekick     // Catch:{ Exception -> 0x0163 }
            r0.c = r3     // Catch:{ Exception -> 0x0163 }
            goto L_0x00a0
        L_0x0097:
            b.a.a.wa r3 = b.a.a.wa.CenturionNitro     // Catch:{ Exception -> 0x0163 }
            r0.c = r3     // Catch:{ Exception -> 0x0163 }
            goto L_0x00a0
        L_0x009c:
            b.a.a.wa r3 = b.a.a.wa.MeteredSoftener     // Catch:{ Exception -> 0x0163 }
            r0.c = r3     // Catch:{ Exception -> 0x0163 }
        L_0x00a0:
            if (r19 == 0) goto L_0x00a5
            int r3 = r18 + -2
            goto L_0x00a6
        L_0x00a5:
            r3 = 4
        L_0x00a6:
            byte r3 = r1[r3]     // Catch:{ Exception -> 0x0163 }
            r7 = -54
            if (r3 != r7) goto L_0x00ae
            r3 = 1
            goto L_0x00af
        L_0x00ae:
            r3 = 0
        L_0x00af:
            r0.d = r3     // Catch:{ Exception -> 0x0163 }
            r3 = 5
            if (r19 == 0) goto L_0x00b7
            int r7 = r18 + -5
            goto L_0x00b8
        L_0x00b7:
            r7 = 5
        L_0x00b8:
            byte r7 = r1[r7]     // Catch:{ Exception -> 0x0163 }
            if (r19 == 0) goto L_0x00bf
            int r8 = r18 + -4
            goto L_0x00c0
        L_0x00bf:
            r8 = 6
        L_0x00c0:
            byte r8 = r1[r8]     // Catch:{ Exception -> 0x0163 }
            r11 = r8 & 128(0x80, float:1.794E-43)
            r15 = 128(0x80, float:1.794E-43)
            if (r11 != r15) goto L_0x00d1
            int r8 = r8 + 256
            int r11 = r8 / 16
            int r11 = r11 * 10
            int r8 = r8 % r14
        L_0x00cf:
            int r11 = r11 + r8
            goto L_0x00d7
        L_0x00d1:
            int r11 = r8 / 16
            int r11 = r11 * 10
            int r8 = r8 % r14
            goto L_0x00cf
        L_0x00d7:
            r8 = 6
            byte r8 = r1[r8]     // Catch:{ Exception -> 0x0163 }
            r0.f = r8     // Catch:{ Exception -> 0x0163 }
            byte r3 = r1[r3]     // Catch:{ Exception -> 0x0163 }
            r0.g = r3     // Catch:{ Exception -> 0x0163 }
            int r3 = r7 * 100
            int r3 = r3 + r11
            r0.e = r3     // Catch:{ Exception -> 0x0163 }
            java.util.Locale r3 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x0163 }
            java.lang.String r8 = "C%d.%02d"
            java.lang.Object[] r14 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0163 }
            java.lang.Byte r7 = java.lang.Byte.valueOf(r7)     // Catch:{ Exception -> 0x0163 }
            r14[r2] = r7     // Catch:{ Exception -> 0x0163 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x0163 }
            r14[r6] = r7     // Catch:{ Exception -> 0x0163 }
            java.lang.String r3 = java.lang.String.format(r3, r8, r14)     // Catch:{ Exception -> 0x0163 }
            r0.h = r3     // Catch:{ Exception -> 0x0163 }
            if (r19 != 0) goto L_0x0163
            byte r3 = r1[r10]     // Catch:{ Exception -> 0x0163 }
            int r3 = r3 + -112
            byte r3 = (byte) r3     // Catch:{ Exception -> 0x0163 }
            byte r7 = r1[r9]     // Catch:{ Exception -> 0x0163 }
            int r7 = r7 / r13
            int r7 = r7 - r3
            byte r7 = (byte) r7     // Catch:{ Exception -> 0x0163 }
            byte r8 = r1[r12]     // Catch:{ Exception -> 0x0163 }
            int r8 = r8 / r4
            int r8 = r8 - r7
            int r8 = r8 - r3
            byte r4 = (byte) r8     // Catch:{ Exception -> 0x0163 }
            r8 = 9
            byte r9 = r1[r8]     // Catch:{ Exception -> 0x0163 }
            int r9 = r9 / r5
            int r9 = r9 - r4
            int r9 = r9 - r7
            int r9 = r9 - r3
            byte r5 = (byte) r9     // Catch:{ Exception -> 0x0163 }
            r8 = 8
            byte r8 = r1[r8]     // Catch:{ Exception -> 0x0163 }
            int r8 = r8 - r5
            int r8 = r8 - r4
            int r8 = r8 - r7
            int r8 = r8 - r3
            byte r3 = (byte) r8     // Catch:{ Exception -> 0x0163 }
            if (r7 < 0) goto L_0x0152
            r8 = 9
            if (r7 > r8) goto L_0x0152
            if (r4 < 0) goto L_0x0152
            if (r4 > r8) goto L_0x0152
            if (r5 < 0) goto L_0x0152
            if (r5 > r8) goto L_0x0152
            if (r3 < 0) goto L_0x0152
            if (r3 <= r8) goto L_0x0134
            goto L_0x0152
        L_0x0134:
            r0.j = r2     // Catch:{ Exception -> 0x0163 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0163 }
            r8.<init>()     // Catch:{ Exception -> 0x0163 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0163 }
            r8.append(r3)     // Catch:{ Exception -> 0x0163 }
            r8.append(r5)     // Catch:{ Exception -> 0x0163 }
            r8.append(r4)     // Catch:{ Exception -> 0x0163 }
            r8.append(r7)     // Catch:{ Exception -> 0x0163 }
            java.lang.String r3 = r8.toString()     // Catch:{ Exception -> 0x0163 }
            r0.i = r3     // Catch:{ Exception -> 0x0163 }
            goto L_0x015a
        L_0x0152:
            r0.j = r6     // Catch:{ Exception -> 0x0163 }
            java.lang.String r3 = b.a.a.ma.a()     // Catch:{ Exception -> 0x0163 }
            r0.i = r3     // Catch:{ Exception -> 0x0163 }
        L_0x015a:
            r3 = 12
            byte r1 = r1[r3]     // Catch:{ Exception -> 0x0163 }
            if (r1 != r6) goto L_0x0161
            r2 = 1
        L_0x0161:
            r0.k = r2     // Catch:{ Exception -> 0x0163 }
        L_0x0163:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.e.e.a(byte[], int, boolean):void");
    }
}
