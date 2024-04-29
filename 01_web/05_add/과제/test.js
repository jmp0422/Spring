function Calculator() {
    this.a = 10;
    this.b = 20;
    // 코드 작성
    this.result = 0;
}
    Calculator.prototype.sum = function(){
        this.result = this.a + this.b
    }
    Calculator.prototype.sub = function(){
        this.result = this.a - this.b
    }
    Calculator.prototype.mul = function(){
        this.result = this.a * this.b
    }
    Calculator.prototype.div = function(){
        this.result = this.a / this.b
    }
    
var calc = new Calculator();
calc.sum()
console.log(calc.result)
calc.sub()
console.log(calc.result)
calc.mul()
console.log(calc.result)
calc.div()
console.log(calc.result)