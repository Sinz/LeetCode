'''
Category	Difficulty	Likes	Dislikes
algorithms	Medium (31.73%)	2630	-
Tags
string | dynamic-programming

Companies
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

'''

def longestPalindrome(s) -> str:
    n = len(s)

    def getLen(l, r):
        while l >= 0 and r < n and s[l] == s[r]:
            l -= 1
            r += 1
        return r - l - 1

    start  = 0
    lenth = 0
    for i in range(n):
        cur = max(getLen(i,i),getLen(i,i+1))

        if cur <= lenth:
                continue
        lenth = cur
        start = i-(cur-1) // 2
    
    return s[start : start + lenth]

if __name__ == '__main__':
    s = 'dasgrdfgfdtrgwf'
    lenth = longestPalindrome(s)
    print (lenth)