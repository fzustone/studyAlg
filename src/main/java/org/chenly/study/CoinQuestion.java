package org.chenly.study;

/**
 * 凑零钱问题
 * https://leetcode-cn.com/problems/coin-change/
 *
 * @author chenly
 * @create 2020-10-28 23:26
 */
public class CoinQuestion {

	public static void main(String[] args) {

		int[] coins = new int[] { 3, 5 };
		System.out.println(coinChange(coins, 14));
	}


	//解法一 普通递归 超时
	public static int coinChange(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int coin : coins) {
			//如果存在余额不足以用零钱凑，否决该方案
			if (amount - coin < 0) {
				continue;
			}
			//计算剩下的零钱每一种硬币凑出来的次数
			int tmp = coinChange(coins, amount - coin);
			//排除掉凑不出来的场景
			if (tmp == -1) {
				continue;
			}
			//取得凑出来的最少次数
			min = Math.min(tmp + 1, min);
		}
		//如果是初始值那么一定是凑不出来，返回-1
		return min == Integer.MAX_VALUE ? -1 : min;

	}
	//解法二 剪枝递归 ac
	/*public static int[] table = null;

	public static int coinChange(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}
		//初始化数组
		if (table == null) {
			table = new int[amount + 1];
			for (int i = 0; i < amount + 1; i++) {
				table[i] = Integer.MAX_VALUE;
			}
		}
		if (table[amount] != Integer.MAX_VALUE) {
			return table[amount];
		}
		int min = Integer.MAX_VALUE;
		for (int coin : coins) {
			//如果存在余额不足以用零钱凑，否决该方案
			if (amount - coin < 0) {
				continue;
			}
			//计算剩下的零钱每一种硬币凑出来的次数
			int tmp = coinChange(coins, amount - coin);
			//排除掉凑不出来的场景
			if (tmp == -1) {
				continue;
			}
			//取得凑出来的最少次数
			min = Math.min(tmp + 1, min);
		}
		//如果是初始值那么一定是凑不出来，返回-1
		int minLoop = min == Integer.MAX_VALUE ? -1 : min;
		table[amount] = minLoop;
		return minLoop;

	}*/

	//解法三 动态规划 自上而下 ac
	/**
	 * 动态规划
	 * 这里的解法是采用扣除法，当然你也可以采用累加法
	 */
	/*private static int coinChange(int[] coins, int amount) {
		//定义存储在不同金额时候的最小凑整次数
		int[] table = new int[amount + 1];
		//记住，table[amount] 不要赋值，
		//表示在不做硬币扣除，需要的硬币个数为0
		for (int i = 0; i < amount; i++) {
			table[i] = Integer.MAX_VALUE;
		}
		for (int i = amount; i > 0; i--) {
			for (int coin : coins) {
				//当该值还没被求出时，跳过
				if (table[i] == Integer.MAX_VALUE) {
					continue;
				}
				//不能被凑整的场景也需要跳过
				if (i - coin < 0) {
					continue;
				}
				//比较出是否还有没有比当前存储在数组中的值还要小的计算次数
				table[i - coin] = Math.min(table[i] + 1, table[i - coin]);
			}
		}
		//table[0]没有被赋值说明这个金额无法被凑整
		return table[0] == Integer.MAX_VALUE ? -1 : table[0];
	}*/

	//解法三 动态规划 自下而上 ac
	/*private static int coinChange(int[] coins, int amount) {
		//定义存储在不同金额时候的最小凑整次数
		int[] table = new int[amount + 1];
		//记住，table[0] 不要赋值，
		//表示金额为0 时需要的硬币为0个
		for (int i = 1; i <= amount; i++) {
			table[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < amount; i++) {
			for (int coin : coins) {
				//当该值还没被求出时，跳过
				if (table[i] == Integer.MAX_VALUE) {
					continue;
				}
				//不能被凑整的场景也需要跳过
				//不能使用i+coin>amount,在测试用例中有存在coin值为int最大值的场景，为了不溢出，用减法
				if (i > amount - coin) {
					continue;
				}
				//比较出是否还有没有比当前存储在数组中的值还要小的计算次数
				table[i + coin] = Math.min(table[i] + 1, table[i + coin]);
			}
		}

		//table[amount]没有被赋值说明这个金额无法被凑整
		return table[amount] == Integer.MAX_VALUE ? -1 : table[amount];
	}*/
}
