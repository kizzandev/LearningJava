package kv.miniPrograms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    @DisplayName("Stacking Numbers")
    void stack_stackingNumbers() {
        Stack<Integer> iStack = new Stack<>();
        assertTrue(iStack.isEmpty());

        iStack.push(1);
        iStack.push(2);
        iStack.push(3);
        assertEquals(3, iStack.size());
        assertFalse(iStack.isEmpty());

        assertEquals(3, iStack.peek());

        assertEquals(3, iStack.pop());
        assertEquals(2, iStack.pop());

        assertEquals(1, iStack.peek());
        assertEquals(1, iStack.size());

        iStack.pop();
        assertEquals(0, iStack.size());
        assertTrue(iStack.isEmpty());

        assertNull(iStack.pop());
        assertNull(iStack.peek());
    }

    @Test
    @DisplayName("Let me be clear")
    void stack_clearlyIDidNotForget() {
        Stack<String> sStack = new Stack<>();

        for (int i = 0; i < 15; i++) {
            sStack.push("YUP");
        }

        assertEquals(
                "[YUP, YUP, YUP, YUP, YUP, YUP, YUP, YUP, YUP, YUP, YUP, YUP, YUP, YUP, YUP]",
                sStack.toString());

        assertEquals(15, sStack.size());
        sStack.clear();
        assertEquals(0, sStack.size());
        assertTrue(sStack.isEmpty());
        assertEquals("[]", sStack.toString());
    }
}