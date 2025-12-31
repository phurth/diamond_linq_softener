package androidx.appcompat.app;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import androidx.appcompat.app.AlertController;

/* renamed from: androidx.appcompat.app.i  reason: case insensitive filesystem */
class C0079i extends CursorAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final int f415a;

    /* renamed from: b  reason: collision with root package name */
    private final int f416b;
    final /* synthetic */ AlertController.RecycleListView c;
    final /* synthetic */ AlertController d;
    final /* synthetic */ AlertController.a e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0079i(AlertController.a aVar, Context context, Cursor cursor, boolean z, AlertController.RecycleListView recycleListView, AlertController alertController) {
        super(context, cursor, z);
        this.e = aVar;
        this.c = recycleListView;
        this.d = alertController;
        Cursor cursor2 = getCursor();
        this.f415a = cursor2.getColumnIndexOrThrow(this.e.L);
        this.f416b = cursor2.getColumnIndexOrThrow(this.e.M);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f415a));
        AlertController.RecycleListView recycleListView = this.c;
        int position = cursor.getPosition();
        boolean z = true;
        if (cursor.getInt(this.f416b) != 1) {
            z = false;
        }
        recycleListView.setItemChecked(position, z);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.e.f376b.inflate(this.d.M, viewGroup, false);
    }
}
