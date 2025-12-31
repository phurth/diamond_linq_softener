package b.a.a.e;

import android.content.Context;
import b.a.a.B;
import b.a.a.C0176ca;
import b.a.a.C0182fa;
import b.a.a.D;
import b.a.a.Fa;
import b.a.a.ia;
import b.a.a.ka;
import b.a.a.ra;
import b.a.a.wa;

public final class c {
    private boolean A;
    private boolean B;

    /* renamed from: a  reason: collision with root package name */
    private Context f1134a;

    /* renamed from: b  reason: collision with root package name */
    private int f1135b;
    private byte c;
    private int d;
    private int e;
    private B f;
    private int g;
    private double h;
    private int i;
    private int j;
    private double k;
    private int l;
    private int m;
    private B n;
    private final float[] o = new float[62];
    private boolean p;
    private byte q;
    private byte r;
    private byte s;
    private byte t;
    private byte u;
    private byte v;
    private boolean w;
    private byte x;
    private String y;
    private C0182fa z;

    private String v() {
        return String.valueOf(this.d).concat(this.f1134a.getString(Fa.time_separator)).concat(ia.b(this.e));
    }

    public String a(C0176ca caVar) {
        if (caVar == C0176ca.Standard) {
            return ia.a(this.k);
        }
        return ka.b(ra.GPM, this.k);
    }

    public int b() {
        return this.g;
    }

    public String c(C0176ca caVar) {
        String str;
        String str2;
        if (caVar == C0176ca.Standard) {
            str = ia.a(this.l);
        } else {
            str = ka.b(ra.GPG, (double) this.l);
        }
        if (caVar == C0176ca.Standard) {
            str2 = this.f1134a.getString(Fa.unit_gpg);
        } else {
            str2 = this.f1134a.getString(Fa.unit_mgl);
        }
        return str.concat(" ").concat(str2);
    }

    public String d(C0176ca caVar) {
        if (caVar == C0176ca.Standard) {
            return ia.a(this.i);
        }
        return ka.c(ra.GPM, (double) this.i);
    }

    public String e() {
        if (this.f == null) {
            return v();
        }
        return v().concat(" ").concat(this.f.toString());
    }

    public byte f() {
        return this.s;
    }

    public String g() {
        byte b2 = this.s;
        return b2 > 100 ? this.f1134a.getString(Fa.time_step_moving) : String.valueOf(b2);
    }

    public byte h() {
        return this.v;
    }

    public B i() {
        return this.n;
    }

    public String j() {
        if (this.n == null) {
            return String.valueOf(k());
        }
        return String.valueOf(this.m).concat(this.f1134a.getString(Fa.time_separator)).concat("00 ").concat(this.n.toString());
    }

    public int k() {
        return this.m;
    }

    public String l() {
        return this.y;
    }

    public C0182fa m() {
        return this.z;
    }

    public byte n() {
        return this.x;
    }

    public int o() {
        return this.l;
    }

    public float[] p() {
        return this.o;
    }

    public boolean q() {
        return this.p;
    }

    public boolean r() {
        return this.A;
    }

    public boolean s() {
        return this.B;
    }

    public boolean t() {
        return this.w;
    }

    public void u() {
        this.p = false;
        this.B = false;
        this.f1135b = 0;
    }

    public String b(C0176ca caVar) {
        if (caVar == C0176ca.Standard) {
            return ia.a(this.h);
        }
        return ka.b(ra.GPM, this.h);
    }

    public byte a() {
        return this.r;
    }

    public String d() {
        return String.valueOf(this.q).concat(" ").concat(this.f1134a.getString(this.q == 1 ? Fa.unit_day : Fa.unit_days));
    }

    public String e(C0176ca caVar) {
        if (caVar == C0176ca.Standard) {
            return ia.a(this.j);
        }
        return ka.b(ra.GPM, (double) this.j);
    }

    public void a(boolean z2) {
        this.B = z2;
    }

