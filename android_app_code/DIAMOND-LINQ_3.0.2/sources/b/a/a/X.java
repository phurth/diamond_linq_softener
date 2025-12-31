package b.a.a;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.C0129e;
import androidx.fragment.app.C0134j;

public final class X extends C0129e {
    private String ga;
    private String[] ha;

    static /* synthetic */ void a(Window window, C0134j jVar, DialogInterface dialogInterface) {
        window.clearFlags(8);
        try {
            ((WindowManager) jVar.getSystemService("window")).updateViewLayout(window.getDecorView(), window.getAttributes());
        } catch (Exception unused) {
        }
    }

    public /* synthetic */ void c(View view) {
        ha();
    }

    public void e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("com.ChandlerSystemsInc.SignatureAppCore.dialog_question.title", this.ga);
        bundle.putStringArray("com.ChandlerSystemsInc.SignatureAppCore.dialog_question.data", this.ha);
    }

    public Dialog n(Bundle bundle) {
        if (bundle != null) {
            this.ga = bundle.getString("com.ChandlerSystemsInc.SignatureAppCore.dialog_question.title", this.ga);
            this.ha = bundle.getStringArray("com.ChandlerSystemsInc.SignatureAppCore.dialog_question.data");
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(f());
        View inflate = LayoutInflater.from(f()).inflate(Da.dialog_view_data, (ViewGroup) null, false);
        builder.setView(inflate);
        ((TextView) inflate.findViewById(Ba.title)).setText(this.ga);
        ListView listView = (ListView) inflate.findViewById(Ba.graph_data);
        if (this.ha != null) {
            listView.setAdapter(new ArrayAdapter(inflate.getContext(), 17367043, this.ha));
        }
        inflate.findViewById(Ba.button_ok).setOnClickListener(new C0196u(this));
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
                    ia().setOnShowListener(new C0197v(window, f));
                }
            }
        } catch (Exception unused) {
        }
        super.c(bundle);
    }

    public void a(String str, String[] strArr) {
        this.ga = str;
        this.ha = strArr;
    }
}
