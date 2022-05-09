function solve() {
    let data = [];
    let size = 0;
    let myList = {
        data,
        size,
        add: (element) => {
            myList.data.push(element);
            myList.data.sort((a, b) => a - b);
            myList.size++;

        },
        remove: (index) => {
            if (index < 0 || index >= myList.size) {
                return;
            }
            myList.data.splice(index, 1);
            myList.data.sort((a, b) => a - b);
            myList.size--;
        },
        get: (index) => {
            if (index < 0 || index >= myList.size) {
                return;
            }
            return myList.data[index];
        }
    }
    
    return myList;
}
solve();