package a.g.i.a;

import a.g.i.a.f;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static int f210a;

    /* renamed from: b  reason: collision with root package name */
    private final AccessibilityNodeInfo f211b;
    public int c = -1;

    public static class a {
        public static final a A = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        public static final a B = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        public static final a C = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, 16908348, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        public static final a D = new a(Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, (CharSequence) null, (f) null, f.C0010f.class);
        public static final a E = new a(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, (CharSequence) null, (f) null, f.d.class);
        public static final a F = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        public static final a G;

        /* renamed from: a  reason: collision with root package name */
        public static final a f212a = new a(1, (CharSequence) null);

        /* renamed from: b  reason: collision with root package name */
        public static final a f213b = new a(2, (CharSequence) null);
        public static final a c = new a(4, (CharSequence) null);
        public static final a d = new a(8, (CharSequence) null);
        public static final a e = new a(16, (CharSequence) null);
        public static final a f = new a(32, (CharSequence) null);
        public static final a g = new a(64, (CharSequence) null);
        public static final a h = new a(128, (CharSequence) null);
        public static final a i = new a(256, (CharSequence) null, f.b.class);
        public static final a j = new a(512, (CharSequence) null, f.b.class);
        public static final a k = new a(1024, (CharSequence) null, f.c.class);
        public static final a l = new a(2048, (CharSequence) null, f.c.class);
        public static final a m = new a(4096, (CharSequence) null);
        public static final a n = new a(8192, (CharSequence) null);
        public static final a o = new a(16384, (CharSequence) null);
        public static final a p = new a(32768, (CharSequence) null);
        public static final a q = new a(65536, (CharSequence) null);
        public static final a r = new a(131072, (CharSequence) null, f.g.class);
        public static final a s = new a(262144, (CharSequence) null);
        public static final a t = new a(524288, (CharSequence) null);
        public static final a u = new a(1048576, (CharSequence) null);
        public static final a v = new a(2097152, (CharSequence) null, f.h.class);
        public static final a w = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, 16908342, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        public static final a x = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, (CharSequence) null, (f) null, f.e.class);
        public static final a y = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        public static final a z = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        final Object H;
        private final int I;
        private final CharSequence J;
        private final Class<? extends f.a> K;
        protected final f L;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction = null;
            if (Build.VERSION.SDK_INT >= 28) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            }
            G = new a(accessibilityAction, 16908357, (CharSequence) null, (f) null, (Class<? extends f.a>) null);
        }

        public a(int i2, CharSequence charSequence) {
            this((Object) null, i2, charSequence, (f) null, (Class<? extends f.a>) null);
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.H).getId();
            }
            return 0;
        }

        private a(int i2, CharSequence charSequence, Class<? extends f.a> cls) {
            this((Object) null, i2, charSequence, (f) null, cls);
        }

        a(Object obj, int i2, CharSequence charSequence, f fVar, Class<? extends f.a> cls) {
            this.I = i2;
            this.J = charSequence;
            this.L = fVar;
            if (Build.VERSION.SDK_INT < 21 || obj != null) {
                this.H = obj;
            } else {
                this.H = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            }
            this.K = cls;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0028  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(android.view.View r5, android.os.Bundle r6) {
            /*
                r4 = this;
                a.g.i.a.f r0 = r4.L
                r1 = 0
                if (r0 == 0) goto L_0x0049
                r0 = 0
                java.lang.Class<? extends a.g.i.a.f$a> r2 = r4.K
                if (r2 == 0) goto L_0x0042
                java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r3)     // Catch:{ Exception -> 0x0020 }
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.Object r1 = r2.newInstance(r1)     // Catch:{ Exception -> 0x0020 }
                a.g.i.a.f$a r1 = (a.g.i.a.f.a) r1     // Catch:{ Exception -> 0x0020 }
                r1.a(r6)     // Catch:{ Exception -> 0x001d }
                r0 = r1
                goto L_0x0042
            L_0x001d:
                r6 = move-exception
                r0 = r1
                goto L_0x0021
            L_0x0020:
                r6 = move-exception
            L_0x0021:
                java.lang.Class<? extends a.g.i.a.f$a> r1 = r4.K
                if (r1 != 0) goto L_0x0028
                java.lang.String r1 = "null"
                goto L_0x002c
            L_0x0028:
                java.lang.String r1 = r1.getName()
            L_0x002c:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Failed to execute command with argument class ViewCommandArgument: "
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                java.lang.String r2 = "A11yActionCompat"
                android.util.Log.e(r2, r1, r6)
            L_0x0042:
                a.g.i.a.f r6 = r4.L
                boolean r5 = r6.a(r5, r0)
                return r5
            L_0x0049:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: a.g.i.a.c.a.a(android.view.View, android.os.Bundle):boolean");
        }
    }

    /* renamed from: a.g.i.a.c$c  reason: collision with other inner class name */
    public static class C0009c {

        /* renamed from: a  reason: collision with root package name */
        final Object f215a;

        C0009c(Object obj) {
            this.f215a = obj;
        }

        public static C0009c a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 21) {
                return new C0009c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
            }
            if (i5 >= 19) {
                return new C0009c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new C0009c((Object) null);
        }
    }

    private c(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f211b = accessibilityNodeInfo;
    }

    public static c a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new c(accessibilityNodeInfo);
    }

    public static c b(View view) {
        return a(AccessibilityNodeInfo.obtain(view));
    }

    private static String b(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public static c u() {
        return a(AccessibilityNodeInfo.obtain());
    }

    private void x() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f211b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f211b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f211b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f211b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    private boolean y() {
        return !a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public void c(View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f211b.setSource(view, i);
        }
    }

    public void d(View view) {
        this.f211b.setSource(view);
    }

    public void e(boolean z) {
        this.f211b.setEnabled(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f211b;
        if (accessibilityNodeInfo == null) {
            if (cVar.f211b != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(cVar.f211b)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public void f(boolean z) {
        this.f211b.setFocusable(z);
    }

    public void g(boolean z) {
        this.f211b.setFocused(z);
    }

    public String h() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f211b.getViewIdResourceName();
        }
        return null;
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f211b;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean i() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f211b.isAccessibilityFocused();
        }
        return false;
    }

    public boolean j() {
        return this.f211b.isCheckable();
    }

    public boolean k() {
        return this.f211b.isChecked();
    }

    public void l(boolean z) {
        this.f211b.setSelected(z);
    }

    public void m(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f211b.setVisibleToUser(z);
        }
    }

    public boolean n() {
        return this.f211b.isFocusable();
    }

    public boolean o() {
        return this.f211b.isFocused();
    }

    public boolean p() {
        return this.f211b.isLongClickable();
    }

    public boolean q() {
        return this.f211b.isPassword();
    }

    public boolean r() {
        return this.f211b.isScrollable();
    }

    public boolean s() {
        return this.f211b.isSelected();
    }

    public boolean t() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f211b.isVisibleToUser();
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        sb.append("; boundsInParent: " + rect);
        b(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(f());
        sb.append("; className: ");
        sb.append(c());
        sb.append("; text: ");
        sb.append(g());
        sb.append("; contentDescription: ");
        sb.append(d());
        sb.append("; viewId: ");
        sb.append(h());
        sb.append("; checkable: ");
        sb.append(j());
        sb.append("; checked: ");
        sb.append(k());
        sb.append("; focusable: ");
        sb.append(n());
        sb.append("; focused: ");
        sb.append(o());
        sb.append("; selected: ");
        sb.append(s());
        sb.append("; clickable: ");
        sb.append(l());
        sb.append("; longClickable: ");
        sb.append(p());
        sb.append("; enabled: ");
        sb.append(m());
        sb.append("; password: ");
        sb.append(q());
        sb.append("; scrollable: " + r());
        sb.append("; [");
        int a2 = a();
        while (a2 != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(a2);
            a2 &= numberOfTrailingZeros ^ -1;
            sb.append(b(numberOfTrailingZeros));
            if (a2 != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void v() {
        this.f211b.recycle();
    }

    public AccessibilityNodeInfo w() {
        return this.f211b;
    }

    public static c a(c cVar) {
        return a(AccessibilityNodeInfo.obtain(cVar.f211b));
    }

    private SparseArray<WeakReference<ClickableSpan>> e(View view) {
        SparseArray<WeakReference<ClickableSpan>> f = f(view);
        if (f != null) {
            return f;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(a.g.b.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    public int b() {
        return this.f211b.getChildCount();
    }

    public void d(Rect rect) {
        this.f211b.setBoundsInScreen(rect);
    }

    public CharSequence f() {
        return this.f211b.getPackageName();
    }

    public CharSequence g() {
        if (!y()) {
            return this.f211b.getText();
        }
        List<Integer> a2 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> a3 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> a4 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> a5 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f211b.getText(), 0, this.f211b.getText().length()));
        for (int i = 0; i < a2.size(); i++) {
            spannableString.setSpan(new a(a5.get(i).intValue(), this, e().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), a2.get(i).intValue(), a3.get(i).intValue(), a4.get(i).intValue());
        }
        return spannableString;
    }

    public void j(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f211b.setScreenReaderFocusable(z);
        } else {
            a(1, z);
        }
    }

    @Deprecated
    public void k(boolean z) {
        this.f211b.setScrollable(z);
    }

    public boolean l() {
        return this.f211b.isClickable();
    }

    public void a(View view) {
        this.f211b.addChild(view);
    }

    public boolean b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f211b.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.H);
        }
        return false;
    }

    public void c(View view) {
        this.f211b.setParent(view);
    }

    @Deprecated
    public void d(boolean z) {
        this.f211b.setClickable(z);
    }

    public void f(CharSequence charSequence) {
        this.f211b.setText(charSequence);
    }

    public void h(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f211b.setHeading(z);
        } else {
            a(2, z);
        }
    }

    @Deprecated
    public void i(boolean z) {
        this.f211b.setLongClickable(z);
    }

    public boolean m() {
        return this.f211b.isEnabled();
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final Object f214a;

        b(Object obj) {
            this.f214a = obj;
        }

        public static b a(int i, int i2, boolean z, int i3) {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 21) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
            }
            if (i4 >= 19) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
            }
            return new b((Object) null);
        }

        public static b a(int i, int i2, boolean z) {
            if (Build.VERSION.SDK_INT >= 19) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
            }
            return new b((Object) null);
        }
    }

    private SparseArray<WeakReference<ClickableSpan>> f(View view) {
        return (SparseArray) view.getTag(a.g.b.tag_accessibility_clickable_spans);
    }

    public void a(View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f211b.addChild(view, i);
        }
    }

    public void c(Rect rect) {
        this.f211b.setBoundsInParent(rect);
    }

    public void d(CharSequence charSequence) {
        this.f211b.setPackageName(charSequence);
    }

    public void b(View view, int i) {
        this.c = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f211b.setParent(view, i);
        }
    }

    public void c(boolean z) {
        this.f211b.setChecked(z);
    }

    public CharSequence d() {
        return this.f211b.getContentDescription();
    }

    public Bundle e() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.f211b.getExtras();
        }
        return new Bundle();
    }

    public int a() {
        return this.f211b.getActions();
    }

    public CharSequence c() {
        return this.f211b.getClassName();
    }

    public void a(int i) {
        this.f211b.addAction(i);
    }

    public void c(CharSequence charSequence) {
        this.f211b.setContentDescription(charSequence);
    }

    private List<Integer> a(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f211b.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList arrayList = new ArrayList();
        this.f211b.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public void b(Rect rect) {
        this.f211b.getBoundsInScreen(rect);
    }

    public void e(CharSequence charSequence) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            this.f211b.setPaneTitle(charSequence);
        } else if (i >= 19) {
            this.f211b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void b(boolean z) {
        this.f211b.setCheckable(z);
    }

    public void b(CharSequence charSequence) {
        this.f211b.setClassName(charSequence);
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f211b.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((C0009c) obj).f215a);
        }
    }

    public void a(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f211b.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.H);
        }
    }

    private void g(View view) {
        SparseArray<WeakReference<ClickableSpan>> f = f(view);
        if (f != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < f.size(); i++) {
                if (f.valueAt(i).get() == null) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                f.remove(((Integer) arrayList.get(i2)).intValue());
            }
        }
    }

    public boolean a(int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f211b.performAction(i, bundle);
        }
        return false;
    }

    public void a(Rect rect) {
        this.f211b.getBoundsInParent(rect);
    }

    public void a(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f211b.setAccessibilityFocused(z);
        }
    }

    public void a(CharSequence charSequence, View view) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19 && i < 26) {
            x();
            g(view);
            ClickableSpan[] a2 = a(charSequence);
            if (a2 != null && a2.length > 0) {
                e().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", a.g.b.accessibility_action_clickable_span);
                SparseArray<WeakReference<ClickableSpan>> e = e(view);
                int i2 = 0;
                while (a2 != null && i2 < a2.length) {
                    int a3 = a(a2[i2], e);
                    e.put(a3, new WeakReference(a2[i2]));
                    a(a2[i2], (Spanned) charSequence, a3);
                    i2++;
                }
            }
        }
    }

    public static ClickableSpan[] a(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private int a(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (clickableSpan.equals((ClickableSpan) sparseArray.valueAt(i).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i2 = f210a;
        f210a = i2 + 1;
        return i2;
    }

    private void a(ClickableSpan clickableSpan, Spanned spanned, int i) {
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f211b.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f214a);
        }
    }

    private void a(int i, boolean z) {
        Bundle e = e();
        if (e != null) {
            int i2 = e.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (i ^ -1);
            if (!z) {
                i = 0;
            }
            e.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }
}
