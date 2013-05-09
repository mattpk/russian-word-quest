package russianwordquest;

import java.util.ArrayList;

/**
 *
 * @author jonathan2
 */
public class Instances {

    public static Player player = new Player();
    private static ArrayList<AbstractEntity> entities = new ArrayList<AbstractEntity>();

    /**
     * @return the entities
     */
    public static ArrayList<AbstractEntity> getEntities() {
        return entities;
    }
}