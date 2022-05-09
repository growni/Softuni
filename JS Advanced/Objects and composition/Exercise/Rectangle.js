function Rectangle(width, height, color) {
    let rectangle = {
        width, height, color
    }
    let colorToUpper = rectangle.color.charAt(0).toUpperCase() + color.slice(1, color.length);
    rectangle.color = colorToUpper;
    rectangle.calcArea = () => {
        return rectangle.width * rectangle.height;
    }
    console.log(rectangle.width);
    console.log(rectangle.height);
    console.log(rectangle.color);
    console.log(rectangle.calcArea())
    
    return rectangle;
}

Rectangle(4, 5, 'red');