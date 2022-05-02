function radar(speed, area) {
    let speedLimit = 0;
    switch (area) {
        case 'motorway':
            speedLimit = 130;
            break;
        case 'interstate':
            speedLimit = 90;
            break;
        case 'city':
            speedLimit = 50;
            break;
        case 'residential':
            speedLimit = 20;
            break;
    }
    let difference = speed - speedLimit;
    let message = '';
    let status = '';
    if(speed <= speedLimit) {
        console.log(`Driving ${speed} km/h in a ${speedLimit} zone`);
        return;
    } else {
       
        if(difference <= 20) {
            status = 'speeding';
        } else if(difference <= 40) {
            status = 'excessive speeding';
        } else {
            status = 'reckless driving';
        }
    }
    message = `The speed is ${difference} km/h faster than the allowed speed of ${speedLimit} - ${status}`
    console.log(message)
}
radar(40, 'city')
radar(21, 'residential')
radar(120, 'interstate')
radar(200, 'motorway')