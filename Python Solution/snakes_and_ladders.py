t = int(raw_input().strip())
while t:
    n = int(raw_input().strip())
    jumps={}
    for i in range(n):
        s,e = map(int,raw_input().strip().split())
        jumps[s]=e
    m = int(raw_input().strip())
    for i in range(m):
        s,e = map(int,raw_input().strip().split())
        jumps[s]=e

    final_pos = 100
    positions = {1} #initial position off the board
    nsteps = 0
    i=0
    x = 10000
    while final_pos not in positions and i < x:
        nsteps += 1
        old_positions = positions
        positions = set()
        for pos in old_positions:
            for dice in range(1, 7):
                new_pos = pos + dice
                positions.add(jumps.get(new_pos, new_pos))
        i+=1

    if i == x:
        print -1
    else:
        print nsteps

    t-=1