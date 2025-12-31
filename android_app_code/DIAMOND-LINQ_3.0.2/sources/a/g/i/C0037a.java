package a.g.i;

import a.g.b;
import a.g.i.a.c;
import a.g.i.a.d;
import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* renamed from: a.g.i.a  reason: case insensitive filesystem */
public class C0037a {

    /* renamed from: a  reason: collision with root package name */
    private static final View.AccessibilityDelegate f205a = new View.AccessibilityDelegate();

    /* renamed from: b  reason: collision with root package name */
    private final View.AccessibilityDelegate f206b;
    private final View.AccessibilityDelegate c;

    /* renamed from: a.g.i.a$a  reason: collision with other inner class name */
    static final class C0008a extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        final C0037a f207a;

        C0008a(C0037a aVar) {
            this.f207a = aVar;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f207a.a(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            d a2 = this.f207a.a(view);
            if (a2 != null) {
                return (AccessibilityNodeProvider) a2.a();
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f207a.b(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            c a2 = c.a(accessibilityNodeInfo);
            a2.j(y.D(view));
            a2.h(y.y(view));
            a2.e(y.d(view));
            this.f207a.a(view, a2);
            a2.a(accessibilityNodeInfo.getText(), view);
            List<c.a> b2 = C0037a.b(view);
            for (int i = 0; i < b2.size(); i++) {
                a2.a(b2.get(i));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f207a.c(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f207a.a(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f207a.a(view, i, bundle);
        }

        public void sendAccessibilityEvent(View view, int i) {
            this.f207a.a(view, i);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f207a.d(view, accessibilityEvent);
        }
    }

    public C0037a() {
        this(f205a);
    }

    /* access modifiers changed from: package-private */
    public View.AccessibilityDelegate a() {
        return this.c;
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        this.f206b.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f206b.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        this.f206b.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public C0037a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f206b = accessibilityDelegate;
        this.c = new C0008a(this);
    }

    static List<c.a> b(View view) {
        List<c.a> list = (List) view.getTag(b.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    public void a(View view, int i) {
        this.f206b.sendAccessibilityEvent(view, i);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f206b.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void a(View view, c cVar) {
        this.f206b.onInitializeAccessibilityNodeInfo(view, cVar.w());
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f206b.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public d a(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.f206b.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new d(accessibilityNodeProvider);
    }

    public boolean a(View view, int i, Bundle bundle) {
        List<c.a> b2 = b(view);
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= b2.size()) {
                break;
            }
            c.a aVar = b2.get(i2);
            if (aVar.a() == i) {
                z = aVar.a(view, bundle);
                break;
            }
            i2++;
        }
        if (!z && Build.VERSION.SDK_INT >= 16) {
            z = this.f206b.performAccessibilityAction(view, i, bundle);
        }
        return (z || i != b.accessibility_action_clickable_span) ? z : a(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    private boolean a(int i, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(b.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!a(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    private boolean a(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] a2 = c.a(view.createAccessibilityNodeInfo().getText());
            int i = 0;
            while (a2 != null && i < a2.length) {
                if (clickableSpan.equals(a2[i])) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}
