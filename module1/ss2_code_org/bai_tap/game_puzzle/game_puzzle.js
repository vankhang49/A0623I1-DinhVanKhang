let image1 = ["./images/cat1.jpg", "./images/monkey1.jpg", "./images/panda1.jpg"];
let image2 = ["./images/cat2.jpg", "./images/monkey2.jpg", "./images/panda2.jpg"];
let image3 = ["./images/cat3.jpg", "./images/monkey3.jpg", "./images/panda3.jpg"];
let image4 = ["./images/cat4.jpg", "./images/monkey4.jpg", "./images/panda4.jpg"];
let image5 = ["./images/cat5.jpg", "./images/monkey5.jpg", "./images/panda5.jpg"];

let num = 0;

function changeImage1() {
    let slider1 = document.getElementById("image1");
    num++;
    if(num >= image1.length) {
        num = 0;
    }
    slider1.src = image1[num];
}

function changeImage2() {
    let slider2 = document.getElementById("image2");
    num++;
    if(num >= image2.length) {
        num = 0;
    }
    slider2.src = image2[num];
}
function changeImage3() {
    let slider3 = document.getElementById("image3");
    num++;
    if(num >= image3.length) {
        num = 0;
    }
    slider3.src = image3[num];
}
function changeImage4() {
    let slider4 = document.getElementById("image4");
    num++;
    if(num >= image4.length) {
        num = 0;
    }
    slider4.src = image4[num];
}
function changeImage5() {
    let slider5 = document.getElementById("image5");
    num++;
    if(num >= image5.length) {
        num = 0;
    }
    slider5.src = image5[num];
}