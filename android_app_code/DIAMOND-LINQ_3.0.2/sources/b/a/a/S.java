package b.a.a;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.C0129e;

public final class S extends C0129e {
    private static Bundle ga = new Bundle();
    private ProgressBar ha;
    private TextView ia;
    private TextView ja;
    private C0178da ka = new C0178da(0.025d);
    private String la;
    private String ma;
    private long na;
    private int oa;

    public void a(String str, String str2) {
        this.la = str;
        this.ma = str2;
    }

    public void e(int i) {
        ProgressBar progressBar = this.ha;
        if (progressBar != null) {
            progressBar.setMax(i);
        }
    }

    public void f(int i) {
        ProgressBar progressBar = this.ha;
        if (progressBar != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                progressBar.setProgress(i, true);
            } else {
                progressBar.setProgress(i);
            }
            double d = (double) i;
            double max = (double) this.ha.getMax();
            Double.isNaN(d);
            Double.isNaN(max);
            int i2 = (int) ((d / max) * 100.0d);
            this.ia.setText(String.format(a(Fa.progress_percent), new Object[]{Integer.valueOf(i2)}));
            if (i2 == 100) {
                this.oa = 0;
            }
        }
    }

    public void ka() {
        ProgressBar progressBar = this.ha;
        if (progressBar == null || this.oa < 4) {
            this.oa++;
            return;
        }
        int max = ((((progressBar.getMax() - this.ha.getProgress()) * this.ka.a((int) (System.currentTimeMillis() - this.na))) / 1000) / 100) / 2;
        int i = max / 60;
        int i2 = max % 60;
        String format = String.format(a(Fa.progress_seconds), new Object[]{Integer.valueOf(i2)});
        if (i > 0) {
            if (max > 0) {
                format = String.format(a(Fa.progress_minutes_seconds), new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            } else {
                format = String.format(a(Fa.progress_minutes), new Object[]{Integer.valueOf(i)});
            }
        }
        TextView textView = this.ja;
        if (textView != null) {
            textView.setText(format);
        }
    }

    public boolean la() {
        ProgressBar progressBar = this.ha;
        if (progressBar == null || progressBar.getProgress() < this.ha.getMax()) {
            return false;
        }
        return true;
    }

    public void ma() {
        this.ka = new C0178da(0.025d);
        this.na = 0;
        this.oa = 0;
    }

    public Dialog n(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(f());
        View inflate = LayoutInflater.from(f()).inflate(Da.dialog_progress, (ViewGroup) null, false);
        builder.setView(inflate);
        ((TextView) inflate.findViewById(Ba.title)).setText(this.la);
        ((TextView) inflate.findViewById(Ba.message)).setText(this.ma);
        this.ha = (ProgressBar) inflate.findViewById(Ba.progressBar);
        this.ia = (TextView) inflate.findViewById(Ba.percentComplete);
        this.ja = (TextView) inflate.findViewById(Ba.timeRemaining);
        return builder.create();
    }

    public void na() {
        this.na = System.currentTimeMillis();
    }
}
