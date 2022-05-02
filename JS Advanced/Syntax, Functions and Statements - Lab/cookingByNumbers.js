function cooking(number, ...args) {
    let startingPoint = Number(number);
    for (let i = 0; i < args.length; i++) {
        switch (args[i]) {
            case 'chop':
                startingPoint /= 2;
                console.log(startingPoint);
                break;
            case 'dice':
                startingPoint = Math.sqrt(startingPoint);
                console.log(startingPoint);
                break;
            case 'spice':
                startingPoint += 1;
                console.log(startingPoint);
                break;
            case 'bake':
                startingPoint *= 3;
                console.log(startingPoint);
                break;
            case 'fillet':
                startingPoint *= 0.8;
                console.log(startingPoint.toFixed(1));
                break;
        }
        
    }
}
cooking('32', 'chop', 'chop', 'chop', 'chop', 'chop');
cooking('9', 'dice', 'spice', 'chop', 'bake', 'fillet');