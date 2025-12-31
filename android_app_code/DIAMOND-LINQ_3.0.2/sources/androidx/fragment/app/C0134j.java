package androidx.fragment.app;

import a.d.j;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.core.app.a;
import androidx.lifecycle.D;
import androidx.lifecycle.E;
import androidx.lifecycle.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: androidx.fragment.app.j  reason: case insensitive filesystem */
public class C0134j extends androidx.activity.a implements a.C0023a, a.c {
    final C0136l h = C0136l.a((C0138n<?>) new a());
    boolean i;
    boolean j;
    boolean k = true;
    boolean l;
    boolean m;
    int n;
    j<String> o;

    /* renamed from: androidx.fragment.app.j$a */
    class a extends C0138n<C0134j> implements E {
        public a() {
            super(C0134j.this);
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            C0134j.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        public boolean b(C0132h hVar) {
            return !C0134j.this.isFinishing();
        }

        public D c() {
            return C0134j.this.c();
        }

        public LayoutInflater f() {
            return C0134j.this.getLayoutInflater().cloneInContext(C0134j.this);
        }

        public int g() {
            Window window = C0134j.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        public boolean h() {
            return C0134j.this.getWindow() != null;
        }

        public void i() {
            C0134j.this.u();
        }

        public void a(C0132h hVar, Intent intent, int i, Bundle bundle) {
            C0134j.this.a(hVar, intent, i, bundle);
        }

        public void a(C0132h hVar) {
            C0134j.this.a(hVar);
        }

        public View a(int i) {
            return C0134j.this.findViewById(i);
        }

        public boolean a() {
            Window window = C0134j.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    public C0134j() {
        v();
    }

    private int b(C0132h hVar) {
        if (this.o.b() < 65534) {
            while (this.o.b(this.n) >= 0) {
                this.n = (this.n + 1) % 65534;
            }
            int i2 = this.n;
            this.o.c(i2, hVar.f);
            this.n = (this.n + 1) % 65534;
            return i2;
        }
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }

    private void v() {
        q().a(this, new C0133i(this));
    }

    private void w() {
        do {
        } while (a(s(), h.b.CREATED));
    }

    /* access modifiers changed from: package-private */
    public final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.h.a(view, str, context, attributeSet);
    }

    public void a(C0132h hVar) {
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.i);
        printWriter.print(" mResumed=");
        printWriter.print(this.j);
        printWriter.print(" mStopped=");
        printWriter.print(this.k);
        if (getApplication() != null) {
            a.k.a.a.a(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.h.j().a(str, fileDescriptor, printWriter, strArr);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.h.k();
        int i4 = i2 >> 16;
        if (i4 != 0) {
            int i5 = i4 - 1;
            String a2 = this.o.a(i5);
            this.o.d(i5);
            if (a2 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            C0132h a3 = this.h.a(a2);
            if (a3 == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + a2);
                return;
            }
            a3.a(i2 & 65535, i3, intent);
            return;
        }
        a.b a4 = androidx.core.app.a.a();
        if (a4 == null || !a4.a(this, i2, i3, intent)) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.h.k();
        this.h.a(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.h.a((C0132h) null);
        if (bundle != null) {
            this.h.a(bundle.getParcelable("android:support:fragments"));
            if (bundle.containsKey("android:support:next_request_index")) {
                this.n = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.o = new j<>(intArray.length);
                    for (int i2 = 0; i2 < intArray.length; i2++) {
                        this.o.c(intArray[i2], stringArray[i2]);
                    }
                }
            }
        }
        if (this.o == null) {
            this.o = new j<>();
            this.n = 0;
        }
        super.onCreate(bundle);
        this.h.b();
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 == 0) {
            return super.onCreatePanelMenu(i2, menu) | this.h.a(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i2, menu);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a2 = a(view, str, context, attributeSet);
        return a2 == null ? super.onCreateView(view, str, context, attributeSet) : a2;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.h.c();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.h.d();
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.h.b(menuItem);
        }
        if (i2 != 6) {
            return false;
        }
        return this.h.a(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.h.a(z);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.h.k();
    }

    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            this.h.a(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.j = false;
        this.h.e();
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.h.b(z);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        t();
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 == 0) {
            return a(view, menu) | this.h.b(menu);
        }
        return super.onPreparePanel(i2, view, menu);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.h.k();
        int i3 = (i2 >> 16) & 65535;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String a2 = this.o.a(i4);
            this.o.d(i4);
            if (a2 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            C0132h a3 = this.h.a(a2);
            if (a3 == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + a2);
                return;
            }
            a3.a(i2 & 65535, strArr, iArr);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.j = true;
        this.h.k();
        this.h.i();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        w();
        Parcelable l2 = this.h.l();
        if (l2 != null) {
            bundle.putParcelable("android:support:fragments", l2);
        }
        if (this.o.b() > 0) {
            bundle.putInt("android:support:next_request_index", this.n);
            int[] iArr = new int[this.o.b()];
            String[] strArr = new String[this.o.b()];
            for (int i2 = 0; i2 < this.o.b(); i2++) {
                iArr[i2] = this.o.c(i2);
                strArr[i2] = this.o.e(i2);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.k = false;
        if (!this.i) {
            this.i = true;
            this.h.a();
        }
        this.h.k();
        this.h.i();
        this.h.g();
    }

    public void onStateNotSaved() {
        this.h.k();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.k = true;
        w();
        this.h.h();
    }

    public C0139o s() {
        return this.h.j();
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        if (!this.m && i2 != -1) {
            a(i2);
        }
        super.startActivityForResult(intent, i2);
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        if (!this.l && i2 != -1) {
            a(i2);
        }
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public void t() {
        this.h.f();
    }

    @Deprecated
    public void u() {
        invalidateOptionsMenu();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public boolean a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    static void a(int i2) {
        if ((i2 & -65536) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View a2 = a((View) null, str, context, attributeSet);
        return a2 == null ? super.onCreateView(str, context, attributeSet) : a2;
    }

    public void a(C0132h hVar, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        this.m = true;
        if (i2 == -1) {
            try {
                androidx.core.app.a.a(this, intent, -1, bundle);
            } finally {
                this.m = false;
            }
        } else {
            a(i2);
            androidx.core.app.a.a(this, intent, ((b(hVar) + 1) << 16) + (i2 & 65535), bundle);
            this.m = false;
        }
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (!this.m && i2 != -1) {
            a(i2);
        }
        super.startActivityForResult(intent, i2, bundle);
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        if (!this.l && i2 != -1) {
            a(i2);
        }
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    private static boolean a(C0139o oVar, h.b bVar) {
        boolean z = false;
        for (C0132h next : oVar.d()) {
            if (next != null) {
                if (next.a().a().a(h.b.STARTED)) {
                    next.Q.a(bVar);
                    z = true;
                }
                C0139o T = next.T();
                if (T != null) {
                    z |= a(T, bVar);
                }
            }
        }
        return z;
    }
}
