kata-mowitnow
=============

Three modules :
* io : responsability to move several mowers from io instructions
* battery : responsability to move several mowers
* mower : responsability to move a mower

Dependencies :

```
io --> battery --> mower
````

To compile and test :

``` 
gradle compile test
```
