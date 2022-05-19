function generateReport() {
    let checkedBoxes = document.querySelectorAll('input[type="checkbox"]:checked');
    let object = {};
    //Iterate over only the checked check boxes and set up objects properties
    for (const checkbox of checkedBoxes) {
        switch (checkbox.name) {
            case 'employee':
                object.employee = '';
                break;
            case 'department':
                object.department = '';
                break;
            case 'status':
                object.status = '';
                break;
            case 'dateHired':
                object.dateHired = '';
                break;
            case 'benefits':
                object.benefits = '';
                break;
            case 'compensation':
                object.compensation = 0;
                break;
            case 'rating':
                object.rating = 0;
                break;
        }
    }
    let objectProperties = Object.getOwnPropertyNames(object);
    for (const property of objectProperties) {
        object[property] = ''
    }

    let rows = document.getElementsByTagName('tr');
    console.log(rows.length);
}