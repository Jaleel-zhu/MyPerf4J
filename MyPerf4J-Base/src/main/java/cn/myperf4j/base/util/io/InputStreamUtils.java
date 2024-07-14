package cn.myperf4j.base.util.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by LinShunkang on 2020/05/16
 */
public final class InputStreamUtils {

    private static final ThreadLocal<ByteArrayOutputStream> OP_TL =
            ThreadLocal.withInitial(() -> new ByteArrayOutputStream(4096));

    private static final ThreadLocal<byte[]> BYTES_TL = ThreadLocal.withInitial(() -> new byte[1024]);

    private InputStreamUtils() {
        //empty
    }

    public static String toString(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }

        final ByteArrayOutputStream result = OP_TL.get();
        final byte[] buffer = BYTES_TL.get();
        try {
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            return result.toString("UTF-8");
        } finally {
            result.reset();
        }
    }

    public static byte[] toBytes(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }

        final ByteArrayOutputStream result = OP_TL.get();
        final byte[] buffer = BYTES_TL.get();
        try {
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            return result.toByteArray();
        } finally {
            result.reset();
        }
    }
}
