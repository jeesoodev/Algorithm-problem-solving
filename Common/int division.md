Int형의 나누기는 따로 형변환을 해주지 않으면 내림이 된다.

```java
        int a = 4;
        int b = 5;
        double t = a / b;
        double t2 = (double)a / b;

        System.out.println(t);
        System.out.println(t2);
```

결과
```
0.0
0.8
```
