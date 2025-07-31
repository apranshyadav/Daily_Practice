// Q2. fizz:multiple of 3
//     buzz : multiple of 5
//     fizzbuzz : multiple of 5 & 3


// WITH MODULUSSSSS
// const n = 16;
// for(let i = 1; i <= n; i++) {
//     if (i % 3 === 0 && i % 5 === 0) {
//         console.log("FizzBuzz");
//     }
//     if (i % 3 === 0) {
//         console.log("Fizz");
//     }
//     if (i % 5 === 0) {
//         console.log("Buzz");
//     }
//     else {
//         console.log(i);
//     }
// }


// WITHOUT MODULUSSSSSSS
let c3 = 1;
let c5 = 1;

for (let i=1; i<=16; i++){
    if(c3==3 && c5==5){
        console.log('FizzBuzz');
        c3 = 0;
        c5 = 0;
    }
    else if(c3===3){
        console.log('Fizz');
        c3 = 0;
    }

    else if(c5===5){
        console.log('Buzz')
        c5 = 0;
    }

    else{
        console.log(i);
    }
    c3++;
    c5++;
}