const canvas_width = 500;
const canvas_height = 500;
const right = 'right';
const left = 'left';
const up = 'up';
const down = 'down';

const car_x = 230;
const car_y = 200;
const default_car_orientation = up;
const car_speed = 20;

function Car(){
    this.x = car_x;
    this.y = car_y;
    this.orientation = up;
    this.speed = car_speed;
    this.step = 1;

    this.buildImage = function (){
        this.image = this.orientation + this.step + '.png';
    };

    this.buildImage();

    this.move = function (){
        switch (this.orientation){
            case down:
                this.y += this.speed;
                break;
            case up:
                this.y -= this.speed;
                break;
            case left:
                this.x -= this.speed;
                break;
            case right:
                this.x += this.speed;
                break;
        }

        if(this.step === 2){
            this.step = 1;
        } else {
            this.step = 2;
        }
        this.buildImage();
    };

    this.turn = function (orientation){
        this.orientation = orientation;
        this.step = 1;
        this.buildImage();
    };

    this.show = function (ctx){
        let image = new Image();
        let x = this.x;
        let y = this.y;
        let width = 0;
        let height = 0;
        if(this.orientation === up || this.orientation === down){
            width = 40;
            height = 80;
        } else {
            width = 80;
            height = 40;
        }
        image.onload = function (){
                ctx.drawImage(image, x, y, width, height);
        };
        image.src = './images/'+ this.image;
        console.log(this.image);
    };

}

function GameBoard(){
    this.car = new Car();
    this.ctx = undefined;
    this.start = function (){
        this.ctx = document.getElementById('gameCanvas').getContext('2d');
        this.car.show(this.ctx);
    };

    this.render = function (){
        this.ctx.clearRect(0, 0, canvas_width, canvas_height);
        this.car.show(this.ctx);
    };

    this.moveCar = function (event){
        let orientation = 0;
        switch (event.which){
            case 37:
                orientation = left;
                break;
            case 38:
                orientation = up;
                break;
            case 39:
                orientation = right;
                break;
            case 40:
                orientation = down;
                break;
        }

        if(orientation){
            if(this.car.orientation !== orientation){
                this.car.orientation = orientation;
            } else {
                this.car.move();
            }
            this.render();

        }
    }
}
let gameBoard = new GameBoard();
gameBoard.start();