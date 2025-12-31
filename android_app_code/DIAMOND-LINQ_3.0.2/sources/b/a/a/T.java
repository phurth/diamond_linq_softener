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
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.C0129e;
import androidx.fragment.app.C0134j;
import b.a.a.d.e;
import no.nordicsemi.android.log.BuildConfig;

public class T extends C0129e {
    private e ga;
    private String ha;
    private String ia;
    private String ja;
    private String ka;
    private String la;
    private String ma;

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
            eVar.a(this.ha, BuildConfig.FLAVOR, this.ma);
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
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.dialog_question.id", this.ha);
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.dialog_question.title", this.ia);
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.dialog_question.message", this.ja);
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.dialog_question.positive_button", this.ka);
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.dialog_question.negative_button", this.la);
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.dialog_question.extra", this.ma);
    }

    public Dialog n(Bundle bundle) {
        if (bundle != null) {
            this.ha = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.dialog_question.id", this.ha);
            this.ia = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.dialog_question.title", this.ia);
            this.ja = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.dialog_question.message", this.ja);
            this.ka = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.dialog_question.positive_button", this.ka);
            this.la = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.dialog_question.negative_button", this.la);
            this.ma = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.dialog_question.extra", this.ma);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(f());
        View inflate = LayoutInflater.from(f()).inflate(Da.dialog_question, (ViewGroup) null, false);
        builder.setView(inflate);
        ((TextView) inflate.findViewById(Ba.title)).setText(this.ia);
        Button button = (Button) inflate.findViewById(Ba.button_positive);
        Button button2 = (Button) inflate.findViewById(Ba.button_negative);
        TextView textView = (TextView) inflate.findViewById(Ba.message);
        textView.setAutoLinkMask(1);
        textView.setText(this.ja);
        button.setText(this.ka);
        button.setOnClickListener(new C0188l(this));
        button2.setText(this.la);
        button2.setOnClickListener(new C0190n(this));
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
                    ia().setOnShowListener(new C0189m(window, f));
                }
            }
        } catch (Exception unused) {
        }
        super.c(bundle);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.ha = str;
        this.ia = str2;
        this.ja = str3;
        this.ka = str4;
        this.la = str5;
        this.ma = str6;
    }
}
