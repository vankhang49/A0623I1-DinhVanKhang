function Hero(image, top, left, size, speed){
    this.image = image;
    this.top = top;
    this.left = left;
    this.size = size;
    this.speed = speed;

    this.getHeroElement = function(){
        return '<img width="'+ this.size + '"' +
            ' height="'+ this.size + '"' +
            ' src="' + this.image +'"' +
            ' style="top: '+this.top+'px; left:'+this.left+'px;position:absolute;" />';
    }

    this.moveRight = function(){
            this.left += 20 + this.speed;
            console.log('ok: ' + this.left);
    }
    this.moveDown = function (){
        this.top += 20 + this.speed;
    }
    this.moveLeft = function () {
        this.left -= 20 + this.speed;
    }
    this.moveUp = function (){
        this.top -= 20 + this.speed;
    }
}

let hero = new Hero('charizard.png', 20, 30, 200, 40);

function start(){
    if(hero.top === 20){
        hero.moveRight();
    } else if (hero.left <= 30) {
        hero.moveUp();
    }
    console.log(hero.left, hero.top, window.innerWidth, window.innerHeight - hero.top)
    if (window.innerHeight - hero.top >= hero.size + 20) {
        if(hero.left + hero.size >= window.innerWidth) {
            hero.moveDown();
        }
    } else if (hero.left > 30) {
        hero.moveLeft()
    }

    document.getElementById('game').innerHTML = hero.getHeroElement();
    setTimeout(start, 500)
}

start();