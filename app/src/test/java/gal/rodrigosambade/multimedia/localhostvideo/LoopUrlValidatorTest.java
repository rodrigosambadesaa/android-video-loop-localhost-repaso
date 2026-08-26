package gal.rodrigosambade.multimedia.localhostvideo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class LoopUrlValidatorTest {
    @Test public void acceptsEmulatorHost() {
        assertTrue(LoopUrlValidator.isEmulatorHostUrl("http://10.0.2.2:8000/video.mp4"));
    }

    @Test public void rejectsOtherHost() {
        assertFalse(LoopUrlValidator.isEmulatorHostUrl("http://127.0.0.1/video.mp4"));
    }
}
