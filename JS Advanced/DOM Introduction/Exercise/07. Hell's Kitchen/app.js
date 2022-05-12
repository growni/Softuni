function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);

   function findBestRestaurant(arr) {
      arr.sort((a, b) => { b.avgSalary - a.avgSalary });
      return arr[0];
   }

   function findBestSalary(workers) {
      let sorted = workers.sort(function (a, b) { return b.salary - a.salary });
      return sorted[0].salary;
   }

   function onClick() {
      let inputElement = document.getElementById('inputs').getElementsByTagName('textarea');

      let arr = JSON.parse(inputElement[0].value);
      let outputElements = document.getElementById('outputs').getElementsByTagName('p');
      outputElements[0].textContent = '';
      outputElements[1].textContent = '';
      let restaurant = {
         name: '',
         avgSalary: 0.0,
         workers: []
      }
      let restaurantsData = [];

      for (let i = 0; i < arr.length; i++) {
         let splittedData = arr[i].split(' - ');
         //TODO: Implement function for checking if the input contains restaurant with the same name and if so add the workers to the first restaurant and update its salary
         let totalSalary = 0;
         let sameNameRestaurant = restaurantsData.filter(r => (r.name == splittedData[0]))[0];
         if (sameNameRestaurant != undefined) {
            for (const worker of splittedData[1].split(', ')) {
               let eachWorker = { name: worker.split(' ')[0], salary: Number(worker.split(' ')[1]) };
               totalSalary += eachWorker.salary;
               sameNameRestaurant.workers.push(eachWorker);
            }
            sameNameRestaurant.avgSalary = Number(totalSalary / sameNameRestaurant.workers.length).toFixed(2);
         } else {

            const newObject = Object.create(restaurant);
            newObject.workers = [];
            newObject.name = splittedData[0];

            for (const worker of splittedData[1].split(', ')) {
               let singleWorker = { name: worker.split(' ')[0], salary: Number(worker.split(' ')[1]) };
               newObject.workers.push(singleWorker);
               totalSalary += Number(Number(worker.split(' ')[1]));
            }
            newObject.avgSalary = Number(totalSalary / newObject.workers.length).toFixed(2);
            restaurantsData[i] = newObject;

         }
      }
      let bestRestaurant = findBestRestaurant(restaurantsData);
      let mostPaidWorker = findBestSalary(bestRestaurant.workers);
      bestRestaurant.highestSalary = mostPaidWorker.toFixed(2);

      document.getElementById('bestRestaurant').getElementsByTagName('p')[0].textContent = `Name: ${bestRestaurant.name} Average Salary: ${bestRestaurant.avgSalary} Best Salary: ${bestRestaurant.highestSalary}`;
      for (const worker of bestRestaurant.workers) {
         document.getElementById('workers').getElementsByTagName('p')[0].textContent += `Name: ${worker.name} With Salary: ${worker.salary} `;
      }
   }
}