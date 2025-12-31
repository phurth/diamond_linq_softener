package b.a.a;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.C0129e;
import androidx.fragment.app.C0134j;
import b.a.a.d.e;

public final class P extends C0129e {
    private e ga;
    private Q ha;
    private String ia;
    private int ja;
    private String ka;
    private String la;
    private String ma;
    private String na;
    private int oa;
    private int pa;
    private int qa;
    private double ra;
    private double sa;
    private String ta;

    public /* synthetic */ void a(EditText editText, View view) {
        String trim = editText.getText().toString().trim();
        Q q = this.ha;
        if (q == Q.IntInput || q == Q.ByteInput) {
            if (ia.a(trim)) {
                trim = this.na;
            }
            if (!ia.a(trim)) {
                try {
                    if (this.ha == Q.IntInput) {
                        trim = String.valueOf(Math.max(this.pa, Math.min(this.qa, Integer.parseInt(trim))));
                    } else if (this.ha == Q.ByteInput) {
                        trim = String.valueOf((byte) Math.max(this.pa, Math.min(this.qa, Byte.parseByte(trim))));
                    }
                } catch (Exception unused) {
                    e eVar = this.ga;
                    if (eVar != null) {
                        eVar.a(this.ia);
                    }
                    ha();
                }
            } else {
                e eVar2 = this.ga;
                if (eVar2 != null) {
                    eVar2.a(this.ia);
                }
            }
        }
        e eVar3 = this.ga;
        if (eVar3 != null) {
            eVar3.a(this.ia, trim, this.ta);
        }
        ha();
    }

    public /* synthetic */ void c(View view) {
        e eVar = this.ga;
        if (eVar != null) {
            eVar.a(this.ia);
        }
        ha();
    }

    public void e(Bundle bundle) {
        super.e(bundle);
        Q q = this.ha;
        bundle.putInt("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.input_type", q == null ? 0 : q.a());
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.id", this.ia);
        bundle.putInt("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.icon_resource_id", this.ja);
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.title", this.ka);
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.message", this.la);
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.hint", this.ma);
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.current_value", this.na);
        bundle.putInt("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.max_length", this.oa);
        bundle.putInt("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.min_value", this.pa);
        bundle.putInt("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.max_value", this.qa);
        bundle.putDouble("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.min_value", (double) this.pa);
        bundle.putDouble("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.max_value", (double) this.qa);
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.extra", this.ta);
    }

    public Dialog n(Bundle bundle) {
        if (bundle != null) {
            Q q = this.ha;
            this.ha = Q.a(bundle.getInt("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.input_type", q == null ? 0 : q.a()));
            this.ia = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.id", this.ia);
            this.ja = bundle.getInt("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.id", this.ja);
            this.ka = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.title", this.ka);
            this.la = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.message", this.la);
            this.ma = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.hint", this.ma);
            this.na = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.current_value", this.na);
            this.oa = bundle.getInt("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.max_length", this.oa);
            this.pa = bundle.getInt("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.min_value", this.pa);
            this.qa = bundle.getInt("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.max_value", this.qa);
            this.ra = bundle.getDouble("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.min_value", this.ra);
            this.sa = bundle.getDouble("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.max_value", this.sa);
            this.ta = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.dialog_input.extra", this.ta);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(f());
        View inflate = LayoutInflater.from(f()).inflate(Da.dialog_text_input, (ViewGroup) null, false);
        builder.setView(inflate);
        ((ImageView) inflate.findViewById(Ba.icon)).setImageResource(this.ja);
        ((TextView) inflate.findViewById(Ba.title)).setText(this.ka);
        TextView textView = (TextView) inflate.findViewById(Ba.message);
        if (!ia.a(this.la)) {
            try {
                textView.setAutoLinkMask(15);
            } catch (Exception unused) {
            }
            textView.setText(this.la);
        } else {
            textView.setVisibility(4);
        }
        EditText editText = (EditText) inflate.findViewById(Ba.user_input);
        int i = this.oa;
        if (i > 0) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Math.max(0, Math.min(10000, i)))});
        }
        if (this.ha == Q.IntInput) {
            editText.setInputType(2);
        }
        if (!ia.a(this.ma)) {
            editText.setHint(this.ma);
        }
        inflate.findViewById(Ba.button_positive).setOnClickListener(new C0185i(this, editText));
        inflate.findViewById(Ba.button_negative).setOnClickListener(new C0186j(this));
        return builder.create();
    }

    public void c(Bundle bundle) {
        try {
            if (ia() != null) {
                Window window = ia().getWindow();
                C0134j f = f();
                if (!(window == null || f == null)) {
                    window.setFlags(8, 8);
                    window.getDecorView().setSystemUiVisibility(f.getWindow().getDecorView().getSystemUiVisibility());
                    ia().setOnShowListener(new C0187k(window, f));
                }
            }
        } catch (Exception unused) {
        }
        super.c(bundle);
    }

    static /* synthetic */ void a(Window window, C0134j jVar, DialogInterface dialogInterface) {
        window.clearFlags(8);
        try {
            ((WindowManager) jVar.getSystemService("window")).updateViewLayout(window.getDecorView(), window.getAttributes());
        } catch (Exception unused) {
        }
    }

    public void a(Context context) {
        super.a(context);
        try {
            this.ga = (e) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context.toString().concat(" must implement CsDialogEvents"));
        }
    }

    public void a(Q q, String str, int i, String str2, String str3, String str4, String str5, int i2, int i3, int i4, String str6) {
        this.ha = q;
        this.ia = str;
        this.ja = i;
        this.ka = str2;
        this.la = str3;
        this.ma = str4;
        this.na = str5;
        this.oa = i2;
        this.pa = i3;
        this.qa = i4;
        this.ta = str6;
    }
}
