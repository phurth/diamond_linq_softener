package b.a.a;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.C0129e;
import androidx.fragment.app.C0134j;
import b.a.a.d.e;
import no.nordicsemi.android.log.BuildConfig;

public final class U extends C0129e {
    private e ga;
    private String ha;
    private String ia;
    private String ja;
    private String ka;

    static /* synthetic */ void a(Window window, C0134j jVar, DialogInterface dialogInterface) {
        window.clearFlags(8);
        try {
            ((WindowManager) jVar.getSystemService("window")).updateViewLayout(window.getDecorView(), window.getAttributes());
        } catch (Exception unused) {
        }
    }

    public /* synthetic */ void c(View view) {
        e eVar = this.ga;
        if (eVar != null) {
            eVar.a(this.ha, BuildConfig.FLAVOR, this.ka);
        }
        ha();
    }

    public /* synthetic */ void d(View view) {
        e eVar = this.ga;
        if (eVar != null) {
            eVar.a(this.ha);
        }
        ha();
    }

    public void e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.dialog_share.id", this.ha);
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.dialog_share.title", this.ia);
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.dialog_share.message", this.ja);
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.dialog_share.extra", this.ka);
    }

    public Dialog n(Bundle bundle) {
        if (bundle != null) {
            this.ha = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.dialog_share.id", this.ha);
            this.ia = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.dialog_share.title", this.ia);
            this.ja = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.dialog_share.message", this.ja);
            this.ka = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.dialog_share.extra", this.ka);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(f());
        View inflate = LayoutInflater.from(f()).inflate(Da.dialog_share, (ViewGroup) null, false);
        builder.setView(inflate);
        ((TextView) inflate.findViewById(Ba.title)).setText(this.ia);
        TextView textView = (TextView) inflate.findViewById(Ba.message);
        textView.setAutoLinkMask(15);
        textView.setText(this.ja);
        inflate.findViewById(Ba.button_share).setOnClickListener(new C0191o(this));
        inflate.findViewById(Ba.button_ok).setOnClickListener(new C0192p(this));
        return builder.create();
    }

    public void a(Context context) {
        super.a(context);
        try {
            this.ga = (e) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context.toString().concat(" must implement CsDialogEvents"));
        }
    }

    public void c(Bundle bundle) {
        try {
            if (ia() != null) {
                Window window = ia().getWindow();
                C0134j f = f();
                if (!(window == null || f == null)) {
                    window.setFlags(8, 8);
                    window.getDecorView().setSystemUiVisibility(f.getWindow().getDecorView().getSystemUiVisibility());
                    ia().setOnShowListener(new C0193q(window, f));
                }
            }
        } catch (Exception unused) {
        }
        super.c(bundle);
    }

    public void a(String str, String str2, String str3, String str4) {
        this.ha = str;
        this.ia = str2;
        this.ja = str3;
        this.ka = str4;
    }
}
