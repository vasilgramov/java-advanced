import java.util.*;

public class p14_dragonArmy {
    static final int DEFAULT_HEALTH = 250;
    static final int DEFAULT_DAMAGE = 45;
    static final int DEFAULT_ARMOR = 10;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        HashMap<String, Double> countByType = new HashMap<>();
        LinkedHashMap<String, TreeSet<Dragon>> dragonsByType = new LinkedHashMap<>();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commandArgs = in.nextLine().split("\\s+");
            String type = commandArgs[0];
            String name = commandArgs[1];
            String damageAsString = commandArgs[2];
            String healthAsString = commandArgs[3];
            String armorAsString = commandArgs[4];

            int damage = 0;
            int health = 0;
            int armor = 0;

            damage = damageAsString.equals("null") ? DEFAULT_DAMAGE : Integer.parseInt(damageAsString);
            health = healthAsString.equals("null") ? DEFAULT_HEALTH : Integer.parseInt(healthAsString);
            armor = armorAsString.equals("null") ? DEFAULT_ARMOR : Integer.parseInt(armorAsString);

            Dragon dragon = new Dragon(name, damage, health, armor);
            if (!dragonsByType.containsKey(type)) {
                dragonsByType.put(type, new TreeSet<>());
            }

            if (!countByType.containsKey(type)) {
                countByType.put(type, 0.0);
            }

            TreeSet<Dragon> currentTreeSet = dragonsByType.get(type);
            if (currentTreeSet.contains(dragon)) {
                currentTreeSet.remove(dragon);
                currentTreeSet.add(dragon);
            } else {
                currentTreeSet.add(dragon);
                countByType.put(type, countByType.get(type) + 1.0);
            }

            dragonsByType.put(type, currentTreeSet);
        }

        for (Map.Entry<String, TreeSet<Dragon>> stringTreeSetEntry : dragonsByType.entrySet()) {
            String type = stringTreeSetEntry.getKey();
            TreeSet<Dragon> dragons = stringTreeSetEntry.getValue();
            double count = countByType.get(type);

            double avgDmg = 0.0;
            double avgHealth = 0.0;
            double avgArmor = 0.0;

            for (Dragon currentDragon : dragons) {
                avgDmg += currentDragon.getDamage();
                avgHealth += currentDragon.getHealth();
                avgArmor += currentDragon.getArmor();
            }

            avgDmg /= dragons.size();
            avgHealth /= dragons.size();
            avgArmor /= dragons.size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", type, avgDmg, avgHealth, avgArmor);
            for (Dragon currentDragon : dragons) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", currentDragon.getName(), currentDragon.getDamage(), currentDragon.getHealth(), currentDragon.getArmor());
            }
        }
    }

    static class Dragon implements Comparable<Dragon> {
        private String name;
        private int damage;
        private int health;
        private int armor;

        public Dragon(String name, int damage, int health, int armor) {
            this.setName(name);
            this.setDamage(damage);
            this.setHealth(health);
            this.setArmor(armor);
        }

        public String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        public int getDamage() {
            return damage;
        }

        private void setDamage(int damage) {
            this.damage = damage;
        }

        public int getHealth() {
            return health;
        }

        private void setHealth(int health) {
            this.health = health;
        }

        public int getArmor() {
            return armor;
        }

        private void setArmor(int armor) {
            this.armor = armor;
        }

        @Override
        public int compareTo(Dragon dragon) {
            return this.getName().compareTo(dragon.getName());
        }
    }
}
