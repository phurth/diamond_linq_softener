package b.a.a.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import androidx.viewpager.widget.a;
import b.a.a.Ba;
import b.a.a.C0166aa;
import b.a.a.C0168ba;
import b.a.a.Da;
import b.a.a.d.g;
import b.a.a.ma;

public final class c extends a {
    private Context c;
    private g d;

    public c(Context context, g gVar) {
        this.c = context;
        this.d = gVar;
    }

    public int a() {
        return C0166aa.values().length;
    }

    public boolean a(View view, Object obj) {
        return view == obj;
    }

    public Object a(ViewGroup viewGroup, int i) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(this.c).inflate(Da.intro_page, viewGroup, false);
        if (this.c != null) {
            try {
                C0166aa aaVar = C0166aa.values()[i];
                ((ImageView) viewGroup2.findViewById(Ba.intro_page_image)).setImageDrawable(this.c.getResources().getDrawable(aaVar.a()));
                if (aaVar.b() == 99) {
                    Button button = (Button) viewGroup2.findViewById(Ba.intro_completed_button);
                    CheckBox checkBox = (CheckBox) viewGroup2.findViewById(Ba.intro_completed_checkbox);
                    button.setVisibility(0);
                    checkBox.setVisibility(0);
                    button.setOnClickListener(new a(this, checkBox));
                }
            } catch (Exception unused) {
                a(true);
            } catch (OutOfMemoryError unused2) {
                a(true);
            }
        }
        viewGroup.addView(viewGroup2);
        return viewGroup2;
    }

    public /* synthetic */ void a(CheckBox checkBox, View view) {
        a(checkBox.isChecked());
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    private void a(boolean z) {
        C0168ba.c("Completed!!!!");
        ma.a(this.c, z);
        g gVar = this.d;
        if (gVar != null) {
            gVar.a(true);
        }
    }
}
