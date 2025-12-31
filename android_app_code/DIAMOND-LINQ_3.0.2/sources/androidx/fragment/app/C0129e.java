package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;

/* renamed from: androidx.fragment.app.e  reason: case insensitive filesystem */
public class C0129e extends C0132h implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private Handler V;
    private Runnable W = new C0128d(this);
    int X = 0;
    int Y = 0;
    boolean Z = true;
    boolean aa = true;
    int ba = -1;
    Dialog ca;
    boolean da;
    boolean ea;
    boolean fa;

    public void N() {
        super.N();
        Dialog dialog = this.ca;
        if (dialog != null) {
            this.da = true;
            dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
            this.ca.dismiss();
            if (!this.ea) {
                onDismiss(this.ca);
            }
            this.ca = null;
        }
    }

    public void O() {
        super.O();
        if (!this.fa && !this.ea) {
            this.ea = true;
        }
    }

    public void R() {
        super.R();
        Dialog dialog = this.ca;
        if (dialog != null) {
            this.da = false;
            dialog.show();
        }
    }

    public void S() {
        super.S();
        Dialog dialog = this.ca;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public void a(C0139o oVar, String str) {
        this.ea = false;
        this.fa = true;
        D a2 = oVar.a();
        a2.a((C0132h) this, str);
        a2.a();
    }

    public void b(Bundle bundle) {
        Bundle bundle2;
        super.b(bundle);
        if (this.aa) {
            View D = D();
            if (D != null) {
                if (D.getParent() == null) {
                    this.ca.setContentView(D);
                } else {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
            }
            C0134j f = f();
            if (f != null) {
                this.ca.setOwnerActivity(f);
            }
            this.ca.setCancelable(this.Z);
            this.ca.setOnCancelListener(this);
            this.ca.setOnDismissListener(this);
            if (bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
                this.ca.onRestoreInstanceState(bundle2);
            }
        }
    }

    public void c(Bundle bundle) {
        super.c(bundle);
        this.V = new Handler();
        this.aa = this.w == 0;
        if (bundle != null) {
            this.X = bundle.getInt("android:style", 0);
            this.Y = bundle.getInt("android:theme", 0);
            this.Z = bundle.getBoolean("android:cancelable", true);
            this.aa = bundle.getBoolean("android:showsDialog", this.aa);
            this.ba = bundle.getInt("android:backStackId", -1);
        }
    }

    public LayoutInflater d(Bundle bundle) {
        if (!this.aa) {
            return super.d(bundle);
        }
        this.ca = n(bundle);
        Dialog dialog = this.ca;
        if (dialog == null) {
            return (LayoutInflater) this.s.d().getSystemService("layout_inflater");
        }
        a(dialog, this.X);
        return (LayoutInflater) this.ca.getContext().getSystemService("layout_inflater");
    }

    public void e(Bundle bundle) {
        Bundle onSaveInstanceState;
        super.e(bundle);
        Dialog dialog = this.ca;
        if (!(dialog == null || (onSaveInstanceState = dialog.onSaveInstanceState()) == null)) {
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i = this.X;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.Y;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.Z;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.aa;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.ba;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    public void g(boolean z) {
        this.Z = z;
        Dialog dialog = this.ca;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public void ha() {
        a(false, false);
    }

    public Dialog ia() {
        return this.ca;
    }

    public int ja() {
        return this.Y;
    }

    public Dialog n(Bundle bundle) {
        return new Dialog(da(), ja());
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.da) {
            a(true, true);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z, boolean z2) {
        if (!this.ea) {
            this.ea = true;
            this.fa = false;
            Dialog dialog = this.ca;
            if (dialog != null) {
                dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
                this.ca.dismiss();
                if (!z2) {
                    if (Looper.myLooper() == this.V.getLooper()) {
                        onDismiss(this.ca);
                    } else {
                        this.V.post(this.W);
                    }
                }
            }
            this.da = true;
            if (this.ba >= 0) {
                ea().a(this.ba, 1);
                this.ba = -1;
                return;
            }
            D a2 = ea().a();
            a2.a((C0132h) this);
            if (z) {
                a2.b();
            } else {
                a2.a();
            }
        }
    }

    public void a(Context context) {
        super.a(context);
        if (!this.fa) {
            this.ea = false;
        }
    }

    public void a(Dialog dialog, int i) {
        if (!(i == 1 || i == 2)) {
            if (i == 3) {
                dialog.getWindow().addFlags(24);
            } else {
                return;
            }
        }
        dialog.requestWindowFeature(1);
    }
}
