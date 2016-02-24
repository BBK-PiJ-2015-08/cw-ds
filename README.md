Programming in Java - Coursework 2 - Data structures

Please note:

ArrayList

Arrays begin at size 32, set by DEFAULT_SIZE.
The method increaseSizeTwoFold is used by both add methods when the number of items equals the value of max, an int which starts
off matching DEFAULT_SIZE at 32, but doubles each time increaseSizeTwoFold is used. This method uses an intermediate storage array
to store the values in the original array in an array with double the previous max capacity, which is then assigned back to the original
array.
