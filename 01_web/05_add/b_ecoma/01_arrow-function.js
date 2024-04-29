/* 01_arrow-funciton-basic-syntax
ES6에서 도입 된 화살표 함수는 function 키워드 대신 화살표를 사용해 좀 더 간략한 방법으로 함수를 선언할 수 있다. 
화살표 함수는 항상 익명 함수로 정의한다. 본문이 한 줄인 함수를 작성할 때 유용하다.

// 1. 매개변수 지정 방법
    () => { ... }       // 매개변수가 없을 경우
    x => { ... }        // 매개변수가 한 개인 경우, 소괄호를 생략할 수 있다.
    (x, y) => { ... }   // 매개변수가 여러 개인 경우, 소괄호를 생략할 수 없다.

// 2.함수 지정 방법
    x => { return x * x }   
    x => x * x              // 한줄이면  중괄호를 생략할 수 있고  암묵적으로 return

    () => { return { a: 1 }; }
    () => ({ a: 1 })        // 객체 반환시 소괄호를 사용한다.

    () => {                 //멀티라인이면 중괄호를 생략할 수 없다
    const x = 5;
    return x * x;
    };

*/

let message;
message = function(){
    return "hello world"
}
console.log(message())


message = () => {
     return "Arrow Function" //이 코드처럼 한줄인경우에는
    }

message = () => "Arrow Function" //{}와 return을 생략할수있다
 
 console.log(message())

 message = val => "Arrow Function simple" + val //매개변수 하나라 ()생략 + 한줄이라 {},return 생략
 console.log(message(" 매개변수 하나"))

 // 매개변수가 2개이상 있을 경우
message = (val1, val2) => "Arrow " + val1 + val2;
console.log(message("Function ","하나"))

const createUser = (id,name) => ({id,name})
console.log(createUser(1, '유관순'))

console.log([1,2,3,4,5].map(function(val){return val * 10}))
console.log([1,2,3,4,5].map( val => val * 10))