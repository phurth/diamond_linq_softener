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
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.fragment.app.C0129e;
import androidx.fragment.app.C0134j;
import b.a.a.d.e;

public class V extends C0129e {
    private e ga;
    private String ha;
    private int ia;
    private String ja;
    private String ka;
    private String la;
    private String ma;
    private int na;
    private int oa;
    private int pa;
    private B qa;
    private String ra;

    public /* synthetic */ void a(EditText editText, RadioButton radioButton, View view) {
        String trim = editText.getText().toString().trim();
        if (!ia.a(trim)) {
            int max = Math.max(this.oa, Math.min(this.pa, Integer.parseInt(trim)));
            String a2 = a(radioButton.isChecked() ? Fa.am : Fa.pm);
            e eVar = this.ga;
            if (eVar != null) {
                eVar.a(this.ha, String.valueOf(max).concat(" ").concat(a2), this.ra);
            }
        } else {
            e eVar2 = this.ga;
            if (eVar2 != null) {
                eVar2.a(this.ha);
            }
        }
        ha();
    }

    public /* synthetic */ void c(View view) {
        e eVar = this.ga;
        if (eVar != null) {
            eVar.a(this.ha);
        }
        ha();
    }

    public void e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.id", this.ha);
        bundle.putInt("com.ChandlerSystemsInc.SignatureAppCore.icon_resource_id", this.ia);
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.title", this.ja);
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.message", this.ka);
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.hint", this.la);
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.default_input", this.ma);
        bundle.putInt("com.ChandlerSystemsInc.SignatureAppCore.max_length", this.na);
        bundle.putInt("com.ChandlerSystemsInc.SignatureAppCore.min_value", this.oa);
        bundle.putInt("com.ChandlerSystemsInc.SignatureAppCore.max_value", this.pa);
        B b2 = this.qa;
        bundle.putInt("com.ChandlerSystemsInc.SignatureAppCore.amPm", b2 == null ? 0 : b2.a());
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.extra", this.ra);
    }

    public Dialog n(Bundle bundle) {
        if (bundle != null) {
            this.ha = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.id", this.ha);
            this.ia = bundle.getInt("com.ChandlerSystemsInc.SignatureAppCore.id", this.ia);
            this.ja = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.title", this.ja);
            this.ka = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.message", this.ka);
            this.la = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.hint", this.la);
            this.ma = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.default_input", this.ma);
            this.na = bundle.getInt("com.ChandlerSystemsInc.SignatureAppCore.max_length", this.na);
            this.oa = bundle.getInt("com.ChandlerSystemsInc.SignatureAppCore.min_value", this.oa);
            this.pa = bundle.getInt("com.ChandlerSystemsInc.SignatureAppCore.max_value", this.pa);
            B b2 = this.qa;
            this.qa = B.a(bundle.getInt("com.ChandlerSystemsInc.SignatureAppCore.amPm", b2 == null ? 0 : b2.a()));
            this.ra = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.extra", this.ra);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(f());
        View inflate = LayoutInflater.from(f()).inflate(Da.dialog_time_input, (ViewGroup) null, false);
        builder.setView(inflate);
        ((ImageView) inflate.findViewById(Ba.icon)).setImageResource(this.ia);
        ((TextView) inflate.findViewById(Ba.title)).setText(this.ja);
        TextView textView = (TextView) inflate.findViewById(Ba.message);
        RadioButton radioButton = (RadioButton) inflate.findViewById(Ba.am);
        RadioButton radioButton2 = (RadioButton) inflate.findViewById(Ba.pm);
        if (this.qa == B.AM) {
            radioButton.setChecked(true);
        } else {
            radioButton2.setChecked(true);
        }
        if (!ia.a(this.ka)) {
            textView.setAutoLinkMask(15);
            textView.setText(this.ka);
        } else {
            textView.setVisibility(4);
        }
        EditText editText = (EditText) inflate.findViewById(Ba.user_input);
        editText.setInputType(2);
        int i = this.na;
        if (i > 0) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Math.max(0, Math.min(100, i)))});
        }
        if (!ia.a(this.la)) {
            editText.setHint(this.la);
        }
        if (!ia.a(this.ma)) {
            editText.setText(this.ma);
        }
        inflate.findViewById(Ba.button_positive).setOnClickListener(new r(this, editText, radioButton));
        inflate.findViewById(Ba.button_negative).setOnClickListener(new C0194s(this));
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
                    ia().setOnShowListener(new C0195t(window, f));
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

    public void a(String str, int i, String str2, String str3, String str4, String str5, int i2, int i3, int i4, B b2, String str6) {
        this.ha = str;
        this.ia = i;
        this.ja = str2;
        this.ka = str3;
        this.la = str4;
        this.ma = str5;
        this.na = i2;
        this.oa = i3;
        this.pa = i4;
        this.qa = b2;
        this.ra = str6;
    }
}
