function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);

   function onClick () {
      let input = document.getElementById('inputs').getElementsByTagName('textarea');
      
      console.log(input[0]);
      
   }
}