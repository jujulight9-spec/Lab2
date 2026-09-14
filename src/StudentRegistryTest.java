import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentRegistryTest {

    @Test
    public void testAddStudent() {
        StudentRegistry registry = new StudentRegistry();
        registry.addStudent(new Student("V100001", "Amina", 86.5));
        assertEquals("V100001", registry.findStudent("V100001").getId());
    }

    @Test
    public void testFindExistingStudent() {
        StudentRegistry registry = new StudentRegistry();
        registry.addStudent(new Student("V100001", "Amina", 86.5));
        Student found = registry.findStudent("V100001");
        assertNotNull(found);
    }

    @Test
    public void testFindMissingStudent() {
        StudentRegistry registry = new StudentRegistry();
        registry.addStudent(new Student("V100001", "Amina", 86.5));
        Student found = registry.findStudent("V999999");
        assertNull(found);
    }

    @Test
    public void testRemoveExistingStudent() {
        StudentRegistry registry = new StudentRegistry();
        registry.addStudent(new Student("V100001", "Amina", 86.5));
        boolean removed = registry.removeStudent("V100001");
        assertTrue(removed);
    }

    @Test
    public void testRemoveMissingStudent() {
        StudentRegistry registry = new StudentRegistry();
        registry.addStudent(new Student("V100001", "Amina", 86.5));
        boolean removed = registry.removeStudent("V999999");
        assertFalse(removed);
    }

    @Test
    public void testCalculateAverage() {
        StudentRegistry registry = new StudentRegistry();
        registry.addStudent(new Student("V100001", "Amina", 80.0));
        registry.addStudent(new Student("V100002", "Daniel", 90.0));
        assertEquals(85.0, registry.calculateAverage());
    }

    @Test
    public void testFindHighestAverage() {
        StudentRegistry registry = new StudentRegistry();
        registry.addStudent(new Student("V100001", "Amina", 80.0));
        registry.addStudent(new Student("V100002", "Daniel", 95.0));
        Student highest = registry.findHighestAverage();
        assertEquals("V100002", highest.getId());
    }

    @Test
    public void testEmptyRegistryFindStudent() {
        StudentRegistry registry = new StudentRegistry();
        Student found = registry.findStudent("V100001");
        assertNull(found);
    }

    @Test
    public void testInvalidAverageIgnored() {
        Student student = new Student("V100001", "Amina", 80.0);
        student.setAverage(-5);
        assertEquals(80.0, student.getAverage());
    }

    @Test
    public void testInvalidAverageBoundary() {
        Student student = new Student("V100001", "Amina", 80.0);
        student.setAverage(100.0);
        assertEquals(100.0, student.getAverage());
    }

}