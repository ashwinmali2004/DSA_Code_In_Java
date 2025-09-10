# Maths For DSA

## Number System
### Any number of Base N means that it has digits from 0 to N-1
Example
Base 2 -> 0,1
Base 3 -> 0,1,2

Some special highlighted Bases are
Binary -> Base 2
Octal -> Base 8
Decimal -> Base 10
HexaDecimal -> Base 16
Note: HexaDecimal has given some special names in the form of Alphabets to 10, 11, 12, 13, 14 and 15.
HexaDecimal -> 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F

### Conversion of a number from Any base to Decimal
Suppose you want to convert a number of base 'x' to Decimal(Base 10).
The approach is simple,
To convert a number of any base to decimal, follow these steps:

1. Identify the base of the number.
2. Write down the digits of the number.
3. For each digit, multiply by the base raised to the power of its position, starting from the rightmost digit with position 0.
4. Sum all the products obtained from step 3.

Example: Convert the number 1011 from base 2 to decimal

1. The base of the number is 2.
2. The digits of the number are 1, 0, 1, and 1.
For each digit:
a. The rightmost digit (1) is multiplied by 2^0 (1)
b. The next digit to the left (1) is multiplied by 2^1 (2)
c. The next digit to the left (0) is multiplied by 2^2 (0)
d. The leftmost digit (1) is multiplied by 2^3 (8)

Sum the products: 1 + 2 + 8 = 11.
Therefore, the decimal equivalent of the binary number 1011 is 11.


### Conversion of a number from Decimal to Any base
To convert a decimal number to any base, follow these steps:

1. Identify the desired base.
2. Divide the decimal number by the base, and take the integer quotient as the next digit to the left.
3. Repeat step 2 using the remainder obtained in step 2 as the new decimal number.
4. Repeat steps 2 and 3 until the quotient is 0.
5. The remainders obtained in step 3, read from bottom to top, represent the digits of the converted number.
Example: Convert the decimal number 11 to base 2

1. The desired base is 2.
2. Divide 11 by 2: 11 / 2 = 5 with a remainder of 1.
3. Divide 5 by 2: 5 / 2 = 2 with a remainder of 1.
4. Divide 2 by 2: 2 / 2 = 1 with a remainder of 0.
5. Divide 1 by 2: 1 / 2 = 0 with a remainder of 1.

The remainders obtained in step 3, read from bottom to top, are the digits of the converted number: 1011.
Therefore, the binary equivalent of the decimal number 11 is 1011.

## Check if a Number is even or odd.
To check if a number is even or odd, you can use the modulus operator % to determine the remainder when the number is divided by 2. If the remainder is 0, the number is even. If the remainder is 1, the number is odd.s

## Find power of a number
The power of a number says how many times to use the number in a multiplication. Powers are also called Exponents or Indices.
1. If the power is 1, then you just have the number itself. For example, 5^1 = 5
2. If the power is 0, then you get 1. For example, 5^0 = 1
3. Negative exponent means how many times to divide one by the number.
Example->
-> 5^3 = 5 * 5 * 5 = 125.

## Find power of a number using fast exponentiation
Binary exponentiation (also known as exponentiation by squaring or fast exponentiation) is a trick which allows to calculate a^n  using only O(log n)  multiplications.
The idea of binary exponentiation is as follows:
1. 2^7 = 2 * (2*2)^3
2. 4^3 = 4 * (4*4)^1
3. 16^1 = 16 * 1



# count digits
1. Given a number, count all its digits.
Suppose number is 76543, then answer will be 5.
this is actually equal to log of that number base 10 +1, but why?.
You know how we reduce the number, right? we keep diving it by 10.

Note on TC.
When you do iteration and your logic depends on division by a number n.
You can say, TC will be of order log to the base n.

# Check if a Number is armstrong or not.
To check if a number is an Armstrong number, you can calculate the sum of its digits raised to the power of the number of digits. If the sum is equal to the original number, it is an Armstrong number.
For example, the number 153 is an Armstrong number because:
153 = 1^3 + 5^3 + 3^3

In general, an n-digit number x is an Armstrong number if:
x = a_1^n + a_2^n + ... + a_n^n

where a_i is the i-th digit of x and n is the number of digits in x.

Properties of armstrong numbers ->

1. All single-digit numbers are Armstrong numbers.

2. If a number is an Armstrong number, then all of its permutations (i.e., different arrangements of its digits) are also Armstrong numbers.

3. Armstrong numbers are always palindromic (i.e., the number remains the same when its digits are read from left to right and from right to left).

4. The sum of any two or more Armstrong numbers is not necessarily an Armstrong number.

# check if a number is palindrome
Two Simple steps.
1. Reverse the number
2. Check if it is equal to the orignal number.

# Find square root of a number using newton raphson method
Let N be any number then the square root of N can be given by the formula
root = 0.5 * (X + (N / X)) where X is any guess which can be assumed to be N or 1.
In the above formula, X is any assumed square root of N and root is the correct square root of N.
Tolerance limit is the maximum difference between X and root allowed.

Steps:
1. Assign X to the N itself.
2. Now, start a loop and keep calculating the root which will surely move
   towards the correct square root of N.
3. Check for the difference between the assumed X and calculated root,
   if not yet inside tolerance then update root and continue.
