function solve(ticket) {

    let product = {
        model: ticket.model,
        engine: {},
        carriage: {},
        wheels: []
    }
    setEngine(product);
    setCarriage(product);
    setWheels(product);

    function setEngine(product) {
        if (ticket.power > 90 && ticket.power <= 120) {
            product.engine.power = 120
            product.engine.volume = 2400;
        } else if (ticket.power > 120 && ticket.power <= 200) {
            product.engine.power = 200;
            product.engine.volume = 3500;
        } else if(ticket.power <= 90) {
            product.engine.power = 90;
            product.engine.volume = 1800;
        }
    }
    function setCarriage(product) {
        product.carriage.type = ticket.carriage;
        product.carriage.color = ticket.color;
    }
    function setWheels(product) {
        let wheelsDiameter = ticket.wheelsize;
        if (ticket.wheelsize % 2 == 0) {
            wheelsDiameter = ticket.wheelsize - 1;
        }
        for (let i = 0; i < 4; i++) {
            product.wheels.push(wheelsDiameter);
        }
    }
    
    return product;
}

solve({
    model: 'Opel Vectra',
    power: 110,
    color: 'grey',
    carriage: 'coupe',
    wheelsize: 17
});