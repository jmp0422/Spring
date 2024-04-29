// PS H:\workspace\multi\01_web\05_add\a_basic> node .\01_functions.js        실행할때 node 명령어 한캄띄우고 해당 파일명 작성                           
// hello
// PS H:\workspace\multi\01_web\05_add\a_basic> cd ../                        상위 폴더로 올라감
// PS H:\workspace\multi\01_web\05_add> cd ../
// PS H:\workspace\multi\01_web> cd .\05_add\                                 해당폴더로 이동 시 파일명 쓰고 tab하면 자동생성
// PS H:\workspace\multi\01_web\05_add> cd ../ 
// PS H:\workspace\multi\01_web> cd .\05_add\a_basic\
// PS H:\workspace\multi\01_web\05_add\a_basic> 


/*
템플릿 리터럴
ES6부터 도입 된 멀티라인 문자열, 표현식 삽입 등의 편리한 문자열 처리 기능을 제공하는 문자열 표기법이다.
이 때는 작은 따옴표, 큰 따옴표 대신 백틱을 사용해 표현한다.
*/


const lastname = '홍';
const firstname = '길동';

// 표현식 삽입은 반드시 백틱 내에서 사용해야 한다.
// 일반 문자열에서의 표현식 삽입은 문자열로 취급된다.

console.log(`제 이름은 ${lastname}${firstname} 입니다.`)

//함수 선언문

function hello(name) {
    return `${name}님 안녕하세요 !`
}
//함수로그
console.log(hello('홍길동'))

//함수 식별자 구분 예제
//식별자 hello2

let hello2 = function hello1(name) {
    return `${name}님 안녕하세요 !`
}

console.log(hello2('홍길동2'))