function calculateWalkTime(steps, footLength, speed) {
    let distanceToUniversity = steps * footLength;
    let breakMinutes = parseInt(distanceToUniversity / 500);
    let distanceInKilometers = distanceToUniversity / 1000;
    let hoursToWalk = distanceInKilometers / speed;
    let secondsToWalk = hoursToWalk * 60 * 60 + breakMinutes * 60;
    let hours = Math.floor(secondsToWalk / 3600);
    secondsToWalk %= 3600;
    let minutes = parseInt(secondsToWalk / 60);
    let seconds = Math.ceil(secondsToWalk % 60);
    console.log((hours < 10 ? "0" : "") + hours + ":" + (minutes < 10 ? "0" : "") + (minutes) + ":" + (seconds < 10 ? "0" : "") + seconds);
}
calculateWalkTime(4000, 0.60, 5);
calculateWalkTime(2564, 0.70, 5.5);