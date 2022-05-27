function solve(worker) {
    if (worker.dizziness) {
        let ownedWater = 0.1 * worker.weight * worker.experience;
        worker.levelOfHydrated = ownedWater;
        worker.dizziness = false;
    }
    console.log(worker);
    return worker;
}

solve({
    weight: 80,
    experience: 1,
    levelOfHydrated: 0,
    dizziness: false
});