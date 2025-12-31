package androidx.appcompat.widget;

/* renamed from: androidx.appcompat.widget.ea  reason: case insensitive filesystem */
class C0094ea {

    /* renamed from: a  reason: collision with root package name */
    private int f593a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f594b = 0;
    private int c = Integer.MIN_VALUE;
    private int d = Integer.MIN_VALUE;
    private int e = 0;
    private int f = 0;
    private boolean g = false;
    private boolean h = false;

    C0094ea() {
    }

    public int a() {
        return this.g ? this.f593a : this.f594b;
    }

    public int b() {
        return this.f593a;
    }

    public int c() {
        return this.f594b;
    }

    public int d() {
        return this.g ? this.f594b : this.f593a;
    }

    public void a(int i, int i2) {
        this.h = false;
        if (i != Integer.MIN_VALUE) {
            this.e = i;
            this.f593a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f = i2;
            this.f594b = i2;
        }
    }

    public void b(int i, int i2) {
        this.c = i;
        this.d = i2;
        this.h = true;
        if (this.g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f593a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f594b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f593a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f594b = i2;
        }
    }

    public void a(boolean z) {
        if (z != this.g) {
            this.g = z;
            if (!this.h) {
                this.f593a = this.e;
                this.f594b = this.f;
            } else if (z) {
                int i = this.d;
                if (i == Integer.MIN_VALUE) {
                    i = this.e;
                }
                this.f593a = i;
                int i2 = this.c;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = this.f;
                }
                this.f594b = i2;
            } else {
                int i3 = this.c;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = this.e;
                }
                this.f593a = i3;
                int i4 = this.d;
                if (i4 == Integer.MIN_VALUE) {
                    i4 = this.f;
                }
                this.f594b = i4;
            }
        }
    }
}
