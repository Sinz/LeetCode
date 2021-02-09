# 编写一个函数来查找字符串数组中的最长公共前缀。
#
#  如果不存在公共前缀，返回空字符串 ""。
#
#
#
#  示例 1：
#
#
# 输入：strs = ["flower","flow","flight"]
# 输出："fl"
#
#
#  示例 2：
#
#
# 输入：strs = ["dog","racecar","car"]
# 输出：""
# 解释：输入不存在公共前缀。
#
#
#
#  提示：
#
#
#  0 <= strs.length <= 200
#  0 <= strs[i].length <= 200
#  strs[i] 仅由小写英文字母组成
#
#  Related Topics 字符串
#  👍 1448 👎 0
class Solution(object):

    def longestCommonPrefix(strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if not strs: return ""
        str0 = min(strs)
        str1 = max(strs)
        for i in range(len(str0)):
            if str0[i] != str1[i]:
                return str0[:i]
        return str0

    result = longestCommonPrefix(["flower", "flow", "flight"])
    print(result)
    l = ["a18", "c5", "b21"]
    print(max(l))
