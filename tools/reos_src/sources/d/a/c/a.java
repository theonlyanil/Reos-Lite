package d.a.c;

import e.n;
import e.s;
import e.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6180a = new a() { // from class: d.a.c.a.1
        @Override // d.a.c.a
        public t a(File file) throws FileNotFoundException {
            return n.a(file);
        }

        @Override // d.a.c.a
        public void a(File file, File file2) throws IOException {
            d(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        @Override // d.a.c.a
        public s b(File file) throws FileNotFoundException {
            try {
                return n.b(file);
            } catch (FileNotFoundException e2) {
                file.getParentFile().mkdirs();
                return n.b(file);
            }
        }

        @Override // d.a.c.a
        public s c(File file) throws FileNotFoundException {
            try {
                return n.c(file);
            } catch (FileNotFoundException e2) {
                file.getParentFile().mkdirs();
                return n.c(file);
            }
        }

        @Override // d.a.c.a
        public void d(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + file);
            }
        }

        @Override // d.a.c.a
        public boolean e(File file) {
            return file.exists();
        }

        @Override // d.a.c.a
        public long f(File file) {
            return file.length();
        }

        @Override // d.a.c.a
        public void g(File file) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("not a readable directory: " + file);
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    g(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete " + file2);
                }
            }
        }
    };

    t a(File file) throws FileNotFoundException;

    void a(File file, File file2) throws IOException;

    s b(File file) throws FileNotFoundException;

    s c(File file) throws FileNotFoundException;

    void d(File file) throws IOException;

    boolean e(File file);

    long f(File file);

    void g(File file) throws IOException;
}
