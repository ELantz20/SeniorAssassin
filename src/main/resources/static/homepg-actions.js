
// When the user clicks on <div>, open the popup
function myFunction() {
  var popup = document.getElementById("myPopup");
  popup.classList.toggle("show");
}

}

var students= ["Emily", "Carmen", "Elena", "Matilda", "Sasha", "Elise", "Sophia", "Madeline", "Ella"];

function chooseName(){
    var nameNum= Math.floor(Math.random() * 9);
    var name= students[nameNum];
    name = document.getElementByClassName("popuptext");


}