package idsa.progetto_idsa;

import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Test;

import idsa.progetto_idsa.entity.Slot;

public class SlotTest {
    @Test
    public void testEqualsSameObject() {        
        Slot s = new Slot(1L, Date.valueOf("2021-01-01"), false);
        assertTrue(s.equals(s));
    }

    @Test
    public void testGetDataOraSlot() {
        Slot s = new Slot(1L, Date.valueOf("2021-01-01"), false);
        assertTrue(s.getDataOraSlot().equals(Date.valueOf("2021-01-01")));
    }

    @Test
    public void testSetDataOraSlot() {
        Slot s = new Slot();
        s.setDataOraSlot(Date.valueOf("2021-01-01"));
        assertTrue(s.getDataOraSlot().equals(Date.valueOf("2021-01-01")));
    }

    @Test
    public void testGetOccupato() {
        Slot s = new Slot(1L, Date.valueOf("2021-01-01"), false);
        assertTrue(s.getOccupato().equals(false));
    }

    @Test
    public void testSetOccupato() {
        Slot s = new Slot();
        s.setOccupato(true);
        assertTrue(s.getOccupato().equals(true));
    }
}
