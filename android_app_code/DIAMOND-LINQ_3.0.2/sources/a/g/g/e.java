package a.g.g;

import java.util.Locale;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final d f183a = new C0007e((c) null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final d f184b = new C0007e((c) null, true);
    public static final d c = new C0007e(b.f187a, false);
    public static final d d = new C0007e(b.f187a, true);
    public static final d e = new C0007e(a.f185a, false);
    public static final d f = f.f190b;

    private static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        static final a f185a = new a(true);

        /* renamed from: b  reason: collision with root package name */
        private final boolean f186b;

        private a(boolean z) {
            this.f186b = z;
        }

        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                int a2 = e.a(Character.getDirectionality(charSequence.charAt(i)));
                if (a2 != 0) {
                    if (a2 != 1) {
                        continue;
                        i++;
                    } else if (!this.f186b) {
                        return 1;
                    }
                } else if (this.f186b) {
                    return 0;
                }
                z = true;
                i++;
            }
            if (z) {
                return this.f186b ? 1 : 0;
            }
            return 2;
        }
    }

    private static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        static final b f187a = new b();

        private b() {
        }

        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = e.b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }
    }

    private interface c {
        int a(CharSequence charSequence, int i, int i2);
    }

    private static abstract class d implements d {

        /* renamed from: a  reason: collision with root package name */
        private final c f188a;

        d(c cVar) {
            this.f188a = cVar;
        }

        private boolean a(CharSequence charSequence, int i, int i2) {
            int a2 = this.f188a.a(charSequence, i, i2);
            if (a2 == 0) {
                return true;
            }
            if (a2 != 1) {
                return a();
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public abstract boolean a();

        public boolean isRtl(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            } else if (this.f188a == null) {
                return a();
            } else {
                return a(charSequence, i, i2);
            }
        }
    }

    /* renamed from: a.g.g.e$e  reason: collision with other inner class name */
    private static class C0007e extends d {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f189b;

        C0007e(c cVar, boolean z) {
            super(cVar);
            this.f189b = z;
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            return this.f189b;
        }
    }

    private static class f extends d {

        /* renamed from: b  reason: collision with root package name */
        static final f f190b = new f();

        f() {
            super((c) null);
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            return f.a(Locale.getDefault()) == 1;
        }
    }

    static int a(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
