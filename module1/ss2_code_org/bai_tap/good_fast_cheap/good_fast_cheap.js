let buttonAll = document.querySelectorAll("input");

buttonAll.forEach((btn, index) => {
    console.log(btn, index);
    btn.addEventListener("click", function () {
        if(btn.checked) {
            switch (index) {
                case 0:
                    if(buttonAll[1].checked && buttonAll[2].checked) {
                        buttonAll[2].checked = false;
                    }
                    break;
                case 1:
                    if(buttonAll[0].checked && buttonAll[2].checked) {
                        buttonAll[0].checked = false;
                    }
                    break;
                case 2:
                    if(buttonAll[0].checked && buttonAll[1].checked) {
                        buttonAll[1].checked = false;
                    }
                    break;
            }
        }
    });
});