/**
 * 
 */

//This script should retrieve today's date and format in year-month-date and return a message

function addCurrentDate(){
var today = new Date();
var year = today.getFullYear();
var month = today.getMonth() +1;
var day = today.getDate();
var textDate = year +'/'+ month +'/'+ day;
var message = "Inventories completed Today will be marked as Current Inventory Date of " + textDate;
document.getElementById("currentdate").innerHTML = message;
}