package go.multithread.base.digester;

/**
 * 名称: School.java
 * 描述: TODO
 *
 * @author gaoshudian
 * @date 2019/12/9 11:59 AM
 */
public class School {

    private String name;
    private Grade grades[] = new Grade[0];
    private final Object servicesLock = new Object();

    public void addGrade(Grade g) {
        synchronized (servicesLock) {
            Grade results[] = new Grade[grades.length + 1];
            System.arraycopy(grades, 0, results, 0, grades.length);
            results[grades.length] = g;
            grades = results;
        }
    }

    public Grade[] getGrades() {
        return grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
