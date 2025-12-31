package no.nordicsemi.android.support.v18.scanner;

import android.os.Parcel;
import android.os.Parcelable;

public final class C implements Parcelable {
    public static final Parcelable.Creator<C> CREATOR = new B();

    /* renamed from: a  reason: collision with root package name */
    private final long f1633a;

    /* renamed from: b  reason: collision with root package name */
    private final long f1634b;
    private int c;
    private int d;
    private long e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;
    private long k;
    private long l;
    private boolean m;
    private int n;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private int f1635a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f1636b = 1;
        private long c = 0;
        private int d = 1;
        private int e = 3;
        private boolean f = true;
        private int g = 255;
        private boolean h = true;
        private boolean i = true;
        private boolean j = true;
        private long k = 10000;
        private long l = 10000;
        private long m = 0;
        private long n = 0;

        private boolean f(int i2) {
            return i2 == 1 || i2 == 2 || i2 == 4 || i2 == 6;
        }

        public a a(int i2) {
            if (f(i2)) {
                this.f1636b = i2;
                return this;
            }
            throw new IllegalArgumentException("invalid callback type - " + i2);
        }

        public a b(int i2) {
            if (i2 < 1 || i2 > 2) {
                throw new IllegalArgumentException("invalid matchMode " + i2);
            }
            this.d = i2;
            return this;
        }

        public a c(int i2) {
            if (i2 < 1 || i2 > 3) {
                throw new IllegalArgumentException("invalid numOfMatches " + i2);
            }
            this.e = i2;
            return this;
        }

        public a d(int i2) {
            this.g = i2;
            return this;
        }

        public a e(int i2) {
            if (i2 < -1 || i2 > 2) {
                throw new IllegalArgumentException("invalid scan mode " + i2);
            }
            this.f1635a = i2;
            return this;
        }

        public a d(boolean z) {
            this.h = z;
            return this;
        }

        public a b(boolean z) {
            this.i = z;
            return this;
        }

        public a c(boolean z) {
            this.j = z;
            return this;
        }

        private void b() {
            int i2 = this.f1635a;
            if (i2 == 1) {
                this.n = 2000;
                this.m = 3000;
            } else if (i2 != 2) {
                this.n = 500;
                this.m = 4500;
            } else {
                this.n = 0;
                this.m = 0;
            }
        }

        public a a(long j2) {
            if (j2 >= 0) {
                this.c = j2;
                return this;
            }
            throw new IllegalArgumentException("reportDelay must be > 0");
        }

        public a a(boolean z) {
            this.f = z;
            return this;
        }

        public a a(long j2, long j3) {
            if (j2 <= 0 || j3 <= 0) {
                throw new IllegalArgumentException("maxDeviceAgeMillis and taskIntervalMillis must be > 0");
            }
            this.k = j2;
            this.l = j3;
            return this;
        }

        public C a() {
            if (this.m == 0 && this.n == 0) {
                b();
            }
            return new C(this.f1635a, this.f1636b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.n, this.m, (B) null);
        }
    }

    /* synthetic */ C(int i2, int i3, long j2, int i4, int i5, boolean z, int i6, boolean z2, boolean z3, boolean z4, long j3, long j4, long j5, long j6, B b2) {
        this(i2, i3, j2, i4, i5, z, i6, z2, z3, z4, j3, j4, j5, j6);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.j = false;
    }

    public int b() {
        return this.d;
    }

    public boolean c() {
        return this.m;
    }

    public long d() {
        return this.k;
    }

    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.l;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    public int h() {
        return this.n;
    }

    public long i() {
        return this.f1634b;
    }

    public long j() {
        return this.f1633a;
    }

    public long k() {
        return this.e;
    }

    public int l() {
        return this.c;
    }

    public boolean m() {
        return this.i;
    }

    public boolean n() {
        return this.j;
    }

    public boolean o() {
        return this.h;
    }

    public boolean p() {
        return this.f1634b > 0 && this.f1633a > 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeLong(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeInt(this.n);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeLong(this.f1633a);
        parcel.writeLong(this.f1634b);
    }

    /* synthetic */ C(Parcel parcel, B b2) {
        this(parcel);
    }

    private C(int i2, int i3, long j2, int i4, int i5, boolean z, int i6, boolean z2, boolean z3, boolean z4, long j3, long j4, long j5, long j6) {
        this.c = i2;
        this.d = i3;
        this.e = j2;
        this.g = i5;
        this.f = i4;
        this.m = z;
        this.n = i6;
        this.h = z2;
        this.i = z3;
        this.j = z4;
        this.k = 1000000 * j3;
        this.l = j4;
        this.f1633a = j5;
        this.f1634b = j6;
    }

    private C(Parcel parcel) {
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readLong();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        boolean z = false;
        this.m = parcel.readInt() != 0;
        this.n = parcel.readInt();
        this.h = parcel.readInt() == 1;
        this.i = parcel.readInt() == 1 ? true : z;
        this.f1633a = parcel.readLong();
        this.f1634b = parcel.readLong();
    }
}
