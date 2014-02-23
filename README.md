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

To generate sonar reports if you have a default sonar installation on your local machine :

``` 
gradle clean test sonarRunner
```
