// What is the Big O of the below function? (Hint, you may want to go line by line)


// function anotherFunChallenge(input) {
//     let a = 5; // O(1)
//     let b = 10; // O(1)
//     let c = 50; // O(1)
//     for (let i = 0; i < input; i++) { // O(n)
//         let x = i + 1; // O(n)
//         let y = i + 2; // O(n)
//         let z = i + 3; // O(n)
//
//     }
//     for (let j = 0; j < input; j++) { // O(n)
//         let p = j * 2; // O(n)
//         let q = j * 2; // O(n)
//     }
//     let whoAmI = "I don't know"; // O(1)
// }


// Big O = 4 + 7n = O(n)


// //#1 -- For loop in Javascript.
// const nemo = ['nemo'];
// const everyone = ['dory', 'bruce', 'marlin', 'nemo', 'gill', 'bloat', 'nigel', 'squirt', 'darla', 'hank'];
//
// function findNemo1(array) {
//     for (let i = 0; i < array.length; i++) {
//         console.log('running');
//         if (array[i] === 'nemo') {
//             console.log('Found NEMO!');
//             // return;
//             break;
//         }
//     }
// }
//
// findNemo1(everyone);
//

// function printFirstItemThenFirstHalfThenSayHi100Times(items) {
//     console.log(items[0]);
//
//     var middleIndex = Math.floor(items.length / 2);
//     var index = 0;
//
//     while (index < middleIndex) {
//         console.log(items[index]);
//         index++;
//     }
//
//     for (var i = 0; i < 100; i++) {
//         console.log('hi');
//     }
// }
//
//
// printFirstItemThenFirstHalfThenSayHi100Times();
//


//Log all pairs of array

// const boxes = ['a', 'b', 'c', 'd', 'e'];
// function logAllPairsOfArray(array) {
//     for (let i = 0; i < array.length; i++) {
//         for (let j = 0; j < array.length; j++) {
//             console.log(array[i], array[j])
//         }
//     }
// }
//
// logAllPairsOfArray(boxes)


// function printAllNumbersThenAllPairSums(numbers) {
//     console.log("these are the numbers:");
//     numbers.forEach(function(number) {
//         console.log(number);
//     });
//
//     console.log("and these are their sums:");
//     numbers.forEach(function(firstNumber) {
//         numbers.forEach(function(secondNumber) {
//             console.log(firstNumber + secondNumber);
//         });
//     });
// }
//
// // printAllNumbersThenAllPairSums([1, 2, 3, 4, 5]); // O(n^2)
//
// const num=[1,2,3,4,5];
//
// num.forEach((first)=>{num.forEach((second)=>console.log("sum : ",first + second))});
//


//#5 Space complexity O(1)
// function boooo(n) {
//     for (let i = 0; i < n; i++) {
//         console.log("booooo");
//     }
// }
//
// // #6 Space complexity O(n)
// function arrayOfHiNTimes(n) {
//     var hiArray = [];
//     for (let i = 0; i < n; i++) {
//         // hiArray[i] = "hi";
//         hiArray.push("hi")
//     }
//
//     return hiArray;
// }
//
// const num=arrayOfHiNTimes(6);
// console.log(num);


// const everyone = ['dory', 'bruce', 'marlin', 'nemo', 'gill', 'bloat', 'nigel', 'squirt', 'darla', 'hank'];
//
// const findNemo = (array) => {
//
//     array.forEach((data, index) => {
//         if (data === 'nemo') {
//             return console.log('this is nemo : ', index);
//         }
//     })
//
// }
// findNemo(everyone);
//
// console.log(everyone.find((data, index) => {
//     if (data === 'nemo') {
//         console.log(data, " at ", index);
//         return 0;
//     }
// }),0);
//
//
// const array1 = ['a','b','c','x'];
// const array2 = ['z','y','x'];
//
// function containsCommonItem(arr1,arr2){
//     for(let i=0;arr1.length;i++){
//
//         for(let j=0;j<arr2.length;j++){
//             if(arr1[i]==arr2[j]){
//                 return true;
//             }
//
//         }
//
//     }
//     return false;
// }
//
// const bool=containsCommonItem(array1,array2);
// console.log(bool);


