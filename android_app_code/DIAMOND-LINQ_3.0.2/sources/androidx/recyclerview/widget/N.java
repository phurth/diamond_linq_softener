package androidx.recyclerview.widget;

import android.view.View;

class N {

    /* renamed from: a  reason: collision with root package name */
    final b f900a;

    /* renamed from: b  reason: collision with root package name */
    a f901b = new a();

    interface b {
        int a();

        int a(View view);

        View a(int i);

        int b();

        int b(View view);
    }

    N(b bVar) {
        this.f900a = bVar;
    }

    /* access modifiers changed from: package-private */
    public View a(int i, int i2, int i3, int i4) {
        int a2 = this.f900a.a();
        int b2 = this.f900a.b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a3 = this.f900a.a(i);
            this.f901b.a(a2, b2, this.f900a.a(a3), this.f900a.b(a3));
            if (i3 != 0) {
                this.f901b.b();
                this.f901b.a(i3);
                if (this.f901b.a()) {
                    return a3;
                }
            }
            if (i4 != 0) {
                this.f901b.b();
                this.f901b.a(i4);
                if (this.f901b.a()) {
                    view = a3;
                }
            }
            i += i5;
        }
        return view;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f902a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f903b;
        int c;
        int d;
        int e;

        a() {
        }

        /* access modifiers changed from: package-private */
        public int a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        /* access modifiers changed from: package-private */
        public void a(int i, int i2, int i3, int i4) {
            this.f903b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f902a = 0;
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            this.f902a = i | this.f902a;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            int i = this.f902a;
            if ((i & 7) != 0 && (i & (a(this.d, this.f903b) << 0)) == 0) {
                return false;
            }
            int i2 = this.f902a;
            if ((i2 & 112) != 0 && (i2 & (a(this.d, this.c) << 4)) == 0) {
                return false;
            }
            int i3 = this.f902a;
            if ((i3 & 1792) != 0 && (i3 & (a(this.e, this.f903b) << 8)) == 0) {
                return false;
            }
            int i4 = this.f902a;
            if ((i4 & 28672) == 0 || (i4 & (a(this.e, this.c) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view, int i) {
        this.f901b.a(this.f900a.a(), this.f900a.b(), this.f900a.a(view), this.f900a.b(view));
        if (i == 0) {
            return false;
        }
        this.f901b.b();
        this.f901b.a(i);
        return this.f901b.a();
    }
}