4. If the calculated root comes inside the tolerance allowed then break out of the loop.
5. Print/return the root as answer. 

# print all divisors of a number
Given a number 'N'
Take number 'i' from '1' to 'N' and check if ('N' % 'i') == '0', if yes, then 'i' is
a divisor of 'N'.

Note: To optimize the solution, take value of 'i' from '1' to square-root(N).
Because after the square root, the number keeps on dividing. 

# Check if a Number is prime or not. 
A number is prime, if it has only 2 factors, 1 and itself.
To check if a number is prime, you can iterate from 2 to the square root of the number, and check if the number is divisible by any of these numbers. If it is not divisible by any of these numbers, the number is prime.

## Sieve of Eratosthenes (Pronounce at your own risk)
Given a range 0 to N, find all prime numbers in this range.

The Sieve of Eratosthenes is an algorithm for finding all the prime numbers up to a specified integer. It works by iteratively marking as composite (i.e., not prime) the multiples of each prime, starting with 2. The remaining numbers are your answer.

# Find GCD of a number
The Euclidean algorithm is a way to find the greatest common divisor of two positive integers. GCD of two numbers is the largest number that divides both of them. A simple way to find GCD is to factorize both numbers and multiply common prime factors.

# Euclidean algorithm for finding GCD
If we subtract a smaller number from a larger one (we reduce a larger number), GCD doesn’t change. So if we keep subtracting repeatedly the larger of two, we end up with GCD.
Now instead of subtraction, if we divide the smaller number, the algorithm stops when we find the remainder 0.

To find the greatest common divisor (GCD) of two or more numbers, you can use the Euclidean algorithm. The Euclidean algorithm is a method for finding the GCD of two numbers by repeatedly dividing the larger number by the smaller number and taking the remainder until the smaller number is zero. The GCD is then equal to the last non-zero remainder.

Example:
To find the GCD of 60 and 48, you can perform the following steps:

Divide 60 by 48: 60 ÷ 48 = 1 with a remainder of 12
Divide 48 by 12: 48 ÷ 12 = 4 with a remainder of 0
The GCD is 12.

# Lcm of two numbers
if a and b are two numbers, then
lcm(a,b) * gcd(a,b) = a*b 

# Modular Arithmatics
1. (a mod m)+(b mod m)  mod m=a+b  mod m
2. (a mod m)−(b mod m)  mod m=a−b  mod m
3. (a mod m)*(b mod m)  mod m=a*b  mod m
4. (a % m) % m = a % m
5. m % m = 1 [true for all positive value of m]
6. (a / b) % m = (a % m) * ((b ^ -1) % m) % m

The modular multiplicative inverse of a number a is the number a^-1 such that a⋅a^−1  mod m=1
You may notice that this is similar to the concept of a reciprocal, but here we don't want a fraction, we want an integer, specifically an integer between 0 and m−1 inclusive.

# Factorial of a Number
!N = N * N-1 * N-2 .... *1 

# Find trailing zeros in a factorial
suppose you are given a number '456700442000'
can you calculate the number of zeros in it?
Yes, you can easily, simply use the extraction and reduction method to
extract the digits from the end and check if it is a non zero number.
1. if it is 0, add the count.
2. if it is non zero, break the loop.

count is your answer, simple!


But when you are asked to find trailing zeros from factorial of a number.
There is a high chance that this number might exceed the range of Integer/long and 
you can't store it!
So, if you can't store it, how will you find it's trailing zeros?
let's understand, what brings zero at the end of a number!

1. Suppose the number is '68'
lets find its factors->
68 = 2*2*17

2. Suppose the number is '70'
lets find its factors->
70 = 2*5*7

3. Suppose the number is '680'
680 = 2*2*2*5*17

4. Suppose the number is '6800'
6800 = 2*2*2*2*5*5*17

did you observe anything?

yes,

68 has zero pairs of 2 and 5.
70 has one pair of 2 and 5.
680 has one pair of 2 and 5.
6800 has two pair of 2 and 5.

Bs ho gya question solve!
find all the pairs of 2 and 5.

But but but...
lets come back to factorial.

!3 = 3*2*1
!7 = 7*6*5*4*3*2*1 (1 pair of 5,2)
!12 = 12*11*10*9*8*7*6*5*4*3*2*1 (2 pair of 5,2)

### Observations->
1. We can see that 2 will be there for every number greater than 1. (obviously)
so be smart and calculate only 5's because count of '2s' will always be greater 
than equal to count of '5s'.
2. 5 repeats in interval of 5.
ex -> 5, 10, 15, and so on

Therefore, floor of (N/5) will give the correct answer!
But wait what about squares, cubes and so on?
Like..
1. '5' has one '5'
2. '10' has one '5' (5*2)
3. '15' has one '5'
4. '20' has one '5'
5. '25' has two '5' (5*5, square)
....
6. '125' has three '5' (5*5*5, cube).

### conclusion->
To handle the special condition we can say.
1. for square case-> N/25 + N/5
2. for cube case-> N/125 + N/25 + N/5
3. and so on...

 Example ->
!30 = 30*29*28..*25*24*..*20*...*15*14*..*10*9*..5*4..*1 (7 pairs of 5,2)

Since 30 is greater than 25,
-> 30 / 5 + 30 / 25 
-> floor (6) + floor(1.2) 
-> 6 + 1
-> 7
