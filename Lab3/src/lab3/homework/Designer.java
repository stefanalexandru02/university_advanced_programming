package lab3.homework;

import java.util.Date;

/**
 * @author Virna Stefan Alexandru
 */
public class Designer extends Person {
    /**
     * Link to a designer's Dribble account
     */
    private String DribbleAccountLink;

    public Designer(String name, Date date) {
        super(name, date);
    }

    public String getDribbleAccountLink() {
        return DribbleAccountLink;
    }

    public void setDribbleAccountLink(String dribbleAccountLink) {
        DribbleAccountLink = dribbleAccountLink;
    }

    @Override
    public String GetType() {
        return "Designer";
    }
}
