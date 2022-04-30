# Jobs, Profit, Slot
profit = [15,27,10,100]
jobs = ["j1", "j2", "j3", "j4"]
deadline = [2,1,1,2]
profitNJobs = list(zip(profit,jobs,deadline))
profitNJobs = sorted(profitNJobs, key = lambda x: x[0], reverse = True)
slot = []
for _ in range(len(jobs)):
    slot.append(0)

profit = 0

print(profitNJobs)
for i in range(len(jobs)):
        job = profitNJobs[i]
        #check if slot is occupied
        if slot[job[2]] == 0:
           profit += job[0]
           slot[job[2]] = 1
        else:
            continue
            
print(profit)