// const array1 = ['a', 'b', 'c', 'x'];
// const array2 = ['z', 'y', 'x'];
//
//
// function containsCommonItem2(arr1, arr2) {
//
//     let map = {};
//     console.log("first : ", map);
//     for (let i = 0; i < arr1.length; i++) {
//         if (!map[array1[i]]) {
//             console.log(map[array1[i]]);
//             console.log("second : ", map)
//             const item = array1[i];
//             map[item] = true;
//             console.log("map[i] is ", map[array1[i]]);
//
//         }
//
//     }
//     console.log(map);
//
//     for (let j = 0; j < arr2.length; j++) {
//
//         if (map[array2[j]]) {
//
//             return true;
//         }
//     }
//     return false;
// }
//
//
// const bool = containsCommonItem2(array1, array2);
// console.log(bool);
//
// function containsCommonItem3(arr1,arr2){
//     return arr1.some(item => arr2.includes(item))
// }
//
// const bool2 = containsCommonItem3(array1,array2);
// console.log(bool2);


// const strings= ['a', 'b', 'c', 'd'];
// const numbers = [1,2,3,4,5];
// // Variable array is somewhere in memory and the computer knows it.
// // When I do array[2], i'm telling the computer, hey go to the array and grab the 3rd item from where the array is stored.
//
//
// //push
// strings.push('e');
//
// //pop
// strings.pop();
// strings.pop();
//
// //unshift
// strings.unshift('x')
//
// //splice
// strings.splice(2, 0, 'alien');
//
// console.log(strings)


// reference type

// context

//instantiation


// class MyArray {
//
//     constructor() {
//         this.length = 0;
//         this.data = {};
//     }
//
//     get(index) {
//         return this.data[index];
//     }
//
//     push(item) {
//         this.data[this.length] = item;
//         this.length++;
//
//         return this.length;
//     }
//
//     pop() {
//         const lastItem = this.data[this.length - 1];
//
//         delete this.data[this.length - 1];
//         this.length--;
//
//         return lastItem;
//     }
//
//     delete(index) {
//         const item = this.data[index];
//
//         this.shiftItems(index);
//
//         return item;
//     }
//
//     shiftItems(index) {
//         for (let i = index; i < this.length; i++) {
//             this.data[i] = this.data[i + 1];
//         }
//
//         delete this.data[this.length - 1];
//         this.length--;
//     }
// }
//
//
//
// const newArray = new MyArray();
//
// newArray.push("hi");
// newArray.push('you');
// newArray.push('!');
// // newArray.pop();
// // newArray.pop();
// newArray.delete(1);
// console.log(newArray);
//
//

// const str = "Hi My name is Andre";
// const ch = [];
// const ch2 = [];
//
// function reverse(str) {
//
//     for (let i = 0; i < str.length; i++) {
//
//         // ch[i] = str[i];
//         ch.push(str[i]);
//         console.log(str[i])
//
//     }
//
//     // ch.reverse();
//
//     for (let k = 0; k < str.length; k++) {
//
//     }
//
//
//     console.log(ch);
//     // let str2 = "";
//     // for (let j = 0; j < str.length; j++) {
//     //     str2 = str2 + ch[j];
//     // }
//
//     console.log(ch.join(''));
// }
//
//
// function reverse2(str){
//     return str.split('').reverse().join('');
// }
//
//
// reverse(str)
// const result2 = reverse2(str);
// console.log(result2);


const arr = [8,2,9,4,6,1,];
arr.sort((a,b)=>a-b);
console.log(arr);


function mergeSortedArray(array1, array2){
    const mergedArray = [];
    let array1Item = array1[0];
    let array2Item = array2[0];
    let i = 1;
    let j = 1;

    if (array1.length === 0){
        return array2;
    }

    if (array2.length === 0){
        return array1;
    }

    while(array1Item || array2Item){
        if (!array2Item || array1Item < array2Item){
            mergedArray.push(array1Item);
            array1Item = array1[i];
            i++;
        }else{
            mergedArray.push(array2Item);
            array2Item = array2[j];
            j++;
        }
    }

}


