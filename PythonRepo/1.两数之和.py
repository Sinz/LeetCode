#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict = {}
        for i,num in enumerate(nums):
            if dict.get(target - num) is not None:
                return [dict.get(target - num),i]
            dict[num] = i

# @lc code=end
