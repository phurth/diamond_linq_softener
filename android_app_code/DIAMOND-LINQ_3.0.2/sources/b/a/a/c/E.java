package b.a.a.c;

import b.a.a.D;
import b.a.a.ga;
import b.a.a.na;
import b.a.a.ua;
import b.a.a.va;
import b.a.a.xa;
import java.util.List;

public final class E {

    /* renamed from: a  reason: collision with root package name */
    private ga f1083a = ga.Unknown;

    /* renamed from: b  reason: collision with root package name */
    private int f1084b;
    private int c;
    private int d;
    private int e;
    private va f = va.Unknown;
    private ua g = ua.Unknown;
    private xa h = xa.Unknown;
    private int i;
    private boolean j;

    public E(List<t> list) {
        a(list);
    }

    public boolean a() {
        return this.j;
    }

    public String toString() {
        return "\nCsValveData { \n    Salt Status: " + this.f1083a + 10 + "    Error State: '" + this.f1084b + '\'' + 10 + "    Bootloader Version: '" + this.c + '\'' + 10 + "    Time Hours: '" + this.d + '\'' + 10 + "    Time Minutes: '" + this.e + '\'' + 10 + "    Signature Version: " + this.f + 10 + "    Radio Protocol Version: " + this.h + 10 + "    Valve Type: " + this.g + 10 + "    Firmware Version: " + this.i + 10 + "    Is 400 Series: " + this.j + 10 + "}";
    }

    private void a(List<t> list) {
        if (list != null) {
            for (t next : list) {
                if (next.a() >= 2 && next.c() == v.DataTypeManufacturerSpecificData) {
                    byte[] b2 = next.b();
                    boolean a2 = na.a(b2);
                    this.j = a2;
                    if (a2) {
                        if (b2.length >= 11) {
                            this.f1083a = ga.a(D.c(b2[2]));
                            this.f1084b = D.c(b2[3]);
                            this.d = D.c(b2[4]);
                            this.e = D.c(b2[5]);
                            this.c = D.c(b2[6]);
                            this.f = va.a(D.c(b2[7]));
                            if (b2.length == 11) {
                                this.h = xa.a(D.c(b2[8]));
                                this.i = (D.c(b2[9]) * 100) + D.c(b2[10]);
                            } else {
                                this.g = ua.a(D.c(b2[8]));
                                this.h = xa.a(D.c(b2[9]));
                                this.i = (D.c(b2[10]) * 100) + D.c(b2[11]);
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
