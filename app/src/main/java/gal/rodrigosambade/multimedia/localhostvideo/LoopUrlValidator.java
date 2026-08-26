package gal.rodrigosambade.multimedia.localhostvideo;

import java.net.URI;
import java.net.URISyntaxException;

final class LoopUrlValidator {
    private LoopUrlValidator() {}

    static boolean isEmulatorHostUrl(String value) {
        if (value == null) {
            return false;
        }

        try {
            URI uri = new URI(value);
            String scheme = uri.getScheme();
            return ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme))
                    && "10.0.2.2".equals(uri.getHost());
        } catch (URISyntaxException ignored) {
            return false;
        }
    }
}
