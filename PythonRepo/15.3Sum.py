# 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
# 复的三元组。
#
#  注意：答案中不可以包含重复的三元组。
#
#
#
#  示例 1：
#
#
# 输入：nums = [-1,0,1,2,-1,-4]
# 输出：[[-1,-1,2],[-1,0,1]]
#
#
#  示例 2：
#
#
# 输入：nums = []
# 输出：[]
#
#
#  示例 3：
#
#
# 输入：nums = [0]
# 输出：[]
#
#
#
#
#  提示：
#
#
#  0 <= nums.length <= 3000
#  -105 <= nums[i] <= 105
#
#  Related Topics 数组 双指针
#  👍 2948 👎 0



def threeSum(nums):
    """
    :type nums: List[int]
    :rtype: List[List[int]]
    """
    n = len(nums)
    res = []
    if (not nums or n < 3):
        return []
    nums.sort()
    res = []
    for i in range(n):
        if (nums[i] > 0):
            return res
        if (i > 0 and nums[i] == nums[i - 1]):
            continue
        L = i + 1
        R = n - 1
        while (L < R):
            if (nums[i] + nums[L] + nums[R] == 0):
                res.append([nums[i], nums[L], nums[R]])
                while (L < R and nums[L] == nums[L + 1]):
                    L = L + 1
                while (L < R and nums[R] == nums[R - 1]):
                    R = R - 1
                L = L + 1
                R = R - 1
            elif (nums[i] + nums[L] + nums[R] > 0):
                R = R - 1
            else:
                L = L + 1
    return res

if __name__ == "__main__":
    nums = [1, -1, -1, 0]
    result = threeSum(nums)
    print(result)
