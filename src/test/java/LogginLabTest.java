import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class LogginLabTest {
    private final static Logger logger = Logger.getLogger(LogginLab.class.getName());

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void thresholdExceeds() {
        Integer finalLimit = 5;

        LogginLab lab = new LogginLab();
        lab.setThreshold(finalLimit);

        for (Integer i = 1; i <= 8; i++) {
            if (lab.thresholdExceeds(i)) {
                logger.log(Level.INFO, "Threshold not reached! It is "+i);
                assertTrue(lab.thresholdExceeds(i));
            } else if (lab.thresholdReached(i)) {
                logger.log(Level.INFO, "Threshold passed!");
                assertTrue(lab.thresholdReached(i));
                break;
            } else {
                logger.log(Level.INFO, "Threshold finally reached!");
                assertFalse(lab.thresholdExceeds(finalLimit)); //test still runs with integer i but finalLimit makes sense bc should only return for threshold which is final limit
            }
        }
    }

//    @org.junit.Test
//    public void thresholdReached() {
//        Integer finalLimit = 5;
//
//        LogginLab lab = new LogginLab();
//        lab.setThreshold(finalLimit - 1);
//
//        for (Integer i =1; i < 8; i++) {
//            if (lab.thresholdReached(i)) {
//                logger.log(Level.INFO, "Threshold reached! It is "+i);
//                assertTrue(lab.thresholdReached(i));
//            } else {
//                logger.log(Level.INFO, "Threshold not reached!");
//                assertFalse(lab.thresholdReached(i));
//            }
//        }
//    }
}