    public void a(Context context, C0176ca caVar, byte[] bArr, int i2, wa waVar, int i3, boolean z2) {
        this.f1134a = context;
        if (z2) {
            a(caVar, bArr, i3);
        } else {
            a(caVar, bArr, i2, waVar);
        }
    }

    public byte c() {
        return this.q;
    }

    private void a(C0176ca caVar, byte[] bArr, int i2) {
        if (i2 >= 3) {
            boolean z2 = false;
            if (bArr[0] == 117 && bArr[1] == 117 && bArr[2] == 117) {
                if (i2 >= 31 && i2 < 46) {
                    this.c = bArr[i2 - 23];
                    this.g = a(bArr[i2 - 22]);
                    this.s = bArr[i2 - 21];
                    this.t = bArr[i2 - 20];
                    this.u = bArr[i2 - 19];
                    this.v = bArr[i2 - 18];
                    this.d = D.c(bArr[i2 - 16]);
                    this.e = D.c(bArr[i2 - 15]);
                    this.f = D.c(bArr[i2 + -14]) == 0 ? B.AM : B.PM;
                    this.h = D.a(bArr[i2 - 12], bArr[i2 - 13]) / 100.0d;
                    this.i = D.b(bArr[i2 - 10], bArr[i2 - 11]);
                    this.j = D.b(bArr[i2 - 8], bArr[i2 - 9]);
                    this.k = D.a(bArr[i2 - 6], bArr[i2 - 7]) / 100.0d;
                    this.l = D.c(bArr[i2 - 5]);
                    this.m = D.c(bArr[i2 - 4]);
                    this.n = D.c(bArr[i2 + -3]) == 0 ? B.AM : B.PM;
                }
                if (!this.p && i2 >= 93 && i2 < 106) {
                    for (int i3 = 0; i3 < 62; i3++) {
                        float b2 = D.b(bArr[i2 - (i3 + 26)]) * 10.0f;
                        float[] fArr = this.o;
                        int i4 = 61 - i3;
                        if (caVar != C0176ca.Standard) {
                            b2 = (float) ka.a(ra.Gallons, (double) b2);
                        }
                        fArr[i4] = b2;
                    }
                    this.p = true;
                }
                if (this.p && this.c == 75) {
                    z2 = true;
                }
                this.B = z2;
            }
        }
    }

    private void a(C0176ca caVar, byte[] bArr, int i2, wa waVar) {
        int i3 = this.f1135b;
        boolean z2 = false;
        if (i3 == 0 || i3 > 3) {
            this.f1135b = 0;
            if (bArr[0] == 117 && bArr[1] == 117 && bArr[2] == 0 && bArr[19] == 57 && bArr.length == 20) {
                a(bArr);
            } else if (bArr[0] == 117 && bArr[1] == 117 && bArr[2] == 1 && bArr[19] == 58 && bArr.length == 20) {
                a(bArr, i2, waVar);
            } else if (bArr[0] == 117 && bArr[1] == 117 && bArr[2] == 2 && bArr.length == 20) {
                if (!this.p) {
                    a(caVar, bArr, 3, 20, -3);
                }
                this.f1135b++;
            }
        } else if (i3 == 1 && bArr.length == 20) {
            if (!this.p) {
                a(caVar, bArr, 0, 20, 17);
            }
            this.f1135b++;
        } else if (this.f1135b == 2 && bArr.length == 20) {
            if (!this.p) {
                a(caVar, bArr, 0, 20, 37);
            }
            this.f1135b++;
        } else if (this.f1135b == 3 && bArr.length == 6) {
            if (!this.p) {
                a(caVar, bArr, 0, 5, 57);
            }
            if (bArr[5] == 58) {
                z2 = true;
            }
            this.p = z2;
            this.B = true;
            this.f1135b++;
        } else {
            this.p = false;
            this.f1135b = 0;
        }
    }

