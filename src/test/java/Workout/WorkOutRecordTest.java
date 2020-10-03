package Workout;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkOutRecordTest {

    @Test
    void testToString() {
        WorkOutRecord wr = new WorkOutRecord(BodyPart.LEG, "haha");
        assertEquals("haha", wr.toString());
    }
}