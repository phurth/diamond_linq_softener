package no.nordicsemi.android.log;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import no.nordicsemi.android.log.LogContract;

public class LocalLogSession implements ILogSession {
    private final Context context;
    private final Uri sessionUri;

    LocalLogSession(Context context2, Uri uri) {
        this.context = context2.getApplicationContext();
        this.sessionUri = uri;
    }

    public static LocalLogSession newSession(Context context2, Uri uri, String str, String str2) {
        Uri build = uri.buildUpon().appendEncodedPath(LogContract.Session.SESSION_CONTENT_DIRECTORY).appendEncodedPath("key").appendEncodedPath(str).build();
        ContentValues contentValues = new ContentValues();
        contentValues.put(LogContract.SessionColumns.NAME, str2);
        try {
            Uri insert = context2.getContentResolver().insert(build, contentValues);
            if (insert != null) {
                return new LocalLogSession(context2, insert);
            }
            return null;
        } catch (Exception e) {
            Log.e("LocalLogSession", "Error while creating a local log session.", e);
            return null;
        }
    }

    public void delete() {
        try {
            this.context.getContentResolver().delete(this.sessionUri, (String) null, (String[]) null);
        } catch (Exception e) {
            Log.e("LocalLogSession", "Error while deleting local log session.", e);
        }
    }

    public Context getContext() {
        return this.context;
    }

    public Uri getSessionContentUri() {
        return this.sessionUri.buildUpon().appendEncodedPath("log").appendEncodedPath(LogContract.Session.Content.CONTENT).build();
    }

    public Uri getSessionEntriesUri() {
        return this.sessionUri.buildUpon().appendEncodedPath("log").build();
    }

    public Uri getSessionUri() {
        return this.sessionUri;
    }
}
