"""
    必须按广度优先的顺序添加才能得到正确结果
"""
# 邻居节点(子节点)及权重
point_all = {
    "start": {"p2": 10, "p4": 30, "p5": 100},
    "p2": {"p3": 50},
    "p4": {"p3": 20,  "p5": 60},
    "p5": None,
    "p3": {"p5": 10},
}
distance_max = float("inf")
# 最短距离
costs = {
    "start": 0,
    "p2": distance_max,
    "p3": distance_max,
    "p4": distance_max,
    "p5": distance_max
}


def find_lowest_cost(point_list):
    for d in point_list:
        if point_all[d]:
            for s in point_all[d]:
                print("子节点c_d:", s, "子节点最短距离：", costs[s], "cost:", point_all[d][s], "当前节点d:", d)
                if point_all[d][s] + costs[d] < costs[s]:
                    costs[s] = point_all[d][s] + costs[d]
                    print(costs)
                    print("=============================================")
    return costs


if __name__ == '__main__':
    print("point: ", point_all.keys())
    find_lowest_cost(point_all.keys())
    print("fast costs: ", costs)
