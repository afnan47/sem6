def print_board(elements):
    for i in range(9):
        if i%3 == 0:
            print()
        if elements[i]==-1:
            print("_", end = " ")
        else:
            print(elements[i], end = " ")

def solvable(start):
    for i in range(9):
        if start[i] < 1:
            continue
        for j in range(i+1,9):
            if start[j]==-1:
                continue
            else:
                inv+=1
    if inv%2==1:
        return True
    else:
        return False

def heuristic(start,goal):
    h = 0
    for i in range(9):
        for j in range(9):
            if start[i] == goal[j] and start[i] != -1:
                h += abs((j-i)/3) + abs((j-1)%3)

    return  h + g

def movetile(start,goal):
    emptyat= start.index(-1)
    row = emptyat/3
    col = emptyat%3

    if col -1 >=0:
        


def solveEight(start,goal):
    g+=1

    moveTile(start,goal):
    print_board(start)
    f = heuristic(start,goal)
    if f== g:
        print("Solved in {} moves".format(f))
        return

    solveEight(start,goal)



def main():
    start = list()
    goal = list()

    global steps_count = 0
    print("Enter the start state:(Enter -1 for empty):")
    for i in range(9):
        start.append(int(input()))

    # print("Enter the goal state:(Enter -1 for empty):")
    # for i in range(9):
    #    goal.append(int(input()))

    print_board(start)

    # To check if solvable
    if solvable(start) == True:
        solveEight(start,goal)
        print("Solvable")
    else:
        print("Not possible to solve")

g=0
if __name__ == '__main__':
    main()



# Test Cases
# 1 2 3 -1 4 6 7 5 8 ( Give each integer input in new line)
# 1 2 3 4 5 6 7 8 -1
