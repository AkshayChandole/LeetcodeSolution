package BinarySearch.KokoEatingBananas;

// ************************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(numberOfPiles * log(maximumBananasInPile))
 * Space Complexity - O(1)
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maximumBananasInPile = getMaximumBananasInPile(piles);

        int start = 1;
        int end = maximumBananasInPile;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int requiredTime = calculatedTimeRequiredToEatBananas(piles, mid);
            if (requiredTime <= h) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private int calculatedTimeRequiredToEatBananas(int[] piles, int eatingSpeed) {
        int totalHoursRequired = 0;
        int numberOfPiles = piles.length;

        for (int i = 0; i < numberOfPiles; i++) {
            totalHoursRequired += Math.ceil((double) piles[i] / (double) eatingSpeed);
        }

        return totalHoursRequired;
    }

    private int getMaximumBananasInPile(int[] piles) {
        int maximum = Integer.MIN_VALUE;

        for (int bananas : piles) {
            if (bananas > maximum) {
                maximum = bananas;
            }
        }

        return maximum;
    }
}

// ************************************************************************
// Brute Force Solution -

/**
 * Time Complexity - O(maximumBananasInPile * numberOfPiles)
 * Space Complexity - O(1)
 */
class Solution1 {
    public int minEatingSpeed(int[] piles, int h) {
        int maximumBananasInPile = getMaximumBananasInPile(piles);

        for (int eatingSpeed = 1; eatingSpeed <= maximumBananasInPile; eatingSpeed++) {
            int requiredTime = calculatedTimeRequiredToEatBananas(piles, eatingSpeed);
            if (requiredTime <= h) {
                return eatingSpeed;
            }
        }

        return 0;
    }

    private int calculatedTimeRequiredToEatBananas(int[] piles, int eatingSpeed) {
        int totalHoursRequired = 0;
        int numberOfPiles = piles.length;

        for (int i = 0; i < numberOfPiles; i++) {
            totalHoursRequired += Math.ceil((double) piles[i] / (double) eatingSpeed);
        }

        return totalHoursRequired;
    }

    private int getMaximumBananasInPile(int[] piles) {
        int maximum = Integer.MIN_VALUE;

        for (int bananas : piles) {
            if (bananas > maximum) {
                maximum = bananas;
            }
        }

        return maximum;
    }
}