    private void a(byte[] bArr) {
        this.d = D.c(bArr[3]);
        this.e = D.c(bArr[4]);
        this.f = D.c(bArr[5]) == 0 ? B.AM : B.PM;
        this.g = a(bArr[6]);
        this.h = D.a(bArr[8], bArr[7]) / 100.0d;
        this.i = D.b(bArr[10], bArr[9]);
        this.j = D.b(bArr[12], bArr[11]);
        this.k = D.a(bArr[14], bArr[13]) / 100.0d;
        this.l = D.c(bArr[15]);
        this.m = D.c(bArr[16]);
        this.n = D.c(bArr[17]) == 0 ? B.AM : B.PM;
    }

    private void a(byte[] bArr, int i2, wa waVar) {
        this.q = bArr[3];
        this.r = bArr[4];
        this.s = bArr[5];
        this.t = bArr[6];
        this.u = bArr[7];
        this.v = bArr[8];
        boolean z2 = false;
        if (i2 >= 210) {
            this.w = (bArr[10] & 8) != 0;
            this.x = bArr[11];
        }
        if (this.w && this.x != 0) {
            this.z = C0182fa.Minutes;
        } else if (this.t == 0) {
            this.z = C0182fa.Minutes;
        } else {
            this.z = C0182fa.Seconds;
        }
        byte b2 = bArr[12];
        this.y = a(waVar);
        if (waVar == wa.NitroProSidekick) {
            if ((b2 & 1) == 0) {
                z2 = true;
            }
            this.A = z2;
        }
    }

