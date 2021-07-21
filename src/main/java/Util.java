import java.io.IOException;
import java.io.InputStream;

import org.jetbrains.annotations.Nullable;

public class Util {
    public static String processPath(String path) {
        String newPath = null;
        if (path.equals("/")) {
            newPath = "/index.html";
        } else if (!path.endsWith(".html")) {
            newPath = path + ".html";
        }
        return newPath;
    }
    @Nullable
    public static String getResource(Class<?> clazz, String path) throws IOException {
        InputStream res = clazz.getClassLoader().getResourceAsStream(path);
        StringBuilder resDataBuilder = new StringBuilder();
        if (res == null) {
            return null;
        }
        while (res.available() > 0) {
            resDataBuilder.append((char)res.read());
        }
        return resDataBuilder.toString();
    }
}
