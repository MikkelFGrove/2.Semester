package vop;


import vop.bats.*;
import vop.exceptions.InvalidPopulationStatusException;

import java.util.List;
import java.util.Map;

public class BatStatistics {

    public static List<BatWithEnum> convert(List<Bat> bats) {
        throw new UnsupportedOperationException("Implement me");
    }

    public static Map<PopulationStatus, List<BatWithEnum>> getPopulationStatusMap(List<BatWithEnum> bats)
    {
        throw new UnsupportedOperationException("Implement me");
    }

    public static Map<FeedingGroups, List<BatWithEnum>> getFeedingGroupsMap(List<BatWithEnum> bats)
    {
        throw new UnsupportedOperationException("Implement me");
    }

    public static void main(String[] args) {

        try {
            List<Bat> bats = Bats.all();
            List<BatWithEnum> convertedBats = convert(bats);

            /*System.out.println("The following bats are carnivorous:");
            BatStatistics.getFeedingGroupsMap(convertedBats)
                    .get(FeedingGroups.Carnivore)
                    .forEach(x -> System.out.println(" - " + x.toString()));
            System.out.print("\n");
            System.out.println("The following bats are declining in population:");
            BatStatistics.getPopulationStatusMap(convertedBats)
                    .get(PopulationStatus.Decreasing)
                    .forEach(x -> System.out.println(" - " + x.toString()));*/

        } catch (InvalidPopulationStatusException e) {
            e.printStackTrace();
        }
    }

}