    private void a(C0176ca caVar, byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            float b2 = D.b(bArr[i2]) * 10.0f;
            float[] fArr = this.o;
            int i5 = i2 + i4;
            if (caVar != C0176ca.Standard) {
                b2 = (float) ka.a(ra.Gallons, (double) b2);
            }
            fArr[i5] = b2;
            i2++;
        }
    }

    private int a(byte b2) {
        double d2;
        double d3;
        double c2 = (double) (D.c(b2) * 4);
        Double.isNaN(c2);
        double d4 = c2 * 0.002d * 11.0d;
        double d5 = 100.0d;
        if (d4 < 9.5d) {
            if (d4 >= 8.91d) {
                d2 = 9.5d - d4;
                d3 = 8.78d;
            } else if (d4 >= 8.48d) {
                d5 = 94.78d - ((8.91d - d4) * 30.26d);
            } else if (d4 >= 7.43d) {
                d5 = 81.84d - ((8.48d - d4) * 60.47d);
            } else if (d4 >= 6.5d) {
                d5 = 18.68d;
                d2 = 7.43d - d4;
                d3 = 20.02d;
            } else {
                d5 = 0.0d;
            }
            d5 -= d2 * d3;
        }
        return (int) d5;
    }

    private String a(wa waVar) {
        if (this.w && this.x != 0) {
            return this.f1134a.getString(Fa.rg_step_brine_soak);
        }
        switch (b.f1133a[waVar.ordinal()]) {
            case 1:
            case 2:
                byte b2 = this.u;
                if (b2 == 0) {
                    return this.f1134a.getString(Fa.rg_step_service);
                }
                if (b2 == 1) {
                    return this.f1134a.getString(Fa.rg_step_backwash);
                }
                if (b2 == 2) {
                    return this.f1134a.getString(Fa.rg_step_brine_draw);
                }
                if (b2 == 3) {
                    return this.f1134a.getString(Fa.rg_step_raid_rinse);
                }
                if (b2 != 4) {
                    return "Unknown";
                }
                return this.f1134a.getString(Fa.rg_step_brine_fill);
            case 3:
                byte b3 = this.u;
                if (b3 == 0) {
                    return this.f1134a.getString(Fa.rg_step_service);
                }
                if (b3 == 1) {
                    return this.f1134a.getString(Fa.rg_step_backwash);
                }
                if (b3 == 2) {
                    return this.f1134a.getString(Fa.rg_step_rest);
                }
                if (b3 != 3) {
                    return "Unknown";
                }
                return this.f1134a.getString(Fa.rg_step_raid_rinse);
            case 4:
                byte b4 = this.u;
                if (b4 == 0) {
                    return this.f1134a.getString(Fa.rg_step_service);
                }
                if (b4 == 1) {
                    return this.f1134a.getString(Fa.rg_step_chlorine_feed);
                }
                if (b4 == 2) {
                    return this.f1134a.getString(Fa.rg_step_rest);
                }
                if (b4 != 3) {
                    return "Unknown";
                }
                return this.f1134a.getString(Fa.rg_step_backwash);
            case 5:
                byte b5 = this.u;
                if (b5 == 0) {
                    return this.f1134a.getString(Fa.rg_step_service);
                }
                if (b5 == 1) {
                    return this.f1134a.getString(Fa.rg_step_air_release);
                }
                if (b5 == 2) {
                    return this.f1134a.getString(Fa.rg_step_backwash);
                }
                if (b5 == 3) {
                    return this.f1134a.getString(Fa.rg_step_rest);
                }
                if (b5 == 4) {
                    return this.f1134a.getString(Fa.rg_step_raid_rinse);
                }
                if (b5 != 5) {
                    return "Unknown";
                }
                return this.f1134a.getString(Fa.rg_step_air_draw);
            case 6:
            case 7:
                byte b6 = this.u;
                if (b6 == 0) {
                    return this.f1134a.getString(Fa.rg_step_service);
                }
                if (b6 == 1) {
                    return this.f1134a.getString(Fa.rg_step_air_release);
                }
                if (b6 == 2) {
                    return this.f1134a.getString(Fa.rg_step_backwash);
                }
                if (b6 == 3) {
                    return this.f1134a.getString(Fa.rg_step_rest);
                }
                if (b6 == 4) {
                    return this.f1134a.getString(Fa.rg_step_air_draw);
                }
                if (b6 != 5) {
                    return "Unknown";
                }
                return this.f1134a.getString(Fa.rg_step_raid_rinse);
            case 8:
                switch (this.u) {
                    case 0:
                        return this.f1134a.getString(Fa.rg_step_service);
                    case 1:
                        return this.f1134a.getString(Fa.rg_step_air_release);
                    case 2:
                        return this.f1134a.getString(Fa.rg_step_air_chlorine_draw);
                    case 3:
                        return this.f1134a.getString(Fa.rg_step_chlorine_rinse);
                    case 4:
                        return this.f1134a.getString(Fa.rg_step_chlorine_contact);
                    case 5:
                        return this.f1134a.getString(Fa.rg_step_backwash);
                    case 6:
                        return this.f1134a.getString(Fa.rg_step_rest);
                    case 7:
                        return this.f1134a.getString(Fa.rg_step_raid_rinse);
                    case 8:
                        return this.f1134a.getString(Fa.rg_step_air_draw);
                    default:
                        return "Unknown";
                }
            case 9:
                switch (this.u) {
                    case 0:
                        return this.f1134a.getString(Fa.rg_step_service);
                    case 1:
                        return this.f1134a.getString(Fa.rg_step_air_release);
                    case 2:
                        return this.f1134a.getString(Fa.rg_step_air_chlorine_draw);
                    case 3:
                        return this.f1134a.getString(Fa.rg_step_chlorine_rinse);
                    case 4:
                        return this.f1134a.getString(Fa.rg_step_chlorine_contact);
                    case 5:
                        return this.f1134a.getString(Fa.rg_step_backwash);
                    case 6:
                        return this.f1134a.getString(Fa.rg_step_rest);
                    case 7:
                        return this.f1134a.getString(Fa.rg_step_air_draw);
                    case 8:
                        return this.f1134a.getString(Fa.rg_step_raid_rinse);
                    default:
                        return "Unknown";
                }
            default:
                return "Unknown";
        }
    }
}
