package b.a.a.e;

import b.a.a.C;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private byte f1136a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1137b;
    private StringBuilder c = new StringBuilder();
    private StringBuilder d = new StringBuilder();
    private StringBuilder e = new StringBuilder();
    private StringBuilder f = new StringBuilder();
    private StringBuilder g = new StringBuilder();
    private StringBuilder h = new StringBuilder();
    private int i;
    private int j;
    private int k;
    private boolean l;

    private void k() {
        this.c = new StringBuilder();
        this.d = new StringBuilder();
        this.e = new StringBuilder();
        this.f = new StringBuilder();
        this.g = new StringBuilder();
        this.h = new StringBuilder();
    }

    public String a() {
        return C.c(this.e.toString()) ? C.a(this.e.toString()) : this.e.toString();
    }

    public String b() {
        return C.c(this.f.toString()) ? C.a(this.f.toString()) : this.f.toString();
    }

    public String c() {
        return C.c(this.g.toString()) ? C.a(this.g.toString()) : this.g.toString();
    }

    public String d() {
        return C.c(this.c.toString()) ? C.a(this.c.toString()) : this.c.toString();
    }

    public String e() {
        return C.c(this.d.toString()) ? C.a(this.d.toString()) : this.d.toString();
    }

    public byte f() {
        return this.f1136a;
    }

    public String g() {
        return C.c(this.h.toString()) ? C.a(this.h.toString()) : this.h.toString();
    }

    public boolean h() {
        return this.l;
    }

    public boolean i() {
        return this.f1137b;
    }

    public void j() {
        k();
        this.l = false;
        this.i = 0;
        this.j = 0;
        this.k = 0;
    }

    private void b(byte[] bArr, int i2) {
        int i3;
        int i4 = 6;
        int i5 = 2;
        int i6 = 4;
        int i7 = 3;
        int i8 = 1;
        int i9 = 0;
        if (this.k == 0) {
            this.i = 0;
            if (this.j == 0) {
                k();
            }
            if (bArr[0] == 120 && bArr[1] == 120 && bArr[2] == (i3 = this.j)) {
                int i10 = 8;
                if (i3 == 0) {
                    this.f1136a = bArr[3];
                    this.f1137b = i2 > 209 && (bArr[5] & 8) != 0;
                    if (i2 >= 400) {
                        this.j++;
                        return;
                    }
                    this.i = bArr[i2 <= 209 ? (char) 5 : 7];
                } else {
                    this.i = bArr[i2 < 400 ? (char) 5 : 3];
                }
                if (this.i == 0) {
                    this.j++;
                    int i11 = this.j;
                    if (i2 < 400) {
                        i4 = 5;
                    }
                    if (i11 > i4) {
                        this.j = 0;
                        this.l = true;
                        return;
                    }
                    return;
                }
                int i12 = i2 >= 400 ? 4 : 6;
                int i13 = this.j;
                if (i2 >= 400) {
                    i9 = 1;
                }
                if (i13 == i9) {
                    StringBuilder sb = this.c;
                    if (i2 <= 209) {
                        i10 = 6;
                    } else if (i2 >= 400) {
                        i10 = 4;
                    }
                    a(sb, bArr, i10, i2);
                    return;
                }
                int i14 = this.j;
                if (i2 >= 400) {
                    i8 = 2;
                }
                if (i14 == i8) {
                    a(this.d, bArr, i12, i2);
                    return;
                }
                int i15 = this.j;
                if (i2 >= 400) {
                    i5 = 3;
                }
                if (i15 == i5) {
                    a(this.e, bArr, i12, i2);
                    return;
                }
                int i16 = this.j;
                if (i2 >= 400) {
                    i7 = 4;
                }
                if (i16 == i7) {
                    a(this.f, bArr, i12, i2);
                    return;
                }
                int i17 = this.j;
                if (i2 >= 400) {
                    i6 = 5;
                }
                if (i17 == i6) {
                    a(this.g, bArr, i12, i2);
                    return;
                }
                int i18 = this.j;
                if (i2 < 400) {
                    i4 = 5;
                }
                if (i18 == i4) {
                    a(this.h, bArr, i12, i2);
                    return;
                }
                return;
            }
            return;
        }
        if (this.j == (i2 >= 400 ? 1 : 0)) {
            a(this.c, bArr, 0, i2);
            return;
        }
        int i19 = this.j;
        if (i2 >= 400) {
            i8 = 2;
        }
        if (i19 == i8) {
            a(this.d, bArr, 0, i2);
            return;
        }
        int i20 = this.j;
        if (i2 >= 400) {
            i5 = 3;
        }
        if (i20 == i5) {
            a(this.e, bArr, 0, i2);
            return;
        }
        int i21 = this.j;
        if (i2 >= 400) {
            i7 = 4;
        }
        if (i21 == i7) {
            a(this.f, bArr, 0, i2);
            return;
        }
        int i22 = this.j;
        if (i2 >= 400) {
            i6 = 5;
        }
        if (i22 == i6) {
            a(this.g, bArr, 0, i2);
            return;
        }
        int i23 = this.j;
        if (i2 < 400) {
            i4 = 5;
        }
        if (i23 == i4) {
            a(this.h, bArr, 0, i2);
        }
    }

    public void a(boolean z) {
        this.l = z;
    }

    public void a(byte[] bArr, int i2, int i3, boolean z) {
        if (z) {
            a(bArr, i3);
        } else {
            b(bArr, i2);
        }
    }

    private void a(byte[] bArr, int i2) {
        int i3;
        byte b2;
        int i4;
        byte b3;
        int i5;
        byte b4;
        int i6;
        byte b5;
        int i7;
        byte b6;
        boolean z;
        int i8 = i2;
        if (i8 >= 3 && i8 < 1024) {
            byte b7 = 0;
            if (bArr[0] == 120) {
                if (bArr[1] == 120 && bArr[2] == 120 && bArr[i8 - 3] == 75) {
                    k();
                    int i9 = 0;
                    while (true) {
                        if (i9 >= i8) {
                            i3 = 0;
                            b2 = 0;
                            i9 = 0;
                            i4 = 0;
                            b3 = 0;
                            i5 = 0;
                            b4 = 0;
                            i6 = 0;
                            b5 = 0;
                            i7 = 0;
                            b6 = 0;
                            break;
                        } else if (bArr[i9] != 120) {
                            b7 = bArr[i9];
                            i3 = i9 + b7 + 1;
                            b2 = bArr[i3];
                            i4 = i3 + b2 + 1;
                            b3 = bArr[i4];
                            i5 = i4 + b3 + 1;
                            b4 = bArr[i5];
                            i6 = i5 + b4 + 1;
                            b5 = bArr[i6];
                            i7 = i6 + b5 + 1;
                            b6 = bArr[i7];
                            break;
                        } else {
                            i9++;
                        }
                    }
                    if (b7 > 0) {
                        int i10 = i9 + 1;
                        for (int i11 = 1; i10 < i9 + b7 + i11; i11 = 1) {
                            this.c.append((char) bArr[i10]);
                            i10++;
                        }
                    }
                    if (b2 > 0) {
                        for (int i12 = i3 + 1; i12 < i3 + b2 + 1; i12++) {
                            this.d.append((char) bArr[i12]);
                        }
                    }
                    if (b3 > 0) {
                        for (int i13 = i4 + 1; i13 < i4 + b3 + 1; i13++) {
                            this.e.append((char) bArr[i13]);
                        }
                    }
                    if (b4 > 0) {
                        for (int i14 = i5 + 1; i14 < i5 + b4 + 1; i14++) {
                            this.f.append((char) bArr[i14]);
                        }
                    }
                    if (b5 > 0) {
                        for (int i15 = i6 + 1; i15 < i6 + b5 + 1; i15++) {
                            this.g.append((char) bArr[i15]);
                        }
                    }
                    if (b6 > 0) {
                        int i16 = i7 + 1;
                        while (true) {
                            z = true;
                            if (i16 >= i7 + b6 + 1) {
                                break;
                            }
                            this.h.append((char) bArr[i16]);
                            i16++;
                        }
                    } else {
                        z = true;
                    }
                    this.l = z;
                }
            }
        }
    }

    private void a(StringBuilder sb, byte[] bArr, int i2, int i3) {
        int i4 = 20 - i2;
        int i5 = this.i;
        if (i5 < i4) {
            i4 = i5;
        }
        int i6 = 0;
        while (i6 < i4) {
            int i7 = i6 + i2;
            try {
                if (i7 < bArr.length && bArr[i7] != 0) {
                    sb.append((char) bArr[i7]);
                }
                i6++;
            } catch (Exception unused) {
                return;
            }
        }
        this.i -= i4;
        if (this.i == 0) {
            this.k = 0;
            this.j++;
            if (this.j > (i3 >= 400 ? 6 : 5)) {
                this.j = 0;
                this.l = true;
                return;
            }
            return;
        }
        this.k++;
    }
}
