package no.nordicsemi.android.log;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import no.nordicsemi.android.log.LogContract;

public class LogSession implements ILogSession {
    private final Context context;
    private final Uri sessionUri;

    LogSession(Context context2, Uri uri) {
        this.context = context2.getApplicationContext();
        this.sessionUri = uri;
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

    public Uri getSessionsUri() {
        Cursor query;
        try {
            query = this.context.getContentResolver().query(this.sessionUri, new String[]{LogContract.SessionColumns.APPLICATION_ID}, (String) null, (String[]) null, (String) null);
            if (query.moveToNext()) {
                Uri createSessionsUri = LogContract.Session.createSessionsUri(query.getLong(0));
                query.close();
                return createSessionsUri;
            }
            query.close();
            return null;
        } catch (Exception unused) {
            return null;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    public String toString() {
        return this.sessionUri.toString();
    }
}
