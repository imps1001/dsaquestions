class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int total = Integer.MAX_VALUE;
        int minutes = targetSeconds / 60, seconds = targetSeconds % 60;
        if (minutes < 100) {
            int digit1 = minutes / 10, digit2 = minutes % 10, digit3 = seconds / 10, digit4 = seconds % 10;
            int total1 = getCost(startAt, moveCost, pushCost, new int[]{digit1, digit2, digit3, digit4});
            total = Math.min(total, total1);
        }
        if (minutes > 0 && seconds < 40) {
            int minutes2 = minutes - 1, seconds2 = seconds + 60;
            int digit5 = minutes2 / 10, digit6 = minutes2 % 10, digit7 = seconds2 / 10, digit8 = seconds2 % 10;
            int total2 = getCost(startAt, moveCost, pushCost, new int[]{digit5, digit6, digit7, digit8});
            total = Math.min(total, total2);
        }
        return total;
    }

    public int getCost(int startAt, int moveCost, int pushCost, int[] digits) {
        int total = 0;
        int prev = startAt;
        boolean push = false;
        for (int i = 0; i < 4; i++) {
            int digit = digits[i];
            if (!push) {
                if (digit != 0) {
                    if (digit != prev)
                        total += moveCost;
                    total += pushCost;
                    push = true;
                    prev = digit;
                }
            } 
            else {
                if (digit != prev)
                    total += moveCost;
                total += pushCost;
                prev = digit;
            }
        }
        return total;
    }
}
