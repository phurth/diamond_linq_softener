package no.nordicsemi.android.log.localprovider;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ProjectionMap extends HashMap<String, String> {
    private static final long serialVersionUID = -4004367756025538190L;
    /* access modifiers changed from: private */
    public String[] mColumns;

    public static class Builder {
        private ProjectionMap mMap = new ProjectionMap();

        /* access modifiers changed from: package-private */
        public Builder add(String str) {
            this.mMap.putColumn(str, str);
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder addAll(String[] strArr) {
            for (String add : strArr) {
                add(add);
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public ProjectionMap build() {
            String[] strArr = new String[this.mMap.size()];
            this.mMap.keySet().toArray(strArr);
            Arrays.sort(strArr);
            String[] unused = this.mMap.mColumns = strArr;
            return this.mMap;
        }

        /* access modifiers changed from: package-private */
        public Builder add(String str, String str2) {
            ProjectionMap projectionMap = this.mMap;
            projectionMap.putColumn(str, str2 + " AS " + str);
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder addAll(ProjectionMap projectionMap) {
            for (Map.Entry entry : projectionMap.entrySet()) {
                this.mMap.putColumn((String) entry.getKey(), (String) entry.getValue());
            }
            return this;
        }
    }

    static Builder builder() {
        return new Builder();
    }

    /* access modifiers changed from: private */
    public void putColumn(String str, String str2) {
        super.put(str, str2);
    }

    public String[] getColumnNames() {
        return this.mColumns;
    }

    public void putAll(Map<? extends String, ? extends String> map) {
        throw new UnsupportedOperationException();
    }

    private ProjectionMap() {
    }

    public String put(String str, String str2) {
        throw new UnsupportedOperationException();
    }
}